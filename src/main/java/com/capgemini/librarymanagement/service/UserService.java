package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;

public interface UserService {
	public List<Books> getAllBooks();
	public Boolean updateStudent( User userId)  ;
	public Boolean requestBook(String title)  ;
	public Boolean returnBook(Books bookId) ;
	public Boolean cancelRequest(Books bookId) ;
	

}
