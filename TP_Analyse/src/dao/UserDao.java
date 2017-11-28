package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserDao {
	private PreparedStatement ps;
	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public int insertUser(String nom, String prenom, String numSociale) {
		String sql = "Insert into User(nom,prenom,num_sociale) values (?,?,?)";
		int id = 0;
		try {
			ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, numSociale);

			id = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
}
