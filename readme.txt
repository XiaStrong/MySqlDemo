对mySql数据库的使用做下总结

1.开始
	导入mysql-connector-java-5.1.43-bin.jar包
	
2.使用dbcp操作需要导入以下jar包
	commons-dbcp2-2.1.1.jar
	commons-logging-1.2.jar
	commons-pool2-2.4.2.jar
	
3.使用c3p0需要导入以下jar包
	c3p0-0.9.5.2.jar
	mchange-commons-java-0.2.11.jar
	

4.将基础操作，dbcp，c3p0封装成工具方法

5.配置文件为
	database.properties
	dbcpconfig.properties
	c3p0-config.xml

6.以以下数据库设计进行增删改查操作
CREATE DATABASE personManger;
USE personManger;

CREATE TABLE person(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(16) NOT NULL,
	age INT,
	job VARCHAR(32),
	salary DECIMAL(10,2)
)