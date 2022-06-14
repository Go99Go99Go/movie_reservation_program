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

import com.sun.javafx.collections.MappingChange.Map;

import java.sql.PreparedStatement;

public class MovieDao extends DBConnection {
	static String driver = "org.mariadb.jdbc.Driver"; // jdbc드라이버
	static String url = "jdbc:mariadb://Localhost:3306/movie"; // jdbc:db이름://Localhost3306
	static String uid = "root";
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MovieDao() {
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

	public int addMovie(MovieDto dto) { // 영화추가하기
		con = DBConnection.getConnection();
		try {
			// movie테이블에 영화 이름, 상영 지역, 상영날짜, 상영 길이, 상영 시간, 상영관을 추가
			pstmt = con.prepareStatement("insert into movie_tb values(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, dto.getMovie_name());
			pstmt.setString(2, dto.getMovie_location());
			pstmt.setString(3, dto.getMovie_date());
			pstmt.setString(4, dto.getMovie_Runtime());
			pstmt.setString(5, dto.getMovie_time());
			pstmt.setString(6, dto.getMovie_hall());
			pstmt.executeUpdate();
			return 1; // 영화추가성공
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			dbClose();
		}
		return -1; // 영화추가실패
	}

	public int delMovie(MovieDto dto) { // 영화삭제하기
		con = DBConnection.getConnection();
		try {
			// 입력한 텍스트필드랑 일치하는 조건을 가진 영화를 삭제하는 쿼리문
			pstmt = con.prepareStatement("delete from movie_tb where movie_name = ? "
					+ "AND movie_location = ? AND movie_date = ? AND movie_runtime = ? "
					+ "AND movie_time = ? AND movie_hall = ?");
			pstmt.setString(1, dto.getMovie_name());
			pstmt.setString(2, dto.getMovie_location());
			pstmt.setString(3, dto.getMovie_date());
			pstmt.setString(4, dto.getMovie_Runtime());
			pstmt.setString(5, dto.getMovie_time());
			pstmt.setString(6, dto.getMovie_hall());
			pstmt.executeUpdate();
			return 1; // 1이면 삭제 성공
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			dbClose();
		}
		return -1; // 1이 아니면 삭제 실패
	}
}
