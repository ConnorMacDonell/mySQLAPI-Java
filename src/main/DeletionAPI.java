package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DeletionAPI {
	
	/**
	 * Removes a row
	 * @param conn: connection to database
	 * @param tableName: name of table from which data will be removed
	 * @param condition: condition for removal (ex. ID < 10)
	 * @return void
	 * 
	 */
	
	public static void removeData(Connection conn, String tableName, String condition) throws SQLException{
		String sql = "delete from '" + tableName + "' where " + condition + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to delete data...");
			preparedStatement.execute();
			System.out.println("Data deleted.");
		}
		
		catch(SQLException e) {
			System.out.println("Data deletion failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
		
	}
	
	/**
	 * Removes a column
	 * @param conn: connection to database
	 * @param tableName: name of table from which column is to be removed
	 * @param columnName: name of column to be removed
	 * @return void
	 * 
	 */
	
	public static void removeColumn(Connection conn, String tableName, String columnName) throws SQLException {
		String sql = "alter table " + tableName + " drop column " + columnName + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to delete column...");
			preparedStatement.execute();
			System.out.println("Column deleted.");
		}
		
		catch(SQLException e) {
			System.out.println("Column deletion failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
	}
	
	/**
	 * Removes a table
	 * @param conn: connection to database
	 * @param tableName: name of table to be removed
	 * @return void
	 * 
	 */
	
	public static void removeTable(Connection conn, String tableName) throws SQLException{
		String sql = "drop table if exists " + tableName + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to delete table...");
			preparedStatement.execute();
			System.out.println("Table deleted.");
		}
		
		catch(SQLException e) {
			System.out.println("Table deletion failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
	}
	
	/**
	 * Removes a database
	 * @param conn: connection to database
	 * @param tableName: name of database to be removed
	 * @return void
	 * 
	 */
	
	public static void removeDatabase(Connection conn, String databaseName) throws SQLException{
		String sql = "drop database if exists " + databaseName + ";";
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			System.out.println("Preparing to delete database...");
			preparedStatement.execute();
			System.out.println("Database deleted.");
		}
		
		catch(SQLException e) {
			System.out.println("Database deletion failed.");
			e.printStackTrace();
		}
		
		finally {
			preparedStatement.close();
		}
	}
}
