package sample01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static final String URL = "jdbc:mysql://localhost/test";
	private static final String USER = "root";
	private static final String PASS = "";

	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			throw new NoClassDefFoundError();
		}
	}
	
	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASS);
	}
	
	public static void close(Connection conn, Statement stmt){
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException iqnore) {

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException iqnore) {

			}
		}

	}
}
