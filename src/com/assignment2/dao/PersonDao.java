package com.assignment2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.assignment2.util.DatabaseConnection;

public class PersonDao {
	
	private Connection connection;
	
	 public PersonDao() 
	 {
		 connection = DatabaseConnection.getConnection();
	 }
	 
	 public boolean executeSQLStatement(String sql)
	 {
		Statement statement = null;
		try 
		{
			statement = connection.createStatement();
			statement.execute(sql);
			return true; // successful operation
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false; // unsuccessful operation
		}
	 }
	 
	 public boolean addPerson(int id, String firstname, String lastname, String phone, String address) 
	 {
		String sql = "INSERT INTO `soen387k`.`Person` (`PID`, `firstname`, `lastname`, `address`, `phone`) "
				+ "VALUES ('"+id+"', '"+firstname+"', '"+lastname+"', '"+address+"', '"+phone+"');";
		return executeSQLStatement(sql);
	 }
	 
	 public boolean deleteUser(int PersonId) 
	 {
		 String sql = "DELETE FROM `soen387k`.`Person` WHERE `PID`='"+PersonId+"';";
		 return executeSQLStatement(sql);
	 }
	 
	 public boolean updateUser(int id, String firstname, String lastname, String phone, String address) 
	 {
		 String sql = "UPDATE `soen387k`.`Person` SET `firstname`='"+firstname+"', `lastname`='"+lastname+"', "
		 		+ "`address`='"+address+"',  `phone`='"+phone+"' WHERE `PID`='"+id+"';";
		 return executeSQLStatement(sql);
	 }
	 
	 public String[] getPersonbyId(int pid) 
	 {
		 String[] person = new String[5];
		 
		 try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from Person where PID=?");
	            preparedStatement.setInt(1, pid);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	person[0] = rs.getInt("PID")+ "";
	            	person[1] = rs.getString("firstname");
	            	person[2] = rs.getString("lastname");
	            	person[3] = rs.getString("phone");
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
            ResultSet rs = statement.executeQuery("select PID from Person");
            while (rs.next()) {
            	
            	idList.add(rs.getInt("PID"));
            	
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
	            ResultSet rs = statement.executeQuery("select firstname from Person");
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
	            ResultSet rs = statement.executeQuery("select lastname from Person");
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
