package it.formarete.test;

import it.formarete.model.User;
import it.formarete.service.UsersDB;
import junit.framework.TestCase;

public class UsersDBTestCase extends TestCase {
	public void testValidUser() {
		User user = UsersDB.get("giancarlo");
		assertNotNull(user);
		assertEquals("magalli", user.getPassword());
	}
	
	public void testInvalidUser() {
		User user = UsersDB.get("pippo");
		assertNull(user);
	}

}
