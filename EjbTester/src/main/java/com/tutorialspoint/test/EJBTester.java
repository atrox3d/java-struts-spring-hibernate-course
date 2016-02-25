package com.tutorialspoint.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.tutorialspoint.stateless.LibrarySessionBeanRemote;
import com.tutorialspoint.stateless.LibrarySessionBean;
import com.tutorialspoint.test.EjbRemoteUtil;

public class EJBTester {

	BufferedReader brConsoleReader = null;
	Properties props;
	InitialContext ctx;
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
    String host = "localhost";
    String port = "1339";
	
	{
		props = new Properties();
		try {
			props.load(new FileInputStream("jndi.properties"));
			System.out.println("----------------------------------------------------------------");
			System.out.println("properties loading succeded:");
			System.out.println("----------------------------------------------------------------");
	        for(Object prop: props.keySet().toArray()) {
	        	System.out.printf("property: %-30s = %s\n", prop, props.getProperty((String) prop));
	        }
			System.out.println("----------------------------------------------------------------");
		} catch (IOException ex) {
			//
			//	fallback
			//
			System.out.println("----------------------------------------------------------------");
			System.out.println("properties loading failed!");
			System.out.println("----------------------------------------------------------------");
	        System.out.printf("properties.put: %-30s = %s\n", Context.URL_PKG_PREFIXES, PKG_INTERFACES);
	        System.out.printf("properties.put: %-30s = %s\n", "java.naming.provider.url", "localhost");
	        System.out.printf("properties.put: %-30s = %s\n", "jboss.naming.client.ejb.context", "true");
			System.out.println("----------------------------------------------------------------");
	        props.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
	        //props.put("java.naming.provider.url", "localhost");
	        //props.put("jboss.naming.client.ejb.context", "true");
			props.put("org.jboss.ejb.client.scoped.context", "true");
			props.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
			props.put("remote.connections", "default");
			props.put("remote.connection.default.host", host);
			props.put("remote.connection.default.port", port);
		}
		
        brConsoleReader = new BufferedReader(
					new InputStreamReader(System.in)
				);
	}
	
	public static void main(String [] args) {
		EJBTester ejbTester = new EJBTester();
		ejbTester.testStatelessEjb();
	}
	
	private void showGUI() {
	      System.out.println("**********************");
	      System.out.println("Welcome to Book Store");
	      System.out.println("**********************");
	      System.out.println("Options:");
	      System.out.println("1. Add Book");
	      System.out.println("2. Exit");
	      System.out.println("Enter Choice:");
	 }
    
	public String getLookupName() {
        /*
         * The app name is the EAR name of the deployed EJB without .ear suffix.
         * Since we haven't deployed the application as a .ear, the app name for
         * us will be an empty string
         */
        String appName = "";
 
        /*
         * The module name is the JAR name of the deployed EJB without the .jar
         * suffix.
         */
        String moduleName = "EjbComponent-1.0-SNAPSHOT";
 
        /*
         * AS7 allows each deployment to have an (optional) distinct name. This
         * can be an empty string if distinct name is not specified.
         */
        String distinctName = "";
 
        // The EJB bean implementation class name
//        String beanName = "LibrarySessionBean";
        String beanName = LibrarySessionBean.class.getSimpleName();
 
        // Fully qualified remote interface name
//        final String interfaceName = "com.tutorialspoint.stateless.LibrarySessionBeanRemote";
        final String interfaceName = LibrarySessionBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName // + "/"  + distinctName
//        String name = appName + "/" + moduleName + "/" + distinctName
                + "/" + beanName + "!" + interfaceName;
 
        return name;
    }
	
	public LibrarySessionBeanRemote getRemoteBean() throws NamingException {
		//String lookupName = getLookupName();
		String lookupName = "ejb:/ejb-remote-server/ExampleServiceImpl!com.illucit.ejbremote.server.ExampleService";
		System.out.println("*lookupName=" + lookupName);
		LibrarySessionBeanRemote libraryBean = null;
		try {
			ctx = new InitialContext(props);
			libraryBean =	(LibrarySessionBeanRemote)ctx.lookup(lookupName);
			//ctx.close();
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
		return libraryBean;
	}

	public void testStatelessEjb() {
		try {
			int choice = 1;
			Properties properties = EjbRemoteUtil.createclientProperties(host, port);
			System.out.println("----------------------------------------------------------------");
			System.out.println("properties FORCED:");
			System.out.println("----------------------------------------------------------------");
			
	        for(Object prop: properties.keySet().toArray()) {
	        	System.out.printf("property: %-30s = %s\n", prop, props.getProperty((String) prop));
	        }
			//String lookupName = getLookupName();
			//String lookupName = "LibrarySessionBean/remote";
			String lookupName  = EjbRemoteUtil.getEjbURL(
															"", 
															"EjbComponent-1.0-SNAPSHOT", 
															LibrarySessionBean.class.getSimpleName(), 
															LibrarySessionBeanRemote.class.getName()
														);
			//String lookupName = "ejb:/EjbComponent-1.0-SNAPSHOT/LibrarySessionBean!com.tutorialspoint.stateless.LibrarySessionBean";
			System.out.println("----------------------------------------------------------------");
			System.out.println("*lookupName=" + lookupName);
			System.out.println("----------------------------------------------------------------");
			LibrarySessionBeanRemote libraryBean = null;
			try {
				ctx = new InitialContext(properties);
				libraryBean =	(LibrarySessionBeanRemote)ctx.lookup(lookupName);
				//ctx.close();
			} catch (NamingException ex) {
				ex.printStackTrace();
			}
			//LibrarySessionBeanRemote libraryBean = getRemoteBean();
			
			while(choice != 2) {
				String bookName;
				showGUI();
				String strChoice = brConsoleReader.readLine();
				choice = Integer.parseInt(strChoice);
				if(choice==1){
					System.out.println("Enter book name:");
					bookName = brConsoleReader.readLine();
					libraryBean.addBook(bookName);
				} 
			}
			
			List<String>bookList = libraryBean.getBooks();
			System.out.println("Books entered so far:" + bookList.size());
			for(String book: bookList.toArray(new String [0])) {
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
