package com.protom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.protom.model.ContactDao;
import com.protom.model.entities.Contact;
import com.protom.model.entities.Email;
import com.protom.model.entities.Phone;

/**
 * Servlet implementation class DettaglioServlet
 */
@WebServlet("/DettaglioServlet")
public class DettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettaglioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		List<Phone> phonesList = ContactDao.dettaglioPhones(id);
		request.setAttribute("phonesList", phonesList);
		List<Email> emailsList = ContactDao.dettaglioEmails(id);
		request.setAttribute("emailsList", emailsList);
		
		request.setAttribute("name", name);
		request.setAttribute("surname", surname);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
