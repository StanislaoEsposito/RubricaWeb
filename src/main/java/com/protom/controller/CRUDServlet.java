package com.protom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.protom.dto.User;
import com.protom.model.ContactDao;
import com.protom.model.entities.Contact;

/**
 * Servlet implementation class CRUDServlet
 */
@WebServlet("/CRUDServlet")
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		String action = request.getParameter("action");
		
		if(action != null && action.equals("Aggiungi") ) {
			System.out.println("-----------------------------Aggiungi");
			
			Contact c = new Contact();
					c.setName(request.getParameter("name"));
					c.setSurname(request.getParameter("surname"));

			ContactDao.insert(c);
			page= "/";
		}
		
		if(action != null && action.equals("Elimina") ) {
			String idS = request.getParameter("id");
			int id = Integer.parseInt(idS); 
			System.out.println("-----------------------------Elimina");
			Contact c = new Contact();
			c.setId(id);
			ContactDao.delete(c);
			page= "/";
		}
		
		if(action != null && action.equals("Aggiorna") ) {
			System.out.println("-----------------------------Aggiorna");
			String idS = request.getParameter("id");
			int id = Integer.parseInt(idS); 
			Contact c2 = new Contact();
			c2.setId(id);
			ContactDao.delete(c2);
			page = "/aggiorna.jsp";
			
				
		}
		if (action.equals("Aggiorna2")) {
			Contact c = new Contact();
			c.setName(request.getParameter("name"));
			c.setSurname(request.getParameter("surname"));
			ContactDao.update(c);
			page = "/";
		}
		
		response.sendRedirect(request.getContextPath() + page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
