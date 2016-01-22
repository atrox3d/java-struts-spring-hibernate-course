package it.formarete.test;

import it.formarete.model.User;
import it.formarete.service.HibernateUtils;
import it.formarete.service.UserDAO;
import junit.framework.TestCase;

public class UserDAOTestCase extends TestCase {
	public static void setUpBerforeClass() {
		HibernateUtils.getSessionFactory();
	}
	
	public void testUserDAO() {
		User user = new User();
		user.setName("Antony");
		
		UserDAO userDAO = new UserDAO();
		int id = userDAO.save(user);
		assertEquals(1, id);
	}
	
	public static void tearDownAfterClass() {
		HibernateUtils.getSessionFactory().close();
	}
}
