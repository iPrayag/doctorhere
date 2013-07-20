package com.zazzercode.doctorhere.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
// @WebServlet(name = "LoginController", urlPatterns = { "/login" }, value =
// "login")
public class LoginController extends HttpServlet {
	private Logger logger = Logger.getLogger(LoginController.class.getName());

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginController() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		logger.info("name : " + name);
		if (name != null && name.equals("prayag.upd@gmail.com") && password != null && password.equals("123456")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", name);

			request.setAttribute("name", name);
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/main.jsp");
			dispatcher.include(request, response);
			// response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
