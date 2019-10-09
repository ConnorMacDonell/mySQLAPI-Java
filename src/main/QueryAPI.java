package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.DatabaseMetaData;

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
		ResultSet results = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			results = preparedStatement.executeQuery();
		}
		
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
		return results;
	}
	
	/**
	 * returns a resultset containing the data of a query with no conditions but limited and ordered results
	 * 
	 * @param conn:  connection to database
	 * @param select: csv string of columns to be selected
	 * @param tableName: string name of the table
	 * @param orderBy: string csv of column(s) to order on as well as whether results should be returned in ascending or
	 * descending order ex. (salary asc, date_of_employment desc)
	 * @param limit: string max number of results from query
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getData(Connection connection, String select, String tableName, String orderBy, String limit) throws SQLException {
		
		String sql = "select " + select + " from " + tableName + " order by " + orderBy +  " limit " + limit + ";";
		ResultSet results = null;
		
		try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		results = preparedStatement.executeQuery();
		}
		
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
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
	
	public static ResultSet getData(Connection connection, String select, String tableName, String limit) throws SQLException {
		
		String sql = "select " + select + " from " + tableName + " limit " + limit + ";";
		ResultSet results = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			results = preparedStatement.executeQuery();
		}
		
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
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
		ResultSet results = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			results = preparedStatement.executeQuery();
		}
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
		return results;
	}
	
	/**
	 * returns a resultset containing the data from a query with conditions and ordered on certain columns
	 * 
	 * @param conn:  connection to database
	 * @param select: csv string of columns to be selected
	 * @param tableName: string name of the table
	 * @param condition: string csv of select conditions ex. (salary = 30000, position = 'sales rep')
	 * @param orderBy: string csv of column(s) to order on as well as whether results should be returned in ascending or
	 * descending order ex. (salary asc, date_of_employment desc)
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getDataConditional(Connection connection, String select, String tableName, String condition,
			String orderBy) throws SQLException {
		String sql = "select " + select + " from " + tableName + " where " + condition + " order by " + orderBy + ";";
		ResultSet results = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			results = preparedStatement.executeQuery();
		}
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
		return results;
	}
	
	/**
	 * returns a resultset containing the data from a query with conditions and ordered and limited
	 * 
	 * @param conn:  connection to database
	 * @param select: csv string of columns to be selected
	 * @param tableName: string name of the table
	 * @param condition: string csv of select conditions ex. (salary = 30000, position = 'sales rep')
	 * @param orderBy: string csv of column(s) to order on as well as whether results should be returned in ascending or
	 * descending order ex. (salary asc, date_of_employment desc)
	 * @param limit: string digit representing max number of results to return
	 * @return resultsSet containing the results. must be closed when finished with results of query
	 */
	
	public static ResultSet getDataConditional(Connection connection, String select, String tableName, String condition,
			String orderBy, String limit) throws SQLException {
		String sql = "select " + select + " from " + tableName + " where " + condition + " order by " + orderBy + 
				" limit " + limit + ";";
		ResultSet results = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			results = preparedStatement.executeQuery();
		}
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
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
		ResultSet results = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			results = preparedStatement.executeQuery();
		}
		catch(SQLException e) {
			System.out.println("Query failed.");
			e.printStackTrace();
			results = null;
		}
		return results;
	}
	
	/**
	 * returns the schema for the database
	 * @param conn: connection to database
	 * @return ArrayList<String> containing database schema
	 */
	public static ArrayList<String> getSchema(Connection conn) {
		ArrayList<String> output = new ArrayList<String>();
		try {
			java.sql.DatabaseMetaData meta = conn.getMetaData();
			ResultSet schemas = meta.getTables(null,null,"%",null);
			//ResultSet catalogs = meta.getCatalogs();
			while (schemas.next()) {
				output.add(schemas.getString("TABLE_NAME"));
			}
			schemas.close();
		} catch (SQLException e) {
			System.err.println("Retrieval of Schema Info failed!");
			e.printStackTrace();
			output.clear();
		}
		return output;
	}
	
}
