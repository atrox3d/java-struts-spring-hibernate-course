package com.illucit.ejbremote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.illucit.ejbremote.server.ExampleService;
import com.illucit.ejbremote.server.ExampleServiceImpl;
import com.illucit.ejbremote.utility.EjbRemoteUtil;
import com.tutorialspoint.stateless.LibrarySessionBeanRemote;
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
		LibrarySessionBeanRemote service;

		System.out.println("----------------------------------------------------------------");
		System.out.println("getting remote bean...");
		service = EjbRemoteUtil.getRemoteBean(
												host, 
												port, 
												"", 
												"ejb-remote-component", 
												LibrarySessionBean.class.getSimpleName(), 
												LibrarySessionBeanRemote.class.getName(),
												LibrarySessionBeanRemote.class
											);
		
		EjbRemoteClient ejbClient = new EjbRemoteClient();
		System.out.println("done");
		System.out.println("----------------------------------------------------------------");
		ejbClient.testStatelessEjb(service);
		
	}

	public  void testStatelessEjb(LibrarySessionBeanRemote libraryBean) {
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
	
	private void showGUI() {
	      System.out.println("**********************");
	      System.out.println("Welcome to Book Store");
	      System.out.println("**********************");
	      System.out.println("Options:");
	      System.out.println("1. Add Book");
	      System.out.println("2. Exit");
	      System.out.println("Enter Choice:");
	 }
	
}
