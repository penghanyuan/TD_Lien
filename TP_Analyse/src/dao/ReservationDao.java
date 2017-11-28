package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class ReservationDao {
	private PreparedStatement ps;
	private Statement s;
	private Connection connection;

	public ReservationDao(Connection connection) {
		this.connection = connection;
	}

	public int insertReservation(int userId, int analyseId, Date date) {
		String sql = "Insert into Reservation(user,analyse,date) values (?,?,?)";
		int id = 0;
		try {
			ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userId);
			ps.setInt(2, analyseId);
			ps.setDate(3, date);

			id = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public Date selectMaxDate() {
		String sql = "Select max(date) from Reservation";
		Date date = null;
		try {
			s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				date = rs.getDate(1);
			} else {
				date = new Date(System.currentTimeMillis() + (24 * 3600 * 1000));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return date;
	}
}
