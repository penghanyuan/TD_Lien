import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

public class TP4 {
	private static Connection con = null;

	private static void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			System.out.println("class failed");
			System.out.println(cnf.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/TP4", "root", "phy8955743");
		} catch (SQLException ex) {
			System.out.println("failed");
			System.out.println(ex.getMessage());
		}
	}

	public static void InsertCopy() {
		System.out.println("Type the ISBN:");
		int ISBN;
		Scanner s = new Scanner(System.in);
		ISBN = s.nextInt();
		String sql = "SELECT NCopies FROM LIVRE WHERE ISBN = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ISBN);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				String sqlInsert = "insert into COPIE values(?,?);";
				PreparedStatement ps1 = con.prepareStatement(sqlInsert);
				int nc = rs.getInt("NCopies");
				ps1.setInt(1, ISBN);
				ps1.setInt(2, nc + 1);
				ps1.executeUpdate();
				System.out.println("Insert successfully!");
				
				Statement st = con.createStatement();
				st.executeUpdate("update LIVRE set NCopies = "+(nc + 1)+" where ISBN = "+ISBN);
				st.close();
				
			} else {
				SQLException e = new SQLException("Book not found!");
				throw e;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void InsertBook() {
		System.out.println("Type the ISBN of book:");
		int ISBN;
		Scanner s = new Scanner(System.in);
		ISBN = Integer.parseInt(s.nextLine());
		String sql = "SELECT ISBN FROM LIVRE WHERE ISBN = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ISBN);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				SQLException e = new SQLException("Book already existed!");
				throw e;
			} else {
				String description = null;
				String subject = null;
				int nCopies = 0;
				System.out.println("Type the desctiption of book:");
				description = s.nextLine();
				System.out.println("Type the subject of book:");
				subject = s.nextLine();

				String sqlInsert = "insert into LIVRE values(?,?,?,?);";
				PreparedStatement ps1 = con.prepareStatement(sqlInsert);
				ps1.setInt(1, ISBN);
				ps1.setString(2, description);
				ps1.setString(3, subject);
				ps1.setInt(4, nCopies);
				ps1.executeUpdate();
				System.out.println("Insert book successfully!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void ShowAverageTime() {
		System.out.println("Type the Id of people:");
		int id;
		List<Date> borrowDate = new ArrayList<Date>();
		List<Date> returnDate = new ArrayList<Date>();
		Scanner s = new Scanner(System.in);
		id = Integer.parseInt(s.nextLine());
		String sql = "SELECT eDate FROM EMPRUNTS WHERE Associe = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				borrowDate.add(rs.getDate("eDate"));
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		String sql1 = "SELECT rDate FROM RETOURS WHERE Associe = ?";
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, id);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				returnDate.add(rs.getDate("rDate"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (borrowDate.isEmpty() && returnDate.isEmpty()) {
			System.out.println(" Time is 0");
		} else {
			
			for (int i = 0; i < borrowDate.size(); i++) {
				//System.out.println(borrowDate);
				if (returnDate.size() > i) {
					System.out.println((returnDate.get(i).getTime()-borrowDate.get(i).getTime())/1000/3600/24);	
				}
			}
		}

	}

	public static void main(String[] args) {
		connection();
		int option = 0;
		System.out.println("Select your option:");
		System.out.println("	1.Insert a new copy");
		System.out.println("	2.Insert a new book");
		System.out.println("	3.Show average time");
		Scanner s = new Scanner(System.in);
		option = s.nextInt();

		switch (option) {
		case 1:
			InsertCopy();break;
		case 2:
			InsertBook();break;
		case 3:
			ShowAverageTime();break;
		}
		s.close();
	}

}
