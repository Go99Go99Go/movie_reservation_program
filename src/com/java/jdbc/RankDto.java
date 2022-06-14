package com.java.jdbc;

public class RankDto {
	
	private String movie_name;
	private float movie_percent;
	private int movie_sales;
	private int movie_people;
	
	public RankDto(String movie_name, float movie_percent, int movie_sales, int movie_people) {
		this.movie_name = movie_name;
		this.movie_percent = movie_percent;
		this.movie_sales = movie_sales;
		this.movie_people = movie_people;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public float getMovie_percent() {
		return movie_percent;
	}

	public void setMovie_percent(float movie_percent) {
		this.movie_percent = movie_percent;
	}

	public int getMovie_sales() {
		return movie_sales;
	}

	public void setMovie_sales(int movie_sales) {
		this.movie_sales = movie_sales;
	}

	public int getMovie_people() {
		return movie_people;
	}

	public void setMovie_people(int movie_people) {
		this.movie_people = movie_people;
	}

	
	
	
	

}
