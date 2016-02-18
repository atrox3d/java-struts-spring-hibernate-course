package it.formarete.service;

import java.util.List;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import it.formarete.model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDAO {
	private SessionFactory factory;
	final static Logger logger = Logger.getLogger(EmployeeDAO.class);

	public SessionFactory getFactory() {
		logger.info("getFactory");
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		logger.info("setFactory");
		this.factory = factory;
	}

	@Transactional
	public int save(Employee employee) {
		logger.info("save(" + employee + ")");
		return (Integer)factory.getCurrentSession().save(employee);
	}

	@Transactional
	public void update(Employee employee) {
		logger.info("update(" + employee + ")");
		factory.getCurrentSession().update(employee);
	}

	@Transactional
	public void delete(Employee employee) {
		logger.info("delete(" + employee + ")");
		factory.getCurrentSession().delete(employee);
	}

	@Transactional
	public Employee get(int id) {
		logger.info("get(" + id + ")");
		return (Employee) factory.getCurrentSession().get(Employee.class, id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		logger.info("getAll()");
		return factory.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Transactional
	public void truncate() {
		logger.info("truncate()");
		factory.getCurrentSession().createSQLQuery("truncate table employee").executeUpdate();
	}
}
