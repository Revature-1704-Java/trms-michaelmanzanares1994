package com.revature.controller;

import java.io.IOException;
//import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.bean.Employee;
import com.revature.dao.EmployeeDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** Gathers emploees info and logs them in*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		EmployeeDAO dao = new EmployeeDAO();
		Employee user = dao.employeeLogin(username, password);
		HttpSession session = request.getSession(true);

		/**
		 * user is attached to the session by way of an attribute key Employee reference
		 * returned is associated with the current session via a call to setAttribute
		 */
		if (user == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			session.setAttribute("USERKEY", user);
			session.setAttribute("EMPIDKEY", user.getEmpId());
			session.setAttribute("FNAMEKEY", user.getFname());
			session.setAttribute("LNAMEKEY", user.getLname());
			session.setAttribute("EMAILKEY", user.getEmail());
			session.setAttribute("AVAILKEY", user.getAvailReimAmt());
			session.setAttribute("EMPKEYTYPEKEY", user.getEmpTypeId());
			session.setAttribute("USERNAMEKEY", user.getUsername());

			RequestDispatcher rd = request.getRequestDispatcher("dashboard.html");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
