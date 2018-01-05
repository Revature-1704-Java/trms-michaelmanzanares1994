package com.revature.bean;

public class Employee {
	private int empId;
	private String fname;
	private String lname;
	private String email;
	private Double availReimAmt;
	private int empTypeId;
	private String username;
	private String password;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", availReimAmt=" + availReimAmt + ", empTypeId=" + empTypeId + ", username=" + username
				+ ", password=" + password + "]";
	}

	public String availAmtString() {
		return "availReimAmt";
	}

	public Employee() {
	}

	public Employee(int empId, String fname, String lname, String email, Double availReimAmt, int empTypeId,
			String username, String password) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.availReimAmt = availReimAmt;
		this.empTypeId = empTypeId;
		this.username = username;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getAvailReimAmt() {
		return availReimAmt;
	}

	public void setAvailReimAmt(Double availReimAmt) {
		this.availReimAmt = availReimAmt;
	}

	public int getEmpTypeId() {
		return empTypeId;
	}

	public void setEmpTypeId(int empTypeId) {
		this.empTypeId = empTypeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return empId;
	}

	public void setId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
