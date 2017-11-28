package model;

import java.sql.Date;

public class Reservation {
	private int reservationId;
	private int user;
	private int analyse;
	private Date date;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getAnalyse() {
		return analyse;
	}
	public void setAnalyse(int analyse) {
		this.analyse = analyse;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
