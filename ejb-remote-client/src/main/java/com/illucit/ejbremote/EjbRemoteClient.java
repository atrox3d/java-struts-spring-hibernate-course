package com.illucit.ejbremote;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.illucit.ejbremote.server.ExampleService;
import com.illucit.ejbremote.server.ExampleServiceImpl;

public class EjbRemoteClient {

	public static void main(String[] args) throws NamingException, ClassCastException  {
		String host = "localhost";
		String port = String.valueOf(1339);
		String ejbURL = "";
		Context remotingContext;
		ExampleService service;
		
		ejbURL = getEjbURL(
								"", 
								"ejb-remote-server", 
								ExampleServiceImpl.class.getSimpleName(), 
								ExampleService.class.getName()
							);
		
		System.out.printf("host  : %s\n", host);
		System.out.printf("port  : %s\n", port);
		System.out.printf("ejbURL: %s\n", ejbURL);
		
		remotingContext = createRemoteEjbContext(host, port);
		
		service = createEjbProxy(remotingContext, ejbURL, ExampleService.class);
		
		String toGreet = "RRrrrobbb!";
		String exampleResult;
		
		exampleResult = service.greet(toGreet);
	}

	@SuppressWarnings("unchecked")
	private static <T> T createEjbProxy(
											Context remotingContext, 
											String ejbUrl, 
											Class<T> ejbInterfaceClass
										)
			throws NamingException, ClassCastException {
		Object resolvedproxy = remotingContext.lookup(ejbUrl);
		return (T) resolvedproxy;
	}
	
	private static String getEjbURL(
										String appName,
										String moduleName,
										String beanName,
										String remoteView
									) 
	{
		String protocol = "ejb:";
		String ejbURL;
		
		ejbURL = String.format("%s/%s/%s/%s!%s", 
									protocol,
									appName,
									moduleName,
									beanName,
									remoteView
							);
		return ejbURL;
	}
	
	private static Context createRemoteEjbContext(String host, String port) throws NamingException {
	
		Hashtable<Object, Object> props = new Hashtable<>();
	
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	
		props.put("jboss.naming.client.ejb.context", false);
		props.put("org.jboss.ejb.client.scoped.context", true);
	
		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		props.put("remote.connections", "default");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
	
		props.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
		props.put("remote.connection.default.host", host);
		props.put("remote.connection.default.port", port);
	
		return new InitialContext(props);
	}
}
