package com.tutorialspoint.stateless;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {
	
	List<String> bookShelf;

    public LibrarySessionBean() {
		System.out.println("----------------------------------------------------------------");
    	System.out.println("LibrarySessionBean: initializing bookshelf");
		System.out.println("----------------------------------------------------------------");
    	bookShelf = new ArrayList<String>();
    }

	@Override
	public void addBook(String bookName) {
		System.out.println("----------------------------------------------------------------");
    	System.out.println("LibrarySessionBean: adding book:" + bookName);
		System.out.println("----------------------------------------------------------------");
		bookShelf.add(bookName);
	}

	@Override
	public List<String> getBooks() {
		System.out.println("----------------------------------------------------------------");
    	System.out.println("LibrarySessionBean: returning books:" + bookShelf.size());
		System.out.println("----------------------------------------------------------------");
    	for(String book : bookShelf) {
    		System.out.println(book);
    	}
		System.out.println("----------------------------------------------------------------");
		return bookShelf;
	}

}
