package com.capgemini.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public List<Books> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public Boolean updateStudent(User userId) {
		return dao.updateStudent(userId);
	}

	@Override
	public Boolean requestBook(String title) {
		return dao.requestBook(title);
	}

	@Override
	public Boolean returnBook(Books bookId) {
		return dao.returnBook(bookId);
	}

	@Override
	public Boolean cancelRequest(Books bookId) {
		return dao.cancelRequest(bookId);
	}

}
