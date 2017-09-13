package com.x.dao;

import java.util.List;

public interface Db_MySql_Dao {
	public int insert(Object object);
	public int delete(Object object);
	public int update(Object object);
	public List<Object> selectAll();
	public Object selectOne(int id); 
}
