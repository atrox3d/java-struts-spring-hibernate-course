package it.formarete.join.service;

import it.formarete.join.model.Todo;
import it.formarete.join.model.User;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

@Transactional
public class TodoDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Todo get(int id) {
		String queryString = "FROM Todo WHERE id =:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("id", id);
		return (Todo) query.uniqueResult();
	}
	
	public int save(Todo todo) {
		return (Integer) sessionFactory.getCurrentSession().save(todo);
	}
	
	public void update(Todo todo) {
		sessionFactory.getCurrentSession().update(todo);
	}
	
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(get(id));
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Todo>getAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Todo")
				.list();
	}
	
	public void clear() {
		sessionFactory.getCurrentSession()
		.createQuery("delete from Todo")
		.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Todo> getAll(User user) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("from Todo where owner = :owner")
				.setParameter("owner",  user)
				.list();
	}

	

}
