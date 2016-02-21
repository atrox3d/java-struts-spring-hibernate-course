package com.theopentutorials.ejb3;
 
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
public class ClientUtility {
    private static Context initialContext;
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            System.out.println("Context.URL_PKG_PREFIXES:" + Context.URL_PKG_PREFIXES);
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }
}
