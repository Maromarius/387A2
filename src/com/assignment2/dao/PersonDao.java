package com.assignment2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.assignment2.util.DatabaseConnection;

public class PersonDao {
	
	private Connection connection;
	
	 public PersonDao() 
	 {
	        connection = DatabaseConnection.getConnection();
	 }
	 
	 public boolean addPerson(int id, String firstname, String lastname, String phone, String address) 
	 {
		 return true;
	 }
	 
	 public boolean deleteUser(int PersonId) 
	 {
		 return true; 
	 }
	 
	 public boolean updateUser(int id, String firstname, String lastname, String phone, String address) 
	 {
		 return true;
	 }
	 
	 public String[] getPersonbyId(int pid) 
	 {
		 String[] person = new String[5];
		 
		 try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from person where pid=?");
	            preparedStatement.setInt(1, pid);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	person[0] = rs.getInt("personid")+ "";
	            	person[1] = rs.getString("firstname");
	            	person[2] = rs.getString("lastname");
	            	person[3] = rs.getString("phonenumber");
	            	person[4] = rs.getString("address");
	            	
	              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return person;
	 }
	 
	 public ArrayList<Integer> getAllIds(){
		 ArrayList<Integer> idList = new ArrayList<Integer>();
		try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select personid from person");
            while (rs.next()) {
            	
            	idList.add(rs.getInt("personid"));
            	
            }
		}
		catch(SQLException e){
			
			e.printStackTrace();
		}
		return idList;
	 }
	  
	 public ArrayList<String> getAllFirstNames() 
	 {
		 ArrayList<String> firstNameList = new ArrayList<String>();
			try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select firstname from person");
	            while (rs.next()) {
	            	
	            	firstNameList.add(rs.getString("firstname"));
	            	
	            }
			}
			catch(SQLException e){
				
				e.printStackTrace();
			}
			return firstNameList;
	 }
	 
	 public ArrayList<String> getAllLastNames() 
	 {
		 ArrayList<String> lastNameList = new ArrayList<String>();
			try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select lastname from person");
	            while (rs.next()) {
	            	
	            	lastNameList.add(rs.getString("lastname"));
	            	
	            }
			}
			catch(SQLException e){
				
				e.printStackTrace();
			}
			return lastNameList;
	 }
	 
}
