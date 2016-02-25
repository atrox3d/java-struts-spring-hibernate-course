package com.tutorialspoint.stateless;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
//@Remote(LibrarySessionBean.class)
public class LibrarySessionBean implements LibrarySessionBeanRemote {
	
	List<String> bookShelf;

    public LibrarySessionBean() {
    	bookShelf = new ArrayList<String>();
    }

	@Override
	public void addBook(String bookName) {
		bookShelf.add(bookName);
	}

	@Override
	public List<String> getBooks() {
		return bookShelf;
	}

}
