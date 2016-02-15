package it.formarete.service;

import java.util.List;

import it.formarete.action.RegisterEmployee;
import it.formarete.model.Employee;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	
	final static Logger logger = Logger.getLogger(RegisterEmployee.class);

	public int save(Employee employee) {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();
		int id = -1;
		logger.info("saving employee:" + employee);
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			id = (Integer) session.save(employee);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return id;
	}
	
	public void update(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		logger.info("updating employee:" + employee);
		try {
			session.update(employee);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		logger.info("deleting employee:" + employee);
		try {
			session.delete(employee);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
	}

	public Employee get(int id) {
//		Session session = factory.openSession();
		Employee employee = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		logger.info("loading employee:" + id);
		try {
			employee = (Employee)session.get(Employee.class, id);
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		
		return employee;
	}

	
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		List<Employee> users = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		logger.info("loading all employees");
		try {
			users = session.createCriteria(Employee.class).list();
			t.commit();
		} catch(Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		
		return users;
	}

}
