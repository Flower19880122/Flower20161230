package com.haiberg.automation.support.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.haiberg.automation.util.Config;

public class DBconnection {
	public static Connection connection;
	public static Connection getDBconnection() throws SQLException{
		
		try {
			System.out.println("数据库的地址:"+Config.getProperty("DBurl"));
			System.out.println("连接数据库的密码："+Config.getProperty("DBusername"));
			System.out.println("连接数据库的密码："+Config.getProperty("DBpassword"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			Class.forName("org.postgresql.Driver");
			try {
				connection = DriverManager.getConnection(Config.getProperty("DBurl"),Config.getProperty("DBusername"),Config.getProperty("DBpassword"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void DBclose(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  
}
