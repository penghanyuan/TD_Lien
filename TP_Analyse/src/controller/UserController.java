package controller;

import dao.UserDao;

public class UserController {
	UserDao userDao;

	public UserController() {
		userDao = new UserDao(MyConnection.getConnection());
	}

	public void createNewUser(String nom, String prenom, String numSociale) {
		userDao.insertUser(nom, prenom, numSociale);
	}
}
