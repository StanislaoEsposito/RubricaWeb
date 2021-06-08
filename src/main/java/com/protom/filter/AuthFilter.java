package com.protom.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/secure/*" })
public class AuthFilter extends HttpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4389933697461126191L;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpSession session = httpRequest.getSession(false);
		if( session != null && session.getAttribute("USER") != null ) {
			chain.doFilter(req, res);
		} else {
			httpRequest.getRequestDispatcher("/login.jsp").forward(req, res);
		}
	}

}
