package com.revature.dao;

import java.io.IOException;
//import java.io.IOException;
import java.sql.Connection;

import com.revature.bean.Employee;
import com.revature.util.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.SQLException;

public class EmployeeDAO {
	/** logs in a user by there username and password and stores user information */
	public Employee employeeLogin(String username, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			while (rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String firstname = rs.getString("FNAME");
				String lastname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				Double availamt = rs.getDouble("AVAILREIMAMT");
				int employeeTypeId = rs.getInt("EMP_TYPE_ID");
				String user = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");

				employee = new Employee(employeeId, firstname, lastname, email, availamt, employeeTypeId, user, pass);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employee;
	}

	/** retrieve user by id */
	public int getEmpType(int empId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int empType = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT EMP_TYPE_ID FROM EMPLOYEE WHERE EMP_ID = " + empId;

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				empType = rs.getInt("EMPLOYEETYPEID");
				rs.close();
				return empType;
			}
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		return empType;
	}
}
