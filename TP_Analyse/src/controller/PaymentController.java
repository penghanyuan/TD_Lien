package controller;

import java.sql.Date;

import dao.PaymentDao;

public class PaymentController {
	PaymentDao paymentDao;

	public PaymentController() {
		this.paymentDao = new PaymentDao(MyConnection.getConnection());
	}
	
	public void createPayment(int userId,String num_card, Date expireDate, int code, int reservation){
		paymentDao.insertPayment(userId, num_card, expireDate, code, reservation);
	}
	
}
