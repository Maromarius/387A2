package com.assignment2.util;

import java.sql.Connection;

public class Driver {

	public static void main(String[] args) 
	{
		Connection connection = DatabaseConnection.getConnection();

		if (connection != null) 
		{
			System.out.println("Connection : true");
			DatabaseConnection.close(null, null, connection);
		} 
		else 
		{
			System.out.println("Connection : false");
		}
	}
}