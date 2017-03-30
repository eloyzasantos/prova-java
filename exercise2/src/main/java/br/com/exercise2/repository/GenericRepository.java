package br.com.exercise2.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class GenericRepository<T> {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T entity) {
		getSession().merge(entity);
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public T get(Long id, Class<T> clazz) {
		return (T) getSession().get(clazz, id);
	}
	
	
}
