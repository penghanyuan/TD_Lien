package polytech.fish.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import polytech.fish.model.Fish;
import polytech.fish.model.Groupe;

public class GroupDao {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GroupDao(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}
	
	public Groupe getGroupById(int id){
		String sql = "select group from Groupe group where group.id = :id";
		Query query = em.createQuery(sql);
		Groupe result = null;
		query.setParameter("id", id);
		try {
			result = (Groupe) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result");
		}
		return result;
	}
}
