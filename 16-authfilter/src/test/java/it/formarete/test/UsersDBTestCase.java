package it.formarete.test;

import org.apache.log4j.Logger;

import it.formarete.model.User;
import it.formarete.service.UsersDB;
import junit.framework.TestCase;

public class UsersDBTestCase extends TestCase {
	final static Logger logger = Logger.getLogger(UsersDBTestCase.class);

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
