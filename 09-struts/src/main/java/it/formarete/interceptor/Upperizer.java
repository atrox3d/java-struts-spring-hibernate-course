package it.formarete.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

import it.formarete.action.Product;

public class Upperizer implements Interceptor {

	private static final long serialVersionUID = 1341462418281590300L;
	final static Logger logger = Logger.getLogger(Upperizer.class);

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		logger.info("yo");
		ValueStack stack = invocation.getStack();
		String name = stack.findString("name");
		if(name==null) {
			logger.info("name=null");
		}
		stack.set("name", name.toUpperCase());
		return invocation.invoke();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}


}
