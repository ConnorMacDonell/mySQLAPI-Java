package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryAPI {
	
	/**
	 * returns a resultset containing the data of a query with no conditions
	 * 
	 * @param conn:  connection to database
	 * @param select: csv string of columns to be selected
	 * @param tableName: string name of the table
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getData(Connection connection, String select, String tableName) throws SQLException {
		String sql = "select " + select + " from " + tableName + ";";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet results = preparedStatement.executeQuery();
		return results;
	}

	/**
	 * returns a resultset containing the data from a query with conditions
	 * 
	 * @param conn:  connection to database
	 * @param select: csv string of columns to be selected
	 * @param tableName: string name of the table
	 * @param condition: string csv of select conditions ex. (salary = 30000, position = 'sales rep')
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getDataConditional(Connection connection, String select, String tableName, String condition) throws SQLException {
		String sql = "select " + select + " from " + tableName + " where " + condition + ";";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet results = preparedStatement.executeQuery();
		return results;
	}
	
	/**
	 * returns a resultset containing the data of a fully articulated query
	 * 
	 * @param conn:  connection to database
	 * @param query: string, fully articualated sql query
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getDataQuery(Connection connection, String query) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet results = preparedStatement.executeQuery();
		return results;
	}
	
	/**
	 * returns a resultset containing the data of a query with no conditions but limited number of results
	 * 
	 * @param conn:  connection to database
	 * @param select: csv string of columns to be selected
	 * @param tableName: string name of the table
	 * @param limit: string max number of results from query
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getDataLimited(Connection connection, String select, String tableName, String limit) throws SQLException {
		String sql = "select " + select + " from " + tableName + " limit " + limit + ";";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet results = preparedStatement.executeQuery();
		return results;
	}
}
