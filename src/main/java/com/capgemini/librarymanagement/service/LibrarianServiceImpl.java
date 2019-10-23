package com.capgemini.librarymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.dao.LibrarianDao;

@Service
public class LibrarianServiceImpl  implements LibrarianService {
	private LibrarianDao dao;
	@Override
	public Boolean add(Books book) {
		return dao.add(book);
	}

	@Override
	public Boolean update(Books book) {
		return dao.update(book);
	}

	@Override
	public List<Books> findAll() {
		return dao.findAll();
	}

	@Override
	public Books findByTitle(String title) {
		return dao.findByTitle(title);
	}

	@Override
	public List<Books> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Boolean acceptRequest(Books title) {
		return dao.acceptRequest(title);
	}

}
