package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DBConnect;
import com.DAO.*;

@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Integer noteid = Integer.parseInt(request.getParameter("note_id"));
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");
			postDAO dao = new postDAO(DBConnect.getConn());
			boolean f = dao.PostUpdate(noteid, Title, Content);
			if (f) {
				HttpSession session = request.getSession();
				session.setAttribute("update-data", "Notes Update Succesfully");
				response.sendRedirect("showNotes.jsp");
				System.out.print("Data Update Successful");
			} else {
				System.out.print("Data Update Unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
