package com.x.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DbUtils_dbcp {
	private static BasicDataSource basicDataSource = null;
	static {
		try {
			Properties properties = new Properties();
			InputStream stream = DbUtils_dbcp.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			properties.load(stream);
			basicDataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		return basicDataSource.getConnection();
	}
	
	public static void release(ResultSet resultSet,Statement statement,Connection connection) {
		Common.release(resultSet, statement, connection);
	}
	
	public static int executeUpdate(String sqlString,Object...params) {
		try {
			return Common.executeUpdate(getConnection(), sqlString, params);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
