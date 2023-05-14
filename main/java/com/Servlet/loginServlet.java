package com.Servlet;

import java.io.IOException;
import com.DAO.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.*;
import com.Db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Email: " + email + " Password: " + password);
		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		UserDAO dao = new UserDAO(DBConnect.getConn());
		UserDetails user = dao.loginUser(us);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("UserD", user);
			response.sendRedirect("home.jsp");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("login-failed", "Invalid Username And Password");

			response.sendRedirect("login.jsp");
		}
	}

}
