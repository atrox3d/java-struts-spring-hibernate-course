package it.formarete.service;

import java.util.List;

import it.formarete.model.User;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO {
	
	public int save(User user) {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();
		int id = -1;
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			id = (Integer) session.save(user);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return id;
	}
	
	public void update(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(user);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(user);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
	}

	public User get(int id) {
//		Session session = factory.openSession();
		User user = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		try {
			user = (User)session.get(User.class, id);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		
		return user;
	}

	
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		List<User> users = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		try {
			users = session.createCriteria(User.class).list();
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		
		return users;
	}

}
