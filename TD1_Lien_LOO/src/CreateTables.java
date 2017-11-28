import java.sql.*;
public class CreateTables {

	public static void main(String[] args) {
		Connection con = null;
		String sql = "create table Fournisseurs ("
				+ "CodeFournisseur int NOT NULL AUTO_INCREMENT,"
				+ "Nom varchar(255), "
				+ "Adresse varchar(255), "
				+ "Ville varchar(255),"
				+ "PRIMARY KEY (CodeFournisseur)"
				+ ")";
		String sql2 =  "create table Produits ("
				+ "CodeProduit int NOT NULL AUTO_INCREMENT,"
				+ "Type varchar(255), "
				+ "Marque varchar(255), "
				+ "Modele varchar(255),"
				+ "PRIMARY KEY (CodeProduit)"
				+ ")";
	    String sql3 =  "create table Catalogue("
				+ "Fournisseur int NOT NULL,"
				+ "Produit int NOT NULL,"
				+ "Prix float,"
				+ "PRIMARY KEY(Fournisseur,Produit),"
				+ "FOREIGN KEY (Fournisseur) REFERENCES Fournisseurs(CodeFournisseur),"
				+ "FOREIGN KEY (Produit) REFERENCES Produits(CodeProduit)"
				+ ")";
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
			System.out.println(sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.close();
		}
		catch(SQLException ex){
			System.out.println("sql failed");
			System.out.println(ex.getMessage());
		}
		finally{
			if (con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
