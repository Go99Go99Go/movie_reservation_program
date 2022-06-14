package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.java.util.Util_UI;

import java.sql.PreparedStatement;

public class RankDao extends DBConnection {

	static String driver = "org.mariadb.jdbc.Driver"; // jdbc드라이버
	static String url = "jdbc:mariadb://Localhost:3306/movie"; // jdbc:db이름://Localhost3306
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public RankDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dbClose() { // DB닫기
		try {
			if (rs != null) // ResultSet이 비어있지 않으면 ResultSet 닫기
				rs.close();
			if (stmt != null) // statement가 비어있지 않으면 statement 닫기
				stmt.close();
			if (pstmt != null)// preparetatement가 비어있지 않으면 preparetatement 닫기
				pstmt.close();
			if (con != null) // db 커넥션이 비어있지 않으면 닫기
				con.close();
		} catch (Exception e) {
			System.out.println(e + "=> DB닫기 실패");
		}
	}

	public void addRank(String name) { // 무비차트에 영화 추가하는 메서드
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("INSERT INTO rank_tb (movie_name) VALUES (?)"); // 영화 등록할때 rank_tb테이블에 영화추가
			pstmt.setString(1, name);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}

	public int updateRank(int price, int headCount, String name) { // 영화 예매할 때 수치를 반영해서 무비차트를 업데이트 메서드
		con = DBConnection.getConnection();
		try {
			//예매할때 무비차트테이블인 rank_tb에 예매하는 영화의 박스오피스에 총 금액을 더해주고 관객수도 예매한 인원만큼 더해주고 예매율을 계산해 수정하는 쿼리문
			//(예매율 = 예매인원/모든영화의 예매인원 * 100)
			pstmt = con.prepareStatement(
					"UPDATE rank_tb"
					+ " SET movie_percent = ROUND(movie_people/(SELECT SUM(movie_people) FROM rank_tb)*100, 1),"
					+ " movie_sales = movie_sales + ?,"
					+ " movie_people = movie_people + ?"
					+ " WHERE movie_name = ?");
			pstmt.setInt(1, price);
			pstmt.setInt(2, headCount);
			pstmt.setString(3, name);

			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return -1;
	}
}
