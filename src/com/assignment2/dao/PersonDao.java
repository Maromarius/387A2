package com.assignment2.dao;
import java.sql.Connection;
import java.util.List;

import com.assignment2.model.Person;
import com.assignment2.util.DatabaseConnection;

public class PersonDao {
	
	private Connection connection;
	
	 public PersonDao() {
	        connection = DatabaseConnection.getConnection();
	    }
	 
	 public void addPerson(Person person) {}
	 
	 public void deleteUser(int PersonId) {}
	 
	 public void updateUser(Person person) {}
	 
	 public List<Person> getAllPerson() {
		return null;}
	 
	 public Person getPersonById(int userId) {
		return null;}
	 
	 
	 

}
