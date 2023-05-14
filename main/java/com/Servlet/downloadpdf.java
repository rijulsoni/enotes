package com.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import com.DAO.*;
import com.Db.DBConnect;
import com.User.Post;

@WebServlet("/downloadpdf")
public class downloadpdf extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the user ID from the request or session

		String userId = request.getParameter("userId");
		// Create an instance of the postDAO using your database connection
		postDAO dao = new postDAO(DBConnect.getConn()); // Replace DBUtil.getConnection() with your connection logic

		// Retrieve the posts for the given user ID
		List<Post> posts = dao.getData(userId);

		// Generate download links for the fileData
		for (Post post : posts) {
			byte[] fileData = post.getFileData();
			String fileName = "post_" + post.getId() + ".dat";

			String fileDataString = Base64.getEncoder().encodeToString(fileData);
			String downloadLink = "<a href=\"data:application/octet-stream;base64," + fileDataString + "\" download=\""
					+ fileName + "\">Download</a>";

			// Set the download link as a property of the post object
			post.setDownloadLink(downloadLink);
		}

		// Set the posts as an attribute in the request
		request.setAttribute("posts", posts);

		// Forward the request to a JSP or render the response
		request.getRequestDispatcher("pdfdownload.jsp").forward(request, response);
	}

	// Other methods for handling add, update, delete operations
}
