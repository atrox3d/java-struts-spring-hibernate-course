package com.illucit.ejbremote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.naming.NamingException;

//import com.illucit.ejbremote.server.ExampleService;
//import com.illucit.ejbremote.server.ExampleServiceImpl;
import com.illucit.ejbremote.utility.EjbRemoteUtil;
import com.tutorialpoints.Library;
import com.tutorialspoint.stateless.LibrarySessionBeanRemote;
import com.tutorialspoint.stateful.LibraryStatefulSessionBean;
import com.tutorialspoint.stateful.LibraryStatefulSessionBeanRemote;
import com.tutorialspoint.stateless.LibrarySessionBean;

public class EjbRemoteClient {

	BufferedReader brConsoleReader = null;
	
	{
	    brConsoleReader = new BufferedReader(
					new InputStreamReader(System.in)
				);
	}
	
	public static void main(String[] args) throws NamingException, ClassCastException  {
		String host = "localhost";
		String port = String.valueOf(1339);
		EjbRemoteClient ejbClient = new EjbRemoteClient();
		LibrarySessionBeanRemote statelessService;
		LibraryStatefulSessionBeanRemote statefulService;

		System.out.println("----------------------------------------------------------------");
		System.out.println("testing stateLESS bean:");
		System.out.println("----------------------------------------------------------------");
		System.out.println("getting remote bean...");
		statelessService = EjbRemoteUtil.getRemoteBean(
												host, 
												port, 
												"", 
												"ejb-remote-component", 
												LibrarySessionBean.class.getSimpleName(), 
												LibrarySessionBeanRemote.class.getName(),
												LibrarySessionBeanRemote.class
											);
		
		System.out.println("done");
		System.out.println("----------------------------------------------------------------");
		ejbClient.testEjb(statelessService);
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("testing stateFUL bean:");
		System.out.println("----------------------------------------------------------------");
		System.out.println("getting remote bean...");
		statefulService = EjbRemoteUtil.getRemoteBean(
												host, 
												port, 
												"", 
												"ejb-remote-component", 
												LibraryStatefulSessionBean.class.getSimpleName(), 
												LibraryStatefulSessionBeanRemote.class.getName() + "?stateful",
												LibraryStatefulSessionBeanRemote.class
											);
		
		System.out.println("done");
		System.out.println("----------------------------------------------------------------");
		ejbClient.testEjb(statefulService);
	}

	public void testStatefulEjb(Library libraryBean) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("testing testStatelessEjb:");
		System.out.println("----------------------------------------------------------------");
		try {
			int choice = 1;
			
			while(choice != 2) {
				String bookName;
				showGUI();
				String strChoice = brConsoleReader.readLine();
				choice = Integer.parseInt(strChoice);
				if(choice==1){
					System.out.println("Enter book name:");
					bookName = brConsoleReader.readLine();
					System.out.println("adding book: " + bookName);
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
	
	public void testEjb(Library libraryBean) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("testing testStatelessEjb:");
		System.out.println("----------------------------------------------------------------");
		try {
			int choice = 1;
			
			while(choice != 4) {
				String bookName;
				showGUI();
				String strChoice = brConsoleReader.readLine();
				choice = Integer.parseInt(strChoice);
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter book name:");
						bookName = brConsoleReader.readLine();
						System.out.println("adding book: " + bookName);
						libraryBean.addBook(bookName);
					}
					break;

					case 2:
					{
						List<String>bookList = libraryBean.getBooks();
						System.out.println("Books entered so far:" + bookList.size());
						for(String book: bookList.toArray(new String [0])) {
							System.out.println(book);
						}
					}
					break;

					case 3:
					{
						System.out.println("deleting books");
						libraryBean.deleteBooks();
					}
					break;
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
	private void showGUI() {
	      System.out.println("**********************");
	      System.out.println("Welcome to Book Store");
	      System.out.println("**********************");
	      System.out.println("Options:");
	      System.out.println("1. Add Book");
	      System.out.println("2. List Books");
	      System.out.println("3. Delete Books");
	      System.out.println("4. Exit");
	      System.out.println("Enter Choice:");
	 }
	
}
