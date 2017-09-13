package com.x.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.x.beans.Person;
import com.x.dao.Db_MySql_Dao;
import com.x.utils.Common;
import com.x.utils.DbUtils_c3p0;
import com.x.utils.DbUtils_dbcp;
import com.x.utils.DbUtils_normal;

public class Db_MySql_Dao_PersonImp implements Db_MySql_Dao {
	/**
	 * 1:normal
	 * 2:dbcp
	 * 3:c3p0
	 */
	private static int state = 1;
	
	public static int getState() {
		return state;
	}


	public static void setState(int state) {
		Db_MySql_Dao_PersonImp.state = state;
	}


	@Override
	public int insert(Object object) {
		// TODO Auto-generated method stub
		Person person = (Person)object;
		String sqlString = "insert into person(id,name,age,job,salary) values (?,?,?,?,?)";
		Object [] params  = {person.getId(),person.getName(),person.getAge(),person.getJob(),person.getSalary()};
		int result = 0;
		if (state == 1) {
			result = DbUtils_normal.executeUpdate(sqlString, params);
		}else if (state ==2) {
			result = DbUtils_dbcp.executeUpdate(sqlString, params);
		}else {
			System.out.println("3");

			result = DbUtils_c3p0.executeUpdate(sqlString, params);
		}
		return result;
	}
	

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		Person person = (Person)object;
		String sqlString = "delete from person where id = ?";
		Object [] params = {person.getId()};
		int result = 0;
		if (state == 1) {
			result = DbUtils_normal.executeUpdate(sqlString, params);
		}else if (state ==2) {
			result = DbUtils_dbcp.executeUpdate(sqlString, params);
		}else {
			result = DbUtils_c3p0.executeUpdate(sqlString, params);
		}
		return result;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		Person person = (Person)object;
		String sqlString = "update person set name=?,age =?,job=?,salary=? where id = ?";

		Object [] params  = {person.getName(),person.getAge(),person.getJob(),person.getSalary(),person.getId()};
		int result = 0;
		if (state == 1) {
			result = DbUtils_normal.executeUpdate(sqlString, params);
		}else if (state ==2) {
			result = DbUtils_dbcp.executeUpdate(sqlString, params);
		}else {
			result = DbUtils_c3p0.executeUpdate(sqlString, params);
		}
		return result;
	}

	@Override
	public List<Object> selectAll() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Object>list = new ArrayList<>();
		try {
			if (state == 1) {
				connection = DbUtils_normal.getConnection();
			}else if (state == 2) {
				connection = DbUtils_dbcp.getConnection();
			}else {
				connection = DbUtils_c3p0.getConnection();
			} 
			preparedStatement = connection.prepareStatement("select * from person");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String job = resultSet.getString("job");
				double salary = resultSet.getDouble("salary");
				Person person = new Person(id, name, age, job, salary);
				list.add(person);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			Common.release(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public Object selectOne(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Person person  = null;
		try {
			if (state == 1) {
				connection = DbUtils_normal.getConnection();
			}else if (state == 2) {
				connection = DbUtils_dbcp.getConnection();
			}else {
				connection = DbUtils_c3p0.getConnection();
			} 
			preparedStatement = connection.prepareStatement("select * from person where id = ?");
			preparedStatement.setObject(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String job = resultSet.getString("job");
				double salary = resultSet.getDouble("salary");
				person = new Person(id, name, age, job, salary);
			}
			return person;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			Common.release(resultSet, preparedStatement, connection);
		}
	}

}
