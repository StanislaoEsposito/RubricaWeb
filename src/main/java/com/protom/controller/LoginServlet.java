package com.protom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.protom.dto.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User()
				.setPassword(request.getParameter("password"))
				.setUsername(request.getParameter("username"));
		
		if( user.getUsername() != null && user.getUsername().equals("root") && user.getPassword().equals("root")) {
			System.out.println("-----------------------------login");
			HttpSession session = request.getSession();
			session.setAttribute("USER", user);
		}
		
		String action = request.getParameter("action");
		if(action != null && action.equals("logout") ) {
			System.out.println("-----------------------------logout");
			HttpSession session = request.getSession();
			session.invalidate();
		}
//		
//		ServletContext context= getServletContext();
//		RequestDispatcher rd= context.getRequestDispatcher("/");
//		rd.forward(request, response);
//		
//		response.sendRedirect(request.getContextPath() + "IndexServlet");
		
		
//		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
