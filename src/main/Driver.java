package main;

import java.sql.*;


public class Driver {
	
	private static final String dbClassName = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://localhost/";
	
	public static Connection dbConnection(String[] credentials) throws ClassNotFoundException{
		Class.forName(dbClassName);
		Connection conn = null;
		String USER = credentials[0];
		String PASS = credentials[1];
		String connectionName = CONNECTION + credentials[2];
		
		System.out.println("Connecting to Database...");
		
		try {
			conn = DriverManager.getConnection(connectionName, USER, PASS);
			System.out.println("Succesfully Connected to DB: " + credentials[2]);
			
		} catch(SQLException ex){
			System.err.println("Error connecting to Database.");
			
		}
		
		return conn;
	}
	

}
