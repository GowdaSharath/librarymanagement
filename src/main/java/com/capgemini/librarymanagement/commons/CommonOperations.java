package com.capgemini.librarymanagement.commons;

import com.capgemini.librarymanagement.beans.User;

public interface CommonOperations {
	public User adminLogin(String adminId,String password);
	public User studentLogin(String studentid,String password);
	public User librarianLogin(String librarianid,String password);
	
	

}
