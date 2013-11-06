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
	 
	 public int[] getAllIds(){

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
	 
	 
<<<<<<< HEAD
	 public void deletePerson(int PersonId) {}
	 
	 public void updatePerson(Person person) {}
	 
	 public List<Person> getAllPerson() {
		return null;}
	 
	 public Person getPersonById(int userId) {
		return null;}
	 
	 
	 

=======
>>>>>>> b2735b8bb4790b4c84640f0d41753602fb24a3b6
}
