package org.coffee.barva;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

//JDBC 연결 테스트 코드 만들기 >>Run As > JUnit Test
public class MySQLConnectionTest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://serenatte.iptime.org:7778/barva";
	private static final String USER = "barva";
	private static final String PW = "barva";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
