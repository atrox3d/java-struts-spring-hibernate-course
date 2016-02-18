package it.formarete.service;

import java.util.List;

import it.formarete.model.Employee;
import it.formarete.model.User;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDAO {
	private SessionFactory factory;
	final static Logger logger = Logger.getLogger(UserDAO.class);

	public SessionFactory getFactory() {
		logger.info("getFactory");
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		logger.info("setFactory");
		this.factory = factory;
	}
	
	@Transactional
	public int save(User user) {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();
		logger.info("save(" + user + ")");
		return (Integer)factory.getCurrentSession().save(user);
	}
	
	@Transactional
	public void update(User user) {
		logger.info("update(" + user + ")");
		factory.getCurrentSession().update(user);
	}
	
	@Transactional
	public void delete(User user) {
		logger.info("delete(" + user + ")");
		factory.getCurrentSession().delete(user);
	}

	@Transactional
	public User get(int id) {
		logger.info("save(" + id + ")");
		return (User) factory.getCurrentSession().get(User.class, id);
	}

	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		logger.info("getAll()");
		return factory.getCurrentSession().createCriteria(User.class).list();
	}

	@Transactional
	public void truncate() {
		logger.info("truncate()");
		factory.getCurrentSession().createSQLQuery("truncate table user").executeUpdate();
	}
	
}
