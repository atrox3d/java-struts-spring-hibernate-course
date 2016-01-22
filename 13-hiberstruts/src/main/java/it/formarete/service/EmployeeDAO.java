package it.formarete.service;

import java.util.List;

import it.formarete.model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	
	public int save(Employee employee) {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();
		int id = -1;
		
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
