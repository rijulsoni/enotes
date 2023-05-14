package com.DAO;

import java.sql.*;

import com.User.UserDetails;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(UserDetails us) {
		boolean f = false;
		try {
			String query = "insert into user(email,password,fullname) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			ps.setString(3, us.getName());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public UserDetails loginUser(UserDetails us) {
//	    boolean log = false;
		ResultSet rs = null;
		PreparedStatement ps = null;
		UserDetails user = null;
		try {
			String query = "SELECT * FROM user WHERE email=? AND password=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			rs = ps.executeQuery();

			if (rs.next()) {
				// If the query returns a row, update log to true
//	            log = true;
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
