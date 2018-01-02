package com.revature.dao;

import java.sql.Connection;
import com.revature.util.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

	public void checkConnection() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("connected successfully");

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/** returns true if user name and password match in database */
	public boolean employeeLogin(String uname, String pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean status = false;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			while(rs.next()) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
