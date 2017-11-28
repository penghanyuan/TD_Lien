package polytech.phy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import polytech.phy.model.Professor;

public class ProfessorDao {
	private EntityManagerFactory emf;
	private EntityManager em;

	public ProfessorDao(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}

	public void insertProfessor(Professor professor) {

		em.getTransaction().begin();
		em.persist(professor);
		em.getTransaction().commit();
	}

	public Professor selectProfessorByName(String name) {
		String sql = "select professor from Professor professor where professor.name = :name";
		Query query = em.createQuery(sql);
		Professor result = null;
		query.setParameter("name", name);
		try {
			result = (Professor) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result");
		}
		return result;
	}
}
