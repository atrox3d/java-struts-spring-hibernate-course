package it.formarete.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;

	@Override
	public void init(ServletConfig config) throws ServletException {
		name = config.getInitParameter("name");
	}
	
	@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {
		
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		//out.println("<h1>Hello " + username + "!</h1>");
	};

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String username = request.getParameter("username");
		if (username == null || username == "") {
			username = "nobody";
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello " + username + "!</h1>");
		out.println("<p>Altro che " + name + "</p>");
	}
}
