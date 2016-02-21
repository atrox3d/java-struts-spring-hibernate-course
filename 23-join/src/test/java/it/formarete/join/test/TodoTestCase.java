package it.formarete.join.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import it.formarete.join.model.Todo;
import it.formarete.join.model.User;
import it.formarete.join.service.TodoDAO;
import it.formarete.join.service.UserDAO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TodoTestCase {
	
	private ClassPathXmlApplicationContext context;
	private TodoDAO todoDAO;
	private UserDAO userDAO;
	
	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		todoDAO = (TodoDAO)context.getBean("todoDao");
		userDAO = (UserDAO)context.getBean("userDao");
	}
	
	@Test
	public void testCRUD() {
		todoDAO.clear();
		Assert.assertTrue(todoDAO.getAll().isEmpty());
		
		userDAO.clear();
		Assert.assertTrue(userDAO.getAll().isEmpty());
		
		User user = (User) context.getBean("user");
		user.setName("giancarlo");
		
		userDAO.save(user);
		user = userDAO.get("giancarlo");
		
		//Todo todo = new Todo();
		Todo todo = (Todo)context.getBean("todo");
		todo.setTitle("learn struts");
		todo.setOwner(user);
		//TodoDAO dao = new TodoDAO();
		int id = todoDAO.save(todo);
		Assert.assertTrue(id > 0);
		
		List<Todo>todos = todoDAO.getAll(user);
		Assert.assertNotNull(todos);
		Assert.assertFalse(todos.isEmpty());
		
		todo = todos.get(0);
		todo.setDone(true);
		todoDAO.update(todo);
		
		
		todo = todoDAO.getAll().get(0);
		Assert.assertTrue(todo.isDone());
	
		todoDAO.delete(id);
		
		todos = todoDAO.getAll(user);
		Assert.assertNotNull(todos);
		Assert.assertTrue(todos.isEmpty());

	}

	@After
	public void tearDown() {
		context.close();
	}
}
