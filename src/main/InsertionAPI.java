package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionAPI {
	
	/**
	 * Inserts a row of data into a table
	 * @param conn: connection to database
	 * @param tableName: name of the table into which data will be inserted
	 * @param attributes:  String csv of columns for values
	 * @param values:      String csv of entries for column in attributes
	 */
	
	public static void insertData(Connection connection, String tableName, String attributes, String values)
			throws SQLException {
		
		String sql = "insert into " + tableName + "(" + attributes + ")" + " values(" + values + ");";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("Preparing to insert row...");
		
		preparedStatement.execute();
		preparedStatement.close();
		
		System.out.println("Row inserted.");
	}
	
	/**
	 * adds a column to a table
	 * 
	 * @param conn: connection to database
	 * @param tableName: name of the table into which column will be inserted
	 * @param columnName: name of column to be inserted
	 * @param type: type of the column such as integer/text/primary key/ not null etc
	 */
	
	public static void addColumn(Connection conn, String tableName, String name, String type)
			throws SQLException {
		
		String sql = "alter table " + tableName + " add column " + name + " " + type + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		System.out.println("Preparing to add column...");
		
		preparedStatement.execute();
		preparedStatement.close();
		
		System.out.println("Column added.");
	}
	
	/**
	 * Adds a new table to the database
	 * @param conn: connection to database
	 * @param tableName: name of the table
	 * @param columnData: csv specification of column types for table
	 */
	
	public static void createTable(Connection conn, String tableName, String columnData) throws SQLException {
		
		if (!columnData.contains("primary key") && !columnData.contains("PRIMARY KEY")) {
			columnData = "id integer primary key not null auto_increment" + columnData;
		}
		
		String sql = "create table if not exists " + tableName + "(" + columnData + ");";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		System.out.println("Preparing to create table...");
		
		preparedStatement.executeUpdate(sql);
		preparedStatement.close();
		
		System.out.println("Table created.");
	}

}
