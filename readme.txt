��mySql���ݿ��ʹ�������ܽ�

1.��ʼ
	����mysql-connector-java-5.1.43-bin.jar��
	
2.ʹ��dbcp������Ҫ��������jar��
	commons-dbcp2-2.1.1.jar
	commons-logging-1.2.jar
	commons-pool2-2.4.2.jar
	
3.ʹ��c3p0��Ҫ��������jar��
	c3p0-0.9.5.2.jar
	mchange-commons-java-0.2.11.jar
	

4.������������dbcp��c3p0��װ�ɹ��߷���

5.�����ļ�Ϊ
	database.properties
	dbcpconfig.properties
	c3p0-config.xml

6.���������ݿ���ƽ�����ɾ�Ĳ����
CREATE DATABASE personManger;
USE personManger;

CREATE TABLE person(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(16) NOT NULL,
	age INT,
	job VARCHAR(32),
	salary DECIMAL(10,2)
)