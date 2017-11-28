package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			System.out.println("class failed");
			System.out.println(cnf.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/TP_Analyse", "root", "phy8955743");
		} catch (SQLException ex) {
			System.out.println("failed");
			System.out.println(ex.getMessage());
		}
		return con;
	}
}
