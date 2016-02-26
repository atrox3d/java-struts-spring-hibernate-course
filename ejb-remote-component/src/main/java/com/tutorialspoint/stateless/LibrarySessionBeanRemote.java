package com.tutorialspoint.stateless;

import java.util.List;

import javax.ejb.Remote;

import com.tutorialpoints.Library;

@Remote
public interface LibrarySessionBeanRemote extends Library{
	void addBook(String bookName);
	List<String> getBooks();
	void deleteBooks();
}
