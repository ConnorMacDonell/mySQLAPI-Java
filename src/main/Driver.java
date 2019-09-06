package main;

import java.sql.*;


public class Driver {
	
	private static final String dbClassName = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://localhost:3306/";
	
	public static Connection dbConnection(String[] credentials) throws ClassNotFoundException{
		Class.forName(dbClassName);
		Connection conn = null;
		final String USER = credentials[0];
		final String PASS = credentials[1];
		final String dbConnect = CONNECTION + credentials[2] + "?serverTimezone=UTC";
		
		System.out.println("Connecting to Database...");
		
		try {
			conn = DriverManager.getConnection(dbConnect, USER, PASS);
			System.out.println("Succesfully Connected to DB.");
			
		} catch(SQLException ex){
			System.err.println("Error connecting to Database.");
			ex.printStackTrace();
			
		}
		
		return conn;
	}
	
	
	

}
