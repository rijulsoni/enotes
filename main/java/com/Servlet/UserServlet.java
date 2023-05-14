package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.*;
import com.DAO.*;
import com.Db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setName(name);
		us.setPassword(password);
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.addUser(us);
		HttpSession session;

		if (f) {

			session = request.getSession();
			session.setAttribute("register-successful", "Registration Successful");
			response.sendRedirect("register.jsp");
		} else {
			session = request.getSession();
			session.setAttribute("register-failed", "Something Went Wrong");
			response.sendRedirect("register.jsp");
		}
	}

}
