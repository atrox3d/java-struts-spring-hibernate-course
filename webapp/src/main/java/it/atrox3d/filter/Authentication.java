package it.atrox3d.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import it.atrox3d.servlet.Servlet;

public class Authentication implements Filter {
	
	final static Logger logger = Logger.getLogger(Authentication.class);

	private String userName;
	private String password;

    public Authentication() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
    	userName = fConfig.getInitParameter("userName");
    	password= fConfig.getInitParameter("password");
    	
    	logger.debug("userName : " + userName);
    	logger.debug("password: " + password);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("test");
		String userName;
		String password;
		String message = "";
		
		userName = request.getParameter("userName");
		logger.debug("this.userName : " + this.userName);
		logger.debug("userName : " + userName);

		password= request.getParameter("password");
		logger.debug("this.password : " + this.password);
		logger.debug("password : " + password);
		
		if(!this.userName.equals(userName)) {
			message = "wrong user<br>";
		}

		if(!this.password.equals(password)) {
			message = message + "wrong password<br>";
		}
		
		request.setAttribute("message", message);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
