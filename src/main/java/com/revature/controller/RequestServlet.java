package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.Request;
import com.revature.dao.RequestDAO;

public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO dao = new RequestDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * Takes input over the web, uses information and calls dao to access and modify
	 * database Uses employee's database information and submitted information to
	 * create a new request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		response.setContentType("text/html");

		if (session == null) {
			response.sendRedirect("index.jsp");
		} else {
			RequestDAO dao = new RequestDAO();
			int requestId = dao.numOfRequests();
			requestId += 1;
			int empId = (int) session.getAttribute("EMPIDKEY");
			int eventId = Integer.parseInt(request.getParameter("eventId"));
			int gradingFormatId = Integer.parseInt(request.getParameter("gradingFormat"));
			double cost = Double.parseDouble(request.getParameter("cost"));
			String workJust = request.getParameter("justification");
			int approvalState = 1;

			Request newRequest = new Request(requestId, empId, eventId, approvalState, gradingFormatId, cost, workJust);
			dao.create(newRequest);

			RequestDispatcher rd = request.getRequestDispatcher("dashboard.html");
			rd.forward(request, response);
		}
	}
}
