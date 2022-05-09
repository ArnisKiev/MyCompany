package services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Employee;
import data.DbProvider;


public class EmpsService {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	private int resultStatus;
	
	public EmpsService() {
		conn = null;
		stmt = null;
		res = null;
		pstmt = null;
		resultStatus = 0;
	}
	
	public List<Employee> getEmpsStub() {
		return Arrays.asList(
			new Employee(1, "Employee 1"),	
			new Employee(2, "Employee 2"),
			new Employee(3, "Employee 3"),
			new Employee(4, "Employee 4"),
			new Employee(5, "Employee 5")
		);
	}
	
	public List<Employee> getEmpsFromDb() {
		List<Employee> emps = new ArrayList<Employee>();
		try {
			conn = DbProvider.getOracleConnection();
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from EMPLOYEES");

			while (res.next()) {
				int id = res.getInt("EMP_ID");
				String fullname = res.getString("EMP_FULLNAME");
				Employee emp = new Employee(id, fullname);
				emps.add(emp);
			}
			
			res.close();
			stmt.close();
			conn.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFound-1: " + ex.getMessage());
		}
		catch (SQLException ex) {
			System.out.println("SQLException-1: " + ex.getMessage());
		}
		finally {
			try {
				if (res != null) {
					res.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException ex) {
				System.out.println("SQLException-2: " + ex.getMessage());
			}
		}
		return emps;
	}

	public boolean addNewEmployee(String empFullName) {
		boolean success = false;
		try {
			conn = DbProvider.getOracleConnection();
			pstmt = conn.prepareStatement("insert into EMPLOYEES (EMP_FULLNAME) values (?)");
			pstmt.setString(1, empFullName);
			resultStatus = pstmt.executeUpdate();
			
			if (resultStatus != 0) {
				success = true;
			}
			
			pstmt.close();
			conn.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFound-1: " + ex.getMessage());
			success = false;
		}
		catch (SQLException ex) {
			System.out.println("SQLException-1: " + ex.getMessage());
			success = false;
		}
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException ex) {
				System.out.println("SQLException-2: " + ex.getMessage());
			}
		}
		return success;
	}
}

