package services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import models.Vacancy;
import data.DbProvider;


public class VacsService {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	
	public VacsService() {
		conn = null;
		stmt = null;
		res = null;
	}
	
	public List<Vacancy> getAllVacancies() {
		List<Vacancy> vacs = new ArrayList<Vacancy>();
		try {
			conn = DbProvider.getOracleConnection();
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from VACANCIES order by VACANCY_ID");
			
			while (res.next()) {
				int id = res.getInt("VACANCY_ID");
				String position = res.getString("POSITION");
				int depId = res.getInt("DEP_ID");
				String duties = res.getString("DUTIES");
				String schedule = res.getString("SCHEDULE");
				float salary = res.getFloat("SALARY");
				int quantity = res.getInt("QUANTITY");				
				Vacancy vac = new Vacancy(id, position, depId, duties, schedule, salary, quantity);
				vacs.add(vac);
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
		return vacs;
	}
	
}
