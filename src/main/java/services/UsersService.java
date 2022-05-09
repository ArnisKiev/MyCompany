package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.DbProvider;

public class UsersService {

	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	private int resultStatus;
	private String query;
	
	public UsersService() {
		conn = null;
		stmt = null;
		res = null;
		pstmt = null;
		resultStatus = 0;
		query = "";
	}
	
	public boolean addUser(String login, String passw, String email, int roleId, int statusId) {
		boolean success = false;
		try {
			query = "insert into USERS";
			query += " (LOGIN, PASSW, EMAIL, ROLE_ID, STATUS_ID)";
			query += " values (?, ?, ?, ?, ?)";			
			conn = DbProvider.getOracleConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, login);
			pstmt.setString(2, passw);
			pstmt.setString(3, email);
			pstmt.setInt(4, roleId);
			pstmt.setInt(5, statusId);
			
			resultStatus = pstmt.executeUpdate();			
			if (resultStatus != 0) {
				success = true;
			}
			
			pstmt.close();
			conn.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("addUser-ClassNotFoundException: " + ex.getMessage());
			success = false;
		}
		catch (SQLException ex) {
			System.out.println("addUser-SQLException1: " + ex.getMessage());
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
				System.out.println("addUser-SQLException2: " + ex.getMessage());
			}
		}
		return success;
	}
	
	public boolean checkUser(String login, String passw) {
		boolean success = false;
		try {
			conn = DbProvider.getOracleConnection();			
			
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from USERS where LOGIN=?, PASSW=?");
			pstmt.setString(1, login);
			pstmt.setString(2, passw);
			if (!res.next()) {
				success = true;
			}
			
			pstmt.close();
			conn.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("checkUser-ClassNotFoundException: " + ex.getMessage());
			success = false;
		}
		catch (SQLException ex) {
			System.out.println("checkUser-SQLException1: " + ex.getMessage());
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
				System.out.println("checkUser-SQLException2: " + ex.getMessage());
			}
		}
		return success;
	}
	
}
