package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import main.Driver;
import main.DeletionAPI;
import main.InsertionAPI;
import main.ManipulationAPI;


@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws SQLException{
		String[] credentials = {"", "", ""};
		
		Connection conn = null;
		Driver sqlManager = null;
		
		try {
			sqlManager = new Driver();
			conn = Driver.dbConnection(credentials);
			
			
		} catch(Exception e) {
			System.err.println("Connection failed.");
			return;
		}
		
		if(conn != null) {
			//Do mySQL stuff here.
			
		}
		else {
			System.out.println("Connection is null.");
		}
		try {
			conn.close();
			
		} catch(SQLException e) {
			System.err.println("Error occurred while disconnecting");
		}
		
		conn = null;
		sqlManager = null;
	}

}



