package com.haiberg.automation.support.jdbc;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBquery {
	
	public static Statement statement;
	public static ResultSet resultset;
	public static ResultSet getQuriedResult(String sql){
		Connection connection = null;
		try {
			connection = DBconnection.getDBconnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultset;
		
		
	}
	//public static void statementClose(){
	//	try {
		//	statement.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	//}

	
}