package com.tutorialspoint.stateless.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tutorialspoint.stateless.LibrarySessionBean;

public class LibrarySessionBeanTestCase {
	LibrarySessionBean bookShelf;

	@Test
	public void testBean() {
		bookShelf = new LibrarySessionBean();
		assertTrue(bookShelf.getBooks().isEmpty());
		
		bookShelf.addBook("book1");
		assertFalse(bookShelf.getBooks().isEmpty());
		assertEquals(bookShelf.getBooks().size(), 1);
		assertTrue(bookShelf.getBooks().contains("book1"));
		
		try {
			String book = bookShelf.getBooks().get(0);
			assertEquals(book, "book1");
		} catch (IndexOutOfBoundsException e) {
			fail("book1 not found");
		}
	}

}
