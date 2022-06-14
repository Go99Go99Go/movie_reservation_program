package com.java.jdbc;

public class MovieDto {
	private String movie_name;
	private String movie_date;
	private String movie_location;
	private String movie_hall;
	private String movie_time;
	private String movie_Runtime;
	
	public MovieDto( String movie_name, String movie_location, String movie_date,  String movie_Runtime , String movie_time , String movie_hall) {

		this.movie_name = movie_name;
		this.movie_location = movie_location;
		this.movie_date = movie_date;
		this.movie_Runtime = movie_Runtime;
		this.movie_time = movie_time;
		this.movie_hall = movie_hall;

	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_date() {
		return movie_date;
	}

	public void setMovie_date(String movie_date) {
		this.movie_date = movie_date;
	}

	public String getMovie_location() {
		return movie_location;
	}

	public void setMovie_location(String movie_location) {
		this.movie_location = movie_location;
	}

	public String getMovie_hall() {
		return movie_hall;
	}

	public void setMovie_hall(String movie_hall) {
		this.movie_hall = movie_hall;
	}

	public String getMovie_time() {
		return movie_time;
	}

	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}

	public String getMovie_Runtime() {
		return movie_Runtime;
	}

	public void setMovie_Runtime(String movie_Runtime) {
		this.movie_Runtime = movie_Runtime;
	}

	
	
	
}
