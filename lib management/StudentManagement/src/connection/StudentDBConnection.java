package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDBConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/libmanage";
	static Connection conn;

	// Database Credentials
	static final String user = "root";
	static final String password = "";

	public static Connection createC() {
		try {
			// Load the driver explicitly before creating the connection
			Class.forName(JDBC_DRIVER);

			// Create the connection
			conn = DriverManager.getConnection(DB_URL, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
