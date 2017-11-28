package polytech.phy.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import polytech.phy.dao.AddressDao;
import polytech.phy.dao.PersonDao;
import polytech.phy.dao.ProfessorDao;
import polytech.phy.dao.StudentDao;
import polytech.phy.model.*;

public class MainController {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp8");;
	private static EntityManager em = emf.createEntityManager();
	private static StudentDao studentDao = new StudentDao(emf, em);
	private static ProfessorDao professorDao = new ProfessorDao(emf, em);
	private static AddressDao addressDao = new AddressDao(emf, em);
	private static PersonDao personDao = new PersonDao(emf, em);

	public static Student insertStudent(String name, String phoneNumber, String email, String stuNumber, double aveMark,
			Address address) {

		Student student = new Student();
		student.setName(name);
		student.setPhoneNumber(phoneNumber);
		student.setEmailAddress(email);
		student.setStudentNumber(stuNumber);
		student.setAverageMark(aveMark);
		student.setAddress(address);
		studentDao.insertStudent(student);
		return student;
	}

	public static Professor insertProfessor(String name, String phoneNumber, String email, double salary,
			Address address) {
		Professor professor = new Professor();
		professor.setName(name);
		professor.setEmailAddress(email);
		professor.setPhoneNumber(phoneNumber);
		professor.setSalary(salary);
		professor.setAddress(address);
		professorDao.insertProfessor(professor);
		return professor;
	}

	public static Address insertAddress(String street, String city, String state, String postalCode, String country) {
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setPostalCode(postalCode);
		address.setState(state);
		address.setStreet(street);
		addressDao.insertAddress(address);
		return address;
	}

	public static Address insertAddress(Address address) {
		addressDao.insertAddress(address);
		return address;
	}

	public static List<Person> findPersonByCountry(String country) {
		return personDao.selectPersonByCountry(country);
	}
	
	public static void findProfessorByName(String name){
		System.out.println(professorDao.selectProfessorByName(name).getName());
	}
}
