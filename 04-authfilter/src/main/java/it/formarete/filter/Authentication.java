package it.formarete.filter;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentication implements Filter {
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		User user = null;
		
		String userName = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		
		user = UsersDB.get(userName);
		
		if( user != null && user.getPassword().equals(password)) {
			chain.doFilter(request, response);
			return;
		}
		
		httpRequest.setAttribute("destination", httpRequest.getRequestURI());
		if(userName != null || password != null) {
			request.setAttribute("message", "nome utente e password nonc orrispondono, riprova");
		}
		httpRequest.getRequestDispatcher("/login.jsp").forward(httpRequest, httpResponse);
		// la forward non cambia l'url
	}

	@Override
	public void destroy() {
	}

}
