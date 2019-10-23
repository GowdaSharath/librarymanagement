package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;

public class UserDaoImpl implements UserDao {
	AdminDao admin = new AdminDaoImpl();
	@Autowired
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	private EntityManager entityManager;
	private EntityTransaction transaction;


	@Override
	public List<Books> getAllBooks() {
		entityManager=entityManagerFactory.createEntityManager();
		String jpqa = "from Books ";
		Query query = entityManager.createQuery(jpqa);
		List<Books> allbooks = null;
		
		try {
			allbooks = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return allbooks;
	}

	@Override
	public Boolean updateStudent(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isadded=false;
		try {
			if(admin.searchStudent(user.getId())==null) {
				return isadded;
			}else {
				transaction.begin();
				entityManager.persist(user);
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
	public Boolean requestBook(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean returnBook(Books bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cancelRequest(Books bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
