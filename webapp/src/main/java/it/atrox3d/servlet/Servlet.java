package it.atrox3d.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(Servlet.class);
	
	private String testParam;
	//private String logHead = this.getClass().getSimpleName() + " : ";

       
    public Servlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		testParam = config.getInitParameter("testParam");
		//System.out.println(logHead + "init : " + "testParam:" + testParam);
		logger.debug("testParam : " + testParam);
	}
	
	private void printHTML(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    response.setContentType("text/html");
	    
	    PrintWriter out = response.getWriter(); 

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>printHTML</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.append("Served at: ").append(request.getContextPath()).append("<br>");

		String message = (String)request.getAttribute("message");
		
		if(!message.equals("")) {
			message = "<font color='red'>" + message + "</font>";
		}
		out.append(message).append("<br>");

		Map<String, String[]> params = request.getParameterMap();
		for(String key:params.keySet()) {
			
			String[] values = params.get(key);

			for(String val:values){
				out.append(key + ":" + val + "<br>");
				logger.debug(key + ":" + val);
			}
			
		}
	    out.println("</body>");
	    out.println("</html>");
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = (String)request.getAttribute("message");
		logger.debug(message);
		request.getRequestDispatcher("/servlet.jsp").forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean forward = request.getParameter("forward")!=null;
		logger.debug("forward parameter : '" + forward + "'");
		logger.debug("forward parameter isnull: '" + forward + "'");

		if(forward) {
			logger.debug("forward detected");
			forward(request, response);
		} else {
			printHTML(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
