package com.capgemini.librarymanagement.commons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagement.beans.User;

public class CommonOperationsImpl implements CommonOperations {
	@Autowired
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	private String id;
	@Override
	public User adminLogin(String adminId, String password) {
		User admin = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("FROM User WHERE id=:id and password=:password and type='admin'", User.class);
			this.id = admin.getId();
			query.setParameter("id", admin.getId());
			query.setParameter("password", admin.getPassword());
			admin = (User) query.getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	@Override
	public User studentLogin(String studentid,String password) {
		User student = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("FROM User WHERE id=:id and password=:password and type='student'", User.class);
			this.id = student.getId();
			query.setParameter("id", student.getId());
			query.setParameter("password", student.getPassword());
			student = (User) query.getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	@Override
	public User librarianLogin(String librarianid, String password) {
		User librarian = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createQuery("FROM User WHERE id=:id and password=:password and type='librarian'", User.class);
			this.id = librarian.getId();
			query.setParameter("id", librarian.getId());
			query.setParameter("password", librarian.getPassword());
			librarian = (User) query.getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librarian;
	}
	

}
