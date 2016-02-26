package com.tutorialspoint.stateful;

import java.util.List;

import javax.ejb.Remote;

import com.tutorialpoints.Library;

@Remote
public interface LibraryStatefulSessionBeanRemote extends Library {
	void addBook(String bookName);
	List<String> getBooks();
	void deleteBooks();
}
