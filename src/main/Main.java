package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import main.Driver;
import main.API;



@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws SQLException{
		String[] credentials = {"root", "8723fy96", "feedback"};
		
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
			//API sqlDaemon = new API();
			API.removeColumn(conn, "comments", "dummy");
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