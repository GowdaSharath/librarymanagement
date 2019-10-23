package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;

public interface UserDao {
	public List<Books> getAllBooks();
	public Boolean updateStudent( User userId)  ;
	public Boolean requestBook(String title)  ;
	public Boolean returnBook(Books bookId) ;
	public Boolean cancelRequest(Books bookId) ;
	

}
