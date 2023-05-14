package com.User;

public class UserDetails {
	private int id;
	private String name;

	private String email;
	private String password;

	public UserDetails() {
		super();
	}

	public UserDetails(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String setEmail(String email) {
		this.email = email;
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		this.password = password;
		return password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
