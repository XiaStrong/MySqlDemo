package com.x.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils_normal {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			Properties properties = new Properties();
			InputStream stream = DbUtils_normal.class.getClassLoader().getResourceAsStream("database.properties");
			properties.load(stream);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void release(ResultSet resultSet,Statement statement,Connection connection) {
		Common.release(resultSet, statement, connection);
	}
	
	public static int executeUpdate(String sqlString,Object...params) {
		try {
			return Common.executeUpdate(getConnection(), sqlString, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
}
