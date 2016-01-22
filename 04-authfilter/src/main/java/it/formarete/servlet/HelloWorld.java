package it.formarete.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Override
	public void init(javax.servlet.ServletConfig config) 
			throws ServletException {
		name = config.getInitParameter("name");
		System.out.println("HelloWorld:init:reading config : " + config.getServletName());
		System.out.println("HelloWorld:init:name = " + name);
	};
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("HelloWorld:doPost");
		
		String username = request.getParameter("username");
		if(username == null) {
			username = "nobody";
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello " + username + "!</h1>");
		out.println("<h1>altro che  " + name + "!</h1>");
	}

	
}
