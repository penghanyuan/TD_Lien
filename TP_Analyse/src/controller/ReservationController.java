package controller;

import java.sql.Date;

import dao.ReservationDao;
import dao.UserDao;
import model.User;

public class ReservationController {
	ReservationDao reservationDao;

	public ReservationController() {
		this.reservationDao = new ReservationDao(MyConnection.getConnection());
	}

	public void createNewReservation(int userId, int analyseId, Date date) {
		reservationDao.insertReservation(userId, analyseId, date);
	}

	public Date calculeDate() {
		return reservationDao.selectMaxDate();
	}
}
