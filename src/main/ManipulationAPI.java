package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManipulationAPI {

	/**
	 * Renames a table
	 * 
	 * @param conn: connection to database
	 * @param oldName: name of the table to be renamed
	 * @param newName: new name for the table
	 */
	public static void renameTable(Connection conn, String oldName, String newName) throws SQLException {
		String sql = "alter table " + oldName + " rename to " + newName + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to rename table...");
			preparedStatement.execute();
			System.out.println("Data rename table.");
		}
		
		catch(SQLException e) {
			System.out.println("Renaming failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
	}

	/**
	 * Updates a row
	 * 
	 * @param conn: connection to database
	 * @param tableName: name of table containing row to be updated
	 * @param columnVals: name of column(s) to be updated and updated value ex. (salary = 30000). if updating
	 * multiple columns use csv ex. (salary = 30000, position = "Junior Developer")
	 * @param condition(s): string condition for row(s) to be updated ex. (id = 100 or age < 30) if using
	 * multiple conditions spearate each with the word and ex. (departmentID = 2 and position = 'Sales Rep')
	 */

	public static void updateRow(Connection conn, String tableName, String columnVals, String condition) throws SQLException {
		String sql = "update " + tableName + " set " + columnVals + " where " + condition + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to update column(s)...");
			preparedStatement.execute();
			System.out.println("Column(s) updated.");
		}
		
		catch(SQLException e) {
			System.out.println("Column updating failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
	
	}



	/**
	 * Updates *ALL* rows
	 * 
	 * This really updates all rows. For real. Honestly you probably shouldn't be using this.
	 * I assume no responsibility if you destroy your data, I wash my hands of your probable self-immolation.
	 * 
	 * @param conn: connection to database
	 * @param tableName: name of table in which all rows will be updated
	 * @param columnVals: name of column(s) to be updated and updated value ex. (salary = 30000). if updating
	 * multiple columns use csv ex. (salary = 30000, position = "Junior Developer")
	 */

	public static void updateALLRows(Connection conn, String tableName, String columnVals) throws SQLException {
		String sql = "update " + tableName + " set " + columnVals + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to update column(s) in all rows...");
			preparedStatement.execute();
			System.out.println("Column(s) in all rows updated.");
		}
		
		catch(SQLException e) {
			System.out.println("Column updating failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
	
	}
	
	/**
	 * Uses update replace to edit part of a string value
	 * 
	 * @param conn: connection to database
	 * @param tableName: name of table containing row to be updated
	 * @param columnName: name of column to be updated and updated value ex. (email)
	 * @param condition(s): string condition for row(s) to be updated ex. (id = 100 or age < 30) if using
	 * multiple conditions separate each with the word and ex. (departmentID = 2 and position = 'Sales Rep')
	 * @param replaceOrig: original value to be replaced (ex. hotmail.com)
	 * @param replaceFinal: end value for part of string being replaced ex. (gmail.com)
	 */

	public static void updateRowReplace(Connection conn, String tableName, String columnName, String condition,
			String replaceOrig, String replaceFinal) throws SQLException {
		String sql = "update " + tableName + " set " + columnName + " = replace(" + columnName +
				", '" + replaceOrig + "' , '" + replaceFinal + "') where " + condition + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to update column(s)...");
			preparedStatement.execute();
			System.out.println("Column(s) updated.");
		}
		
		catch(SQLException e) {
			System.out.println("Column updating failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
		
	}
	
	
}
