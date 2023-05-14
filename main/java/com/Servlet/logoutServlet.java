package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			HttpSession session = request.getSession();

			session.removeAttribute("UserD");
			HttpSession session1 = request.getSession();
			session1.setAttribute("logoutmessage", "Logout-successful");
			response.sendRedirect("login.jsp");
		} catch (Exception e0) {
			e0.printStackTrace();
		}

	}
}