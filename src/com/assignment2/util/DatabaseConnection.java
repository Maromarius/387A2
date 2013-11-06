package com.assignment2.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class DatabaseConnection 
{
	static 
	{
		String driverName = "com.mysql.jdbc.Driver";
		try 
		{
			Class.forName(driverName);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection() 
	{
		Connection connection = null;
		
		String strSshUser = ""; // SSH ENCS login Username
		String strSshPassword = ""; // SSH ENCS login password
		String strSshHost = "login.encs.concordia.ca"; // hostname or ip of SSH server
		int nSshPort = 22; // remote SSH host port number
		String strRemoteHost = "clipper.encs.concordia.ca"; // hostname or ip of your database server
		int nLocalPort = 3334; //int nLocalPort = findUnusedPort(); // local port number use to bind SSH
		// tunnel
		int nRemotePort = 3306; // remote port number of your database
		final JSch jsch = new JSch();
		int assport = 0;
		Session session=null;
		try 
		{
			session = jsch.getSession(strSshUser, strSshHost, nSshPort);
		} catch (JSchException e1) 
		{
			e1.printStackTrace();
		}
		session.setPassword(strSshPassword);
		final Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		try 
		{
			session.connect();
		} 
		catch (JSchException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{
			assport = session.setPortForwardingL(nLocalPort, strRemoteHost,nRemotePort);
		} catch (JSchException e1) {
			e1.printStackTrace();
		}

		String databaseName = "soen387k";
		String username = "soen387k";
		String password = "e73v72";
		
		String url = "jdbc:mysql://"+"127.0.0.1"+":"+nLocalPort+"/"+databaseName;

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void printRs(ResultSet rs) {
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int cols = meta.getColumnCount();
			StringBuffer sb = new StringBuffer();
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					String columnName = meta.getColumnName(i);
					sb.append(columnName + "=");
					sb.append(rs.getString(columnName) + "  ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		Connection connection = getConnection();

		if (connection != null) 
		{
			System.out.println("Connection : true");
			close(null, null, connection);
		} 
		else 
		{
			System.out.println("Connection : false");
		}
	}
}
