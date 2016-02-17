package it.formarete.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.formarete.model.User;
import it.formarete.service.EmployeeDAO;
import it.formarete.service.HibernateUtils;
import it.formarete.service.UserDAO;
import junit.framework.TestCase;

public class UserDAOTestCase extends TestCase {
	private ClassPathXmlApplicationContext context;
	private UserDAO userDAO;

	public void setUp() {
		//HibernateUtils.getSessionFactory();
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDAO = (UserDAO) context.getBean("userDao");
	}
	
	public void testUserCrud() {
		User user = new User();
		user.setName("Antony");
		
		// retrieve
		UserDAO dao = userDAO;
		dao.truncate();
		List<User> users = dao.getAll();
		assertNotNull(users);
		assertTrue(users.isEmpty());
		
		//create
		int id = dao.save(user);
		assertTrue(id > 0);
		user = dao.get(id);
		assertEquals(id, user.getId());
		users = dao.getAll();
		assertEquals(users.size(), 1);
		
		//update
		user.setName("roby");
		dao.update(user);
		user = dao.get(user.getId());
		assertEquals("roby",  user.getName());
		users = dao.getAll();
		assertEquals(users.size(), 1);

		//delete
		dao.delete(user);
		user = dao.get(user.getId());
		assertNull(user);
		users = dao.getAll();
		assertNotNull(users);
		assertTrue(users.isEmpty());
	
	}
	
	public void tearDown() {
		//HibernateUtils.getSessionFactory().close();
		context.close();
	}
}
