package com.illucit.ejbremote;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.illucit.ejbremote.server.ExampleService;

public class TestRemoteClient {
	    public static void main(String[] args) {
	       
	        Properties props = new Properties();
	 
	        final String bean = "ejb://ejb-remote-server/ExampleServiceImpl!com.illucit.ejbremote.server.ExampleService";
	 
	        ExampleService service;
	        System.out.println("Testing with: " + bean);
	             
	        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	        props.put(Context.PROVIDER_URL, "http-remoting://localhost:1339");
	        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
	        props.put(Context.SECURITY_PRINCIPAL, "guest");
	        props.put(Context.SECURITY_CREDENTIALS, "guest");
	 
	        // to avoid: java.lang.IllegalStateException: EJBCLIENT000025: No EJB receiver available
	        props.put("jboss.naming.client.ejb.context", true);
	        try {
	            final Context context = new InitialContext(props);
	          
	            service = (ExampleService) context.lookup(bean);
	            
	            System.out.println("Lookup complete");
	 
	            service.greet("roby");
	            // context.close();   // throws: java.util.concurrent.RejectedExecutionException
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	    }
	
}
