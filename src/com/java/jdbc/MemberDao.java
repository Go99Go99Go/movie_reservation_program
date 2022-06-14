package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.java.util.Util_UI;

import java.sql.PreparedStatement;

public class MemberDao extends DBConnection {
	
	static String driver = "org.mariadb.jdbc.Driver"; // jdbc드라이버
	static String url = "jdbc:mariadb://Localhost:3306/movie"; // jdbc:db이름://Localhost3306
	static String uid = "root"; 
	static String pwd = "1234";

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	public MemberDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dbClose() { // DB닫기
		try {
			if (rs != null)	//ResultSet이 비어있지 않으면 ResultSet 닫기
				rs.close();
			if (stmt != null) //statement가 비어있지 않으면 statement 닫기
				stmt.close();
			if (pstmt != null)//preparetatement가 비어있지 않으면 preparetatement 닫기
				pstmt.close();
			if (con != null) //db 커넥션이 비어있지 않으면 닫기
				con.close();
		} catch (Exception e) {
			System.out.println(e + "=> DB닫기 실패");
		}
	}

	public int signUp(MemberDto dto) { // 회원가입
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("insert into member_tb values(?, ?, ?)"); // 이메일, 비밀번호, 이름을 DB에 추가
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.executeUpdate();
			return 1; //반환값이 1이면 회원가입성공
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			dbClose();
		}
		return -1; //반환값이 1이 아니면 회원가입실패
	}

	public int login(String email, String pw) { // 로그인
		con = DBConnection.getConnection();
		try {
			// email 과  pw가 일치하는 name을 검색하는 쿼리문
			pstmt = con.prepareStatement("select * from member_tb where email = ? and pw = ?");
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1; //반환값이 1이면 로그인성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return -1; //반환값이 1이 아니면 로그인 실패
	}

	public int emailCheck(String email) { // 이메일 중복체크
		con = DBConnection.getConnection();
		try {
			//이미 테이블에 들어있는 값인지 확인
			pstmt = con.prepareStatement("select * from member_tb where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery(); 
			if (rs.next())
				return 1; //반환값이 1이면 이메일 중복없음
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return -1;//반환값이 1이 아니면 이메일 중복있음
	}
	
	public void findPw(String email, String name) { // 이메일과 이름으로 비밀번호 찾기
		con = DBConnection.getConnection();
		try {
			// 이메일과 비밀번호로 일치하는 이름검색
			pstmt = con.prepareStatement("SELECT pw from member_tb WHERE email = ? AND name = ?"); 
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery(); // 실행
			if (rs.next()) {
				Util_UI.pw = rs.getString(1); // 전역변수 name에 실행한 값을 저장
				JOptionPane.showMessageDialog(null, "비밀번호는 "+Util_UI.pw+"입니다.");
			}
			else
				JOptionPane.showMessageDialog(null, "일치하지않는 정보입니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}	
	}

	public void showName(String email, String pw) { // 로그인 후 로그인한 회원 이름 보여주기
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("SELECT name from member_tb WHERE email = ? AND pw = ?"); // 로그인할때 입력한 이메일과
																									// 비밀번호로 일치하는 이름검색
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery(); // 실행
			while (rs.next()) {
				Util_UI.name = rs.getString(1); // 전역변수 name에 실행한 값을 저장
				System.out.println(Util_UI.name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}

	}

}
