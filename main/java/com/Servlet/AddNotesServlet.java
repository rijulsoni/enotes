package com.Servlet;

import com.Db.DBConnect;
import com.DAO.postDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/AddNotesServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddNotesServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uidString = request.getParameter("uid");
		if (uidString != null) {
			try {
				int uid = Integer.parseInt(uidString);
				String title = request.getParameter("title");
				String content = request.getParameter("content");

				Part filePart = request.getPart("file");

				postDAO dao = new postDAO(DBConnect.getConn());
				boolean f = dao.addNotes(title, content, uid, filePart);

				if (f) {
					System.out.print("Data Insert Successfully");
					response.sendRedirect("showNotes.jsp");
				} else {
					System.out.print("Data Is Not Inserted Successfully");
				}
			} catch (NumberFormatException e) {
				System.out.print("Invalid uid format. Please provide a valid integer.");
				e.printStackTrace();
			}
		} else {
			System.out.print("uid parameter is null. Please provide a valid uid.");
		}
	}
}
