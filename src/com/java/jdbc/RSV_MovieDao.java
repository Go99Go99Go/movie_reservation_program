package com.java.jdbc;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.util.Util_UI;
import com.sun.javafx.collections.MappingChange.Map;

import java.sql.PreparedStatement;

public class RSV_MovieDao extends DBConnection {
	static String driver = "org.mariadb.jdbc.Driver"; // jdbc드라이버
	static String url = "jdbc:mariadb://Localhost:3306/movie"; // jdbc:db이름://Localhost3306
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public RSV_MovieDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dbClose() { // DB닫기
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println(e + "=> DB닫기 실패");
		}
	}

	public int addRSV_Movie(RSV_MovieDto dto) { //전역변수에 넣어진 값을 바탕으로 예약테이블에 예약정보추가하기
		con = DBConnection.getConnection();
		try {
			 // 예약된 영화정보를 테이블에 추가해주는 쿼리문
			pstmt = con.prepareStatement("insert into rsv_movie_tb values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getMovie_location());
			pstmt.setString(3, dto.getMovie_date());
			pstmt.setString(4, dto.getMovie_name());
			pstmt.setString(5, dto.getMovie_time());
			pstmt.setString(6, dto.getMovie_runtime());
			pstmt.setString(7, dto.getMovie_people());
			pstmt.setString(8, dto.getMovie_hall());
			pstmt.setString(9, dto.getMovie_seat());
			pstmt.setString(10, dto.getMovie_now());
			pstmt.setString(11, dto.getMovie_price());
			pstmt.executeUpdate();
			return 1; //반환값이 1이면 예약정보추가성공
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			dbClose();
		}
		return -1; //반환값이 1이 아니면 예약정보추가실패
	}

	public int delRSV_Movie(String email, String now) { // 예약취소하기
		con = DBConnection.getConnection();
		try {
			// 로그인한 사람이 동시에 예매를 할 수 없기때문에 중복될수없는 예매할때 나온 시간을 대조해서 예매취소
			pstmt = con.prepareStatement("delete from rsv_movie_tb where email = ? and movie_now = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, now);
			rs = pstmt.executeQuery();
			return 1; // 삭제성공
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			dbClose();
		}
		return -1; // 삭제실패
	}

}
