package it.formarete.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Logout.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String USER = (String) request.getAttribute("USER");
		logger.info("USER="+USER);
		request.removeAttribute("USER");
		USER = (String) request.getAttribute("USER");
		logger.info("USER="+USER);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie[] cookies = httpRequest.getCookies();
		for(Cookie cookie : cookies) {
			logger.info("cookie=" + cookie.getName() + ":" + cookie.getValue());
			if(cookie.getName().equals("USER")) {
				cookie.setMaxAge(0);
				httpResponse.addCookie(cookie);
				logger.info("USER cookie deleted");
			}
		}
		
		httpResponse.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
