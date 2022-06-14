package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	public static Connection getConnection() {
		String url="jdbc:mariadb://Localhost:3306/movie";
		String id="root";
		String pw="1234";
		String driver="org.mariadb.jdbc.Driver";
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, id, pw);
			System.out.println("DB연결 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB연결 실패");
		}
		return con;
	}
	
	
	public static void main(String[] args) {
		getConnection();
	}
}
