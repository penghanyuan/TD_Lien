package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDao {
	private PreparedStatement ps;
	private Connection connection;
	
	public PaymentDao(Connection connection){
		this.connection = connection;
	}
	
	public void insertPayment(int userId,String num_card, Date expireDate, int code, int reservation){
		String sql = "Insert into Payment(user,num_card,expire_date,code,pay_date,reservation) values (?,?,?,?,?,?)";
		
		try {
			ps = connection.prepareStatement(sql);			
			ps.setInt(1, userId);
			ps.setString(2, num_card);
			ps.setDate(2, expireDate);
			ps.setInt(4, code);
			ps.setDate(5, new Date(System.currentTimeMillis()));
			ps.setInt(6, reservation);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
