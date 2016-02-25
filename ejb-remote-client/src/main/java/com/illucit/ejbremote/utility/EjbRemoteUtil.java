package com.illucit.ejbremote.utility;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbRemoteUtil {


	@SuppressWarnings("unchecked")
	public static <T> T createEjbProxy(
											Context remotingContext, 
											String ejbUrl, 
											Class<T> ejbInterfaceClass
										)
			throws NamingException, ClassCastException {
		Object resolvedproxy = remotingContext.lookup(ejbUrl);
		return (T) resolvedproxy;
	}
	
	public static String getEjbURL(
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
	
	public static Properties createclientProperties(String host, String port) {
	
		Properties props = new Properties();
	
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	
//		props.put("jboss.naming.client.ejb.context", "false");
		props.put("org.jboss.ejb.client.scoped.context", "true");
//	
//		props.put("endpoint.name", "client-endpoint");
		props.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);

//		props.put("remote.connections", "default");
		props.put("remote.connection.default.host", host);
		props.put("remote.connection.default.port", port);
//		props.put("remote.connection.default.username", "ejb");
//		props.put("remote.connection.default.password", "password1!");

		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");	

		return props;
	}
	
	public static Context createRemoteEjbContext(Hashtable<Object, Object> props) throws NamingException {
		return new InitialContext(props);
	}
}
