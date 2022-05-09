package services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Vacancy;
import models.Department;
import data.DbProvider;


public class DepsService {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	private int resultStatus;
	
	public DepsService() {
		conn = null;
		stmt = null;
		res = null;
		pstmt = null;
		resultStatus = 0;
	}
	
	public List<Department> getDepsStub() {
		return Arrays.asList(
			new Department(1, "Тестовий відділ 1"),	
			new Department(2, "Тестовий відділ 2"),
			new Department(3, "Тестовий відділ 3"),
			new Department(4, "Тестовий відділ 4"),
			new Department(5, "Тестовий відділ 5")
		);
	}
	
	public List<Department> getDepsFromDb() {
		List<Department> deps = new ArrayList<Department>();
		try {
			conn = DbProvider.getOracleConnection();
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from DEPARTMENTS order by DEP_ID");
			
			while (res.next()) {
				int id = res.getInt("DEP_ID");
				String name = res.getString("DEP_NAME");
				Department dep = new Department(id, name);
				deps.add(dep);
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
		return deps;
	}

	public boolean createDepartment(String depName) {
		boolean success = false;
		try {
			conn = DbProvider.getOracleConnection();
			pstmt = conn.prepareStatement("insert into DEPARTMENTS (DEP_NAME) values (?)");
			pstmt.setString(1, depName);
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

	public Department getDepartmentById(int depId) {
		Department dep = null;
		try {
			conn = DbProvider.getOracleConnection();
			pstmt = conn.prepareStatement("select * from DEPARTMENTS where DEP_ID=?");
			pstmt.setInt(1, depId);		
			res = pstmt.executeQuery();
			
			if (res.next()) {
				dep = new Department(depId, res.getString("DEP_NAME"));
			}
			
			res.close();
			pstmt.close();
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
		return dep;
	}

	public List<Vacancy> getVacanciesByDep(int depId) {
		List<Vacancy> vacancies = new ArrayList<Vacancy>();
		try {
			conn = DbProvider.getOracleConnection();
			pstmt = conn.prepareStatement("select * from VACANCIES where DEP_ID=?");
			pstmt.setInt(1,  depId);
			res = pstmt.executeQuery();
			
			while (res.next()) {
				int id = res.getInt("VACANCY_ID");
				String position = res.getString("POSITION");
				String duties = res.getString("DUTIES");
				String schedule = res.getString("SCHEDULE");
				float salary = res.getFloat("SALARY");
				int quantity = res.getInt("QUANTITY");
				Vacancy vacancy = new Vacancy(id, position, depId, duties, schedule, salary, quantity);
				vacancies.add(vacancy);
			}
			
			res.close();
			pstmt.close();
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
		return vacancies;
	}

	public boolean updateDepartment(String newDepName, int depId) {
		boolean success = false;
		try {
			conn = DbProvider.getOracleConnection();
			pstmt = conn.prepareStatement("update DEPARTMENTS set DEP_NAME=? where DEP_ID=?");
			pstmt.setString(1, newDepName);
			pstmt.setInt(2, depId);
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
