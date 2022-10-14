package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtility {
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/Case_Study","postgres","ashwisin");
			System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}