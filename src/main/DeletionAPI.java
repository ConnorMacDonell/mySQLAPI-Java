package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		String sqlStatement = "delete from '" + tableName + "' where " + condition + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		System.out.println("Removing row...");
		
		preparedStatement.execute();
		preparedStatement.close();

		System.out.println("Row removed.");
		
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
		String sqlStatement = "alter table " + tableName + " drop column " + columnName + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		System.out.println("Removing column...");
		
		preparedStatement.execute();
		preparedStatement.close();

		System.out.println("Column removed.");

	}
	
	/**
	 * Removes a table
	 * @param conn: connection to database
	 * @param tableName: name of table to be removed
	 * @return void
	 * 
	 */
	
	public static void removeTable(Connection conn, String tableName) throws SQLException{
		String sqlStatement = "drop table if exists " + tableName + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		System.out.println("Removing table...");
		
		preparedStatement.execute();
		preparedStatement.close();
		
		System.out.println("Table removed.");
	}
	
	/**
	 * Removes a database
	 * @param conn: connection to database
	 * @param tableName: name of database to be removed
	 * @return void
	 * 
	 */
	
	public static void removeDatabase(Connection conn, String databaseName) throws SQLException{
		String sqlStatement = "drop database if exists " + databaseName + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		System.out.println("Remove database...");
		
		preparedStatement.execute();
		preparedStatement.close();
		
		System.out.println("Database removed.");
	}
}
