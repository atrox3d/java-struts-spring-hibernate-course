package it.formarete.service;

import java.util.List;

import it.formarete.model.Employee;
import it.formarete.model.User;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDAO {
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Transactional
	public int save(User user) {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();
		return (Integer)factory.getCurrentSession().save(user);
	}
	
	@Transactional
	public void update(User user) {
		factory.getCurrentSession().update(user);
	}
	
	@Transactional
	public void delete(User user) {
		factory.getCurrentSession().delete(user);
	}

	@Transactional
	public User get(int id) {
		return (User) factory.getCurrentSession().get(User.class, id);
	}

	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return factory.getCurrentSession().createCriteria(User.class).list();
	}

	@Transactional
	public void truncate() {
		factory.getCurrentSession().createSQLQuery("truncate table user").executeUpdate();
	}
	
}
