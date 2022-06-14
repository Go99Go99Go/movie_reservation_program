package com.java.jdbc;

public class MemberDto {
	
	private String pw;
	private String name;
	private String email;

	public MemberDto( String email, String pw,String name) {
		
		this.email = email;
		this.pw = pw;
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
