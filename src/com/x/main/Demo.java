package com.x.main;

import com.x.beans.Person;
import com.x.dao.imp.Db_MySql_Dao_PersonImp;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person(0, "С���", 26, "java����", 8000);
		Db_MySql_Dao_PersonImp dmdp = new Db_MySql_Dao_PersonImp();
		printResult(dmdp.insert(person)); 
	}
	
	public static void printResult(int result) {
		if (result>0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
	}

}
