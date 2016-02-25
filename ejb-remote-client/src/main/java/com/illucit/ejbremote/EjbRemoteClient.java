package com.illucit.ejbremote;

//import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//import org.jboss.ejb.client.ContextSelector;
//import org.jboss.ejb.client.EJBClientConfiguration;
//import org.jboss.ejb.client.EJBClientContext;
//import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
//import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

import com.illucit.ejbremote.server.ExampleService;
import com.illucit.ejbremote.server.ExampleServiceImpl;
import com.illucit.ejbremote.utility.EjbRemoteUtil;

public class EjbRemoteClient {

	public static void main(String[] args) throws NamingException, ClassCastException  {
		String host = "localhost";
		String port = String.valueOf(1339);
		String ejbURL = "";
		Context remotingContext;
		ExampleService service;
		
		ejbURL = EjbRemoteUtil.getEjbURL(
								"", 
								"ejb-remote-server", 
								ExampleServiceImpl.class.getSimpleName(), 
								ExampleService.class.getName()
							);
		
		System.out.println("getEjbURL() = " + ejbURL);
		
		//ejbURL = "ejb:/ejb-remote-server/ExampleServiceImpl!com.illucit.ejbremote.server.ExampleService";
		
		//System.out.println("manual URL  = " + ejbURL);
		
		System.out.printf("host  : %s\n", host);
		System.out.printf("port  : %s\n", port);
		System.out.printf("ejbURL: %s\n", ejbURL);
		
		Properties clientProperties = EjbRemoteUtil.createclientProperties(host, port);
		
		remotingContext = EjbRemoteUtil.createRemoteEjbContext(clientProperties);
		service = EjbRemoteUtil.createEjbProxy(remotingContext, ejbURL, ExampleService.class);
		
//	    EJBClientConfiguration ejbClientConfiguration = 
//	    		new PropertiesBasedEJBClientConfiguration(clientProperties);
//	    
//	    ContextSelector<EJBClientContext> contextSelector = 
//	    		new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);
//	    
//	    EJBClientContext.setSelector(contextSelector);
//	    
//	    Properties properties = new Properties();
//	    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//		clientProperties.put("jboss.naming.client.ejb.context", "true");	    
	    Context context = new InitialContext(clientProperties);
	    
	    service = (ExampleService) context.lookup(ejbURL);
	    
		String toGreet = "RRrrrobbb!";
		String exampleResult;
		
		exampleResult = service.greet(toGreet);
		
		System.out.println(exampleResult);
	}
}
