package com.x.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Common {
	public static void release(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if (resultSet!=null) {
				resultSet.close();
			}
			if (statement!= null) {
				statement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static int executeUpdate(Connection connection,String sqlString,Object...params) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlString);
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i+1, params[i]);
			}
			int result = preparedStatement.executeUpdate();
			System.out.println("result="+result);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			release(null, preparedStatement, connection);
		}
	}
}
