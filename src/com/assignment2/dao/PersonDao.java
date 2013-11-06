package com.assignment2.dao;
import java.sql.Connection;
import java.util.List;

import com.assignment2.model.Person;
import com.assignment2.util.DatabaseConnection;

public class PersonDao {
	
	private Connection connection;
	
	 public PersonDao() 
	 {
	        connection = DatabaseConnection.getConnection();
	 }
	 
	 public boolean addPerson(Person person) 
	 {
		 return true;
	 }
	 
	 public boolean deleteUser(int PersonId) 
	 {
		 return true; 
	 }
	 
	 public boolean updateUser(Person person) 
	 {
		 return true;
	 }
	 
	 public String[] getPerson(int pid) 
	 {
		return null;
	 }
	 
	 public int[] getAllIds() 
<<<<<<< HEAD
	 { 
=======
	 {
>>>>>>> 9a1c36f... Changed it again
		return null;
	 }
	  
	 public String[] getAllFirstNames() 
	 {
		return null;
	 }
	 
	 public String[] getAllLastNames() 
	 {
		return null;
	 }
	 
	 
}
