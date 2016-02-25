package com.illucit.ejbremote;

import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
		System.out.printf("host  : %s\n", host);
		System.out.printf("port  : %s\n", port);
		System.out.printf("ejbURL: %s\n", ejbURL);
		
		Properties clientProperties = EjbRemoteUtil.createclientProperties(host, port);
		
		remotingContext = EjbRemoteUtil.createRemoteEjbContext(clientProperties);
		service = EjbRemoteUtil.createEjbProxy(remotingContext, ejbURL, ExampleService.class);
		
//	    Context context = new InitialContext(clientProperties);
//	    service = (ExampleService) context.lookup(ejbURL);
	    
		String toGreet = "RRrrrobbb!";
		String exampleResult;
		
		exampleResult = service.greet(toGreet);
		System.out.println(exampleResult);
		
		Map<Object, Object> systemProperties;
		systemProperties = service.getSystemProperties();
		System.out.println("Wildfly Home Dir: " + systemProperties.get("jboss.home.dir"));
	}
}
