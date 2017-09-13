package com.x.test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.x.utils.DbUtils_normal;

public class Test {
	public static void main(String[] args) {
		try {			
			 Connection connection = DbUtils_normal.getConnection();
			if(connection!=null) {
				System.out.println("连接成功");
			}else {
				System.out.println("连接失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
