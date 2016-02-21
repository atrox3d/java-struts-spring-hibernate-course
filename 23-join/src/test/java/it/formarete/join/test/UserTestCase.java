package it.formarete.join.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import it.formarete.join.model.User;
import it.formarete.join.service.UserDAO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserTestCase {
	
	private ClassPathXmlApplicationContext context;
	private UserDAO dao;
	
	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (UserDAO)context.getBean("userDao");
	}
	
	@Test
	public void testCRUD() {
		dao.clear();
		Assert.assertTrue(dao.getAll().isEmpty());
		//User user = new User();
		User user = (User)context.getBean("user");
		user.setName("admin");
		user.setPassword("admin");
		//UserDAO dao = new UserDAO();
		int id = dao.save(user);
		Assert.assertTrue(id > 0);
		
		user = dao.get("admin");
		assertEquals("admin", user.getName());
		Assert.assertNotNull(user);
		
		user.setPassword("nimda");
		dao.update(user);
		user = dao.get("admin");
		Assert.assertEquals("nimda", user.getPassword());
	
		dao.delete(user);
		user = dao.get("admin");
		assertNull(user);
	}

	@After
	public void tearDown() {
		context.close();
	}
}
