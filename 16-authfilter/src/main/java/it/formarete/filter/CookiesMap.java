package it.formarete.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class CookiesMap implements Filter {
	private String[] cookieNames;
	final static Logger logger = Logger.getLogger(CookiesMap.class);
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		String initParameter = config.getInitParameter("cookieNames");
		if(initParameter != null) {
			cookieNames = initParameter.split(",");
			logger.info(Arrays.toString(cookieNames));
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		logger.info("CookiesMap.doFilter");
		logger.info("cookie list:");
		logger.info("------------------------------------------");
		Map<String, String> cookies = new HashMap<String, String>();
		for (Cookie cookie : httpRequest.getCookies()) {
			if(cookieNames != null && cookieNames.length >0) {
				logger.info(String.format("cookie=%s:%s", cookie.getName(), cookie.getValue()));
				request.setAttribute(cookie.getName(), cookie.getValue());
			}
			cookies.put(cookie.getName(), cookie.getValue());
		}
		logger.info("------------------------------------------");
		request.setAttribute("cookies", cookies);
		chain.doFilter(httpRequest, response);
	}

	@Override
	public void destroy() {
	}
}
