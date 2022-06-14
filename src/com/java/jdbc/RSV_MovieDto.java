package com.java.jdbc;

public class RSV_MovieDto {
	private String email;
	private String movie_location;
	private String movie_date;
	private String movie_name;
	private String movie_time;
	private String movie_runtime;
	private String movie_people;
	private String movie_hall;
	private String movie_seat;
	private String movie_now;
	private String movie_price;



	public RSV_MovieDto(String email, String movie_location, String movie_date, String movie_name, String movie_time,
			String movie_runtime, String movie_people, String movie_hall, String movie_seat, String movie_now,
			String movie_price) {

		this.email = email;
		this.movie_location = movie_location;
		this.movie_date = movie_date;
		this.movie_name = movie_name;
		this.movie_time = movie_time;
		this.movie_runtime = movie_runtime;
		this.movie_people = movie_people;
		this.movie_hall = movie_hall;
		this.movie_seat = movie_seat;
		this.movie_now = movie_now;
		this.movie_price = movie_price;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMovie_location() {
		return movie_location;
	}



	public void setMovie_location(String movie_location) {
		this.movie_location = movie_location;
	}



	public String getMovie_date() {
		return movie_date;
	}



	public void setMovie_date(String movie_date) {
		this.movie_date = movie_date;
	}



	public String getMovie_name() {
		return movie_name;
	}



	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}



	public String getMovie_time() {
		return movie_time;
	}



	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}



	public String getMovie_runtime() {
		return movie_runtime;
	}



	public void setMovie_runtime(String movie_runtime) {
		this.movie_runtime = movie_runtime;
	}



	public String getMovie_people() {
		return movie_people;
	}



	public void setMovie_people(String movie_people) {
		this.movie_people = movie_people;
	}



	public String getMovie_hall() {
		return movie_hall;
	}



	public void setMovie_hall(String movie_hall) {
		this.movie_hall = movie_hall;
	}



	public String getMovie_seat() {
		return movie_seat;
	}



	public void setMovie_seat(String movie_seat) {
		this.movie_seat = movie_seat;
	}



	public String getMovie_now() {
		return movie_now;
	}



	public void setMovie_now(String movie_now) {
		this.movie_now = movie_now;
	}



	public String getMovie_price() {
		return movie_price;
	}



	public void setMovie_price(String movie_price) {
		this.movie_price = movie_price;
	}
	




}
