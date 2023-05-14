package com.Servlet;

import java.io.IOException;
import com.DAO.postDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DBConnect;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer noteid = Integer.parseInt(request.getParameter("note_id"));
		postDAO dao = new postDAO(DBConnect.getConn());
		boolean f = dao.DeleteNotes(noteid);
		if (f) {
			HttpSession session = request.getSession();
			session.setAttribute("update-data", "Notes Deleted Successfully");
			response.sendRedirect("showNotes.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("Error-Delete-Notes", "Something Went Wrong");
			response.sendRedirect("showNotes.jsp");
		}

	}

}
