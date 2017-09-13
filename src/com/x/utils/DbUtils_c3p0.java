package com.x.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtils_c3p0 {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("mysql");
	
	public static Connection getConnection() throws Exception {
		return cpds.getConnection();
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
