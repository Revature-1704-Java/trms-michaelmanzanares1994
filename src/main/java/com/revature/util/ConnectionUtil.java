package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class ConnectionUtil {
	public static Connection getConnection() throws IOException, SQLException {
		DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@demodbinstance.cpu6nfnrb7q1.us-east-1.rds.amazonaws.com:1521:ORCL";
		String user = "mmanz1994";
		String password = "TheLead0";

		return DriverManager.getConnection(url, user, password);
	}
}
