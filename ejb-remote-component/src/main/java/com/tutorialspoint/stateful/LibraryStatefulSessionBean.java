package com.tutorialspoint.stateful;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {
	
	List<String> bookShelf;

    public LibraryStatefulSessionBean() {
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
