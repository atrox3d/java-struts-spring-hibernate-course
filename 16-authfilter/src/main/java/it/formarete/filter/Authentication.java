package it.formarete.filter;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Authentication implements Filter {
	final static Logger logger = Logger.getLogger(Authentication.class);

	@Override
	public void init(FilterConfig config) throws ServletException {
		logger.info("init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		User user = null;
		
		logger.info("doFilter");
		String USER = (String) request.getAttribute("USER");
		logger.info("USER=" + USER);
		/*
		Map<String, String> cookies = (Map<String, String>) request
				.getAttribute("cookies");
		String cookieValue = cookies.get("USER");// getCookie(httpRequest, "USER");
		*/
		user = UsersDB.get(USER);
		logger.info("user=" + user);
		if (user != null) {
			httpRequest.setAttribute("user", user);
			chain.doFilter(request, response);
			return;
		}

		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");
		logger.info("username=" + username);
		logger.info("password=" + password);
		user = UsersDB.get(username);
		logger.info("user=" + user);

		if (user != null && user.getPassword().equals(password)) {
			httpResponse.addCookie(new Cookie("USER", user.getUsername()));
			httpRequest.setAttribute("user", user);
			chain.doFilter(request, response);
			return;
		}

		httpRequest.setAttribute("destination", httpRequest.getRequestURI());
		if (username != null || password != null) {
			httpRequest.setAttribute("message",
					"nome utente e password non corrispondono, riprova");
		}
		
		//
		//	forward non cambia l'URL nel browser
		//	alternativamente si usa sendRedirect
		//
		httpRequest.getRequestDispatcher("/login.jsp").forward(httpRequest,
				httpResponse);
	}

	@Override
	public void destroy() {
	}

	
	/*
	private String getCookie(HttpServletRequest httpRequest, String name) {
		String cookieValue = null;
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			int i = 0;
			while (i < cookies.length && cookieValue == null) {
				Cookie cookie = cookies[i];
				if (name.equals(cookie.getName())) {
					cookieValue = cookie.getValue();
				}
				i++;
			}
		}
		return cookieValue;
	}
	*/
}
