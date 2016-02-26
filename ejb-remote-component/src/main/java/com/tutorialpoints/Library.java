package com.tutorialpoints;

import java.util.List;

public interface Library {
	void addBook(String bookName);
	List<String> getBooks();
	void deleteBooks();

}
