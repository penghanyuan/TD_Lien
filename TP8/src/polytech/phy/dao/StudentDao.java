package polytech.phy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import polytech.phy.model.Student;

public class StudentDao {

	private EntityManagerFactory emf;
	private EntityManager em;

	public StudentDao(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}

	public void insertStudent(Student student) {

		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}
	
	public List<Student> selectStudentByCity(String city){
		return null;
	}

}
