package it.formarete.join.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import it.formarete.join.model.User;

@Transactional
public class UserDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public User get(String username) {
		String queryString = "FROM User WHERE name =:username";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}
	
	public int save(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}
	
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
	
	public void delete(String name) {
		User user = get(name);
		delete(user);
		
	}
	
	public void deleteHQL(String name) {
		sessionFactory.getCurrentSession().createQuery("delete from user where name = :name")
		.setParameter("name", name)
		.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<User>getAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from User")
				.list();
	}
	
	public void clear() {
		sessionFactory.getCurrentSession()
		.createQuery("delete from User")
		.executeUpdate();
	}

}
