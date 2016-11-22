package com.template.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(T entity) {
		sessionFactory.getCurrentSession().persist(entity);
	}

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public void update(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

}
