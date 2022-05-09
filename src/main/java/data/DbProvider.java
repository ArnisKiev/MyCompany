package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbProvider {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_HOST = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String DB_USER = "COMPANY";
	private static final String DB_PASS = "Admin_123";
	
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);
		return DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);
	}
	
}
