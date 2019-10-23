package com.capgemini.librarymanagement.dao;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;


public class LibrarianDaoImpl implements LibrarianDao{
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	private EntityManager entityManager;
	private EntityTransaction transaction;
	Books book=null;

	@Override
	public Boolean add(Books book) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(book);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}
		
	

	@Override
	public Boolean update(Books book) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isadded=false;
		try {
			if(findByTitle(book.getTitle())==null) {
				return isadded;
			}else {
				transaction.begin();
				entityManager.persist(book);;
				transaction.commit();
				 isadded=true;
			}
		}catch(Exception e) {
			transaction.rollback();
			return isadded;
		}
		entityManager.close();
		return isadded;
	}
				
	

	@Override
	public List<Books> findAll() {
		entityManager=entityManagerFactory.createEntityManager();
		String jpqa = "from Books";
		Query query = entityManager.createQuery(jpqa);
		List<Books> allBooks = null;
		
		try {
			allBooks = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return allBooks;
	}


	@Override
	public Books findByTitle(String title) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql="from Books where title= :title" ;	
		Query query=(Query)entityManager.createQuery(jpql);
		query.setParameter( "title",title);
		book =(Books) query.getSingleResult();
		if(book!=null) {
			return book;
		}else {
			return null;
		}
	}

	@Override
	public List<Books> findByName(String name) {
		entityManager=entityManagerFactory.createEntityManager();
		String jpqa = "from Books where Title='title'";
		Query query = entityManager.createQuery(jpqa);
		List<Books> booksByName = null;
		
		try {
			booksByName = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return booksByName;
	}



	@Override
	public Boolean acceptRequest(Books title) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

	



	

