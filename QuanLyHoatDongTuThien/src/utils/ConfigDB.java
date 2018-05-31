package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

	public static Connection connection;
	public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTuThien";
	public static final String userName = "sa";
	public static final String password = "291121123";

	public static Connection moKetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
			return null;
		}
	}

	public static void dongKetNoi() {
		try {
			connection.close();
			System.out.print("Ket noi da duoc dong");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
