import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		Connection con = null;
		String sql = "insert into Fournisseurs values(001,'Dubois','Rue Paul Bert', 'Paris');";
		String sql1 = "insert into Fournisseurs values(002,'Dupont','Avenue Generale De Gaulle', 'Toulouse');";
		String sql2 = "insert into Fournisseurs values(003,'Cuissart','Rue Vaugirard', 'Lyon');";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException cnf){
			System.out.println("class failed");
			System.out.println(cnf.getMessage());
			System.exit(1);
		}
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost/TD_Lien",
					"root","phy8955743"
					);
		}
		catch(SQLException ex){
			System.out.println("failed");
			System.out.println(ex.getMessage());
		}
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		}
		catch(SQLException ex){
			System.out.println(sql);
			System.out.println(ex.getMessage());
		}
	}

}
