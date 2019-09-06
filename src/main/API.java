package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class API {
	
	/*
	 * Removes a row
	 * @param conn: conneciton to database
	 * @param tableName: name of table from which data will be removed
	 * @param condition: condition for removal (ex. ID < 10)
	 * @return whether removal was successful
	 * 
	 */
	
	public static boolean removeData(Connection conn, String tableName, String condition) throws SQLException{
		String sqlStatement = "delete from '" + tableName + "' where " + condition + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		return preparedStatement.execute();
	}
	
	/*
	 * Removes a column
	 * @param conn: connection to database
	 * @param tableName: name of table from which column is to be removed
	 * @param columnName: name of column to be removed
	 * @return whether removal was successful
	 * 
	 */
	
	public static boolean removeColumn(Connection conn, String tableName, String columnName) throws SQLException {
		String sqlStatement = "alter table " + tableName + " drop column " + columnName + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		return preparedStatement.execute();
	}
	
	/*
	 * Removes a table
	 * @param conn: connection to database
	 * @param tableName: name of table to be removed
	 * @return whether removal was successful
	 * 
	 */
	
	public static boolean removeTable(Connection conn, String tableName) throws SQLException{
		String sqlStatement = "drop table if exists " + tableName + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		return preparedStatement.execute();
	}
	
	/*
	 * Adds a row with data
	 * @param conn: connection to database
	 * @param tableName: name of table into which data will be added
	 * @param attributes: column attributes of table (CSV String)
	 * @param values: values of data to be added (CSV String)
	 * @return whether operation was successful
	 * 
	 */
	
	public static boolean insertRow(Connection conn, String tableName,
			String attributes, String values) throws SQLException{
		String sqlStatement = "insert into " + tableName + "(" + attributes + ") values " + values + ";";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
		
		return preparedStatement.execute();
		
	}
	
	
}
