package com.DAO;

import com.User.Post;
import com.mysql.cj.jdbc.Blob;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.Part;
import com.User.Post;

public class postDAO {
	private Connection conn;

	public postDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addNotes(String ti, String co, int ui, Part filePart) {
		boolean f = false;
		try {
			String query = "INSERT INTO notesdata (title, content, uid, fileData) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);
			ps.setBinaryStream(4, filePart.getInputStream());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			if (e.getMessage().contains("Incorrect integer value")) {
				System.out.println("Invalid uid value. Please provide a valid integer.");
			} else {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Post> getData(int id) {
		List<Post> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM notesdata WHERE uid = ? ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				p.setPdate(rs.getTime(4));

				// Retrieve binary data as com.mysql.cj.jdbc.Blob
				com.mysql.cj.jdbc.Blob fileDataBlob = (com.mysql.cj.jdbc.Blob) rs.getBlob(5);
				// Convert com.mysql.cj.jdbc.Blob to byte array
				byte[] fileDataBytes = fileDataBlob.getBytes(1, (int) fileDataBlob.length());
				p.setFileData(fileDataBytes);

				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Post getDataById(int noteid) {
		Post p = null;
		try {
			String query = "select *from notesdata where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, noteid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean PostUpdate(int noteid, String ti, String con) {
		boolean f = false;
		try {
			String query = "update notesdata set title=?,content=?  where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, con);
			ps.setInt(3, noteid);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}

	public boolean DeleteNotes(int uid) {
		boolean f = false;
		try {
			String query = "delete from notesdata  where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}
}
