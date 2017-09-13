package com.x.test;

import static org.junit.Assert.*;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.x.beans.Person;
import com.x.dao.imp.Db_MySql_Dao_PersonImp;

public class PersonDbTest {

	@Test
	public void delete() {
		Db_MySql_Dao_PersonImp.setState(3);
		Person person = new Person(3, "С���", 26, "java����", 8000);
		Db_MySql_Dao_PersonImp dmdp = new Db_MySql_Dao_PersonImp();
		printResult(dmdp.delete(person));
	}
	
	@Test
	public void insert(){
		Db_MySql_Dao_PersonImp.setState(3);
		Person person = new Person(0, "С���", 26, "java����", 8000);
		Db_MySql_Dao_PersonImp dmdp = new Db_MySql_Dao_PersonImp();
		printResult(dmdp.insert(person));
		
	}
	
	@Test
	public void update() {
		Db_MySql_Dao_PersonImp.setState(3);
		Person person = new Person(4,"С�ϴ�",29,"��Ա",7000);
		Db_MySql_Dao_PersonImp dmdp = new Db_MySql_Dao_PersonImp();
		printResult(dmdp.update(person));
	}
	
	@Test
	public void select() {
		Db_MySql_Dao_PersonImp.setState(3);
		Db_MySql_Dao_PersonImp dmdp = new Db_MySql_Dao_PersonImp();
		List<Object> selectAll = dmdp.selectAll();
		for (Object object : selectAll) {
			System.out.println(object.toString());
		}
	}
	
	@Test
	public void seletOne() {
		Db_MySql_Dao_PersonImp.setState(3);
		Db_MySql_Dao_PersonImp dmdp = new Db_MySql_Dao_PersonImp();
		Object object = dmdp.selectOne(4);
		System.out.println(object.toString());
	}
	
	
	public void printResult(int result) {
		if (result>0) {
			System.out.println("�ɹ�");
		}else {
			System.out.println("ʧ��");
		}
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
