package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
*/

import oracle.jdbc.OracleDriver;

public class ConnectionUtil {
	public static Connection getConnection() throws IOException, SQLException {	
		DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@demodbinstance.cpu6nfnrb7q1.us-east-1.rds.amazonaws.com:1521:ORCL";
		String user = "mmanz1994";
		String password = "TheLead0";
		
//		Properties properties = new Properties();
//		InputStream inputStream = new FileInputStream("connection.properties");
//		properties.load(inputStream);
//		
//		String url = properties.getProperty("url");
//		String user = properties.getProperty("user");
//		String password = properties.getProperty("password");
		
		return DriverManager.getConnection(url, user, password);
	}
}
