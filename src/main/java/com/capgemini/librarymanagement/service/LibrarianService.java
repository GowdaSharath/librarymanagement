package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.beans.Books;

public interface LibrarianService {
	public Boolean add(Books book);
	public Boolean update(Books book);
	public List<Books> findAll();
	public Books findByTitle(String title);
	public List<Books> findByName(String name);
	public Boolean acceptRequest(Books title);


}
