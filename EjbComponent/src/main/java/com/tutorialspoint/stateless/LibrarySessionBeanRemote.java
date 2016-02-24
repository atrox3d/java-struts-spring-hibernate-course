package com.tutorialspoint.stateless;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
public interface LibrarySessionBeanRemote {
	void addBook(String bookName);
	List<String> getBooks();
}
