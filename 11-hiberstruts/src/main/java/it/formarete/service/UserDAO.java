package it.formarete.service;

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
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		int id = (Integer) session.save(user);
		
		t.commit();
		session.close();
		return id;
	}
	
	public void update(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		session.update(user);
		
		t.commit();
		session.close();
	}
	
	public void delete(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		session.delete(user);
		
		t.commit();
		session.close();
	}

	public User get(int id) {
//		Session session = factory.openSession();
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		User user = (User)session.get(User.class, id);
		
		t.commit();
		session.close();
		
		return user;
	}

}
