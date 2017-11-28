package polytech.fish.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import polytech.fish.model.Fish;

public class FishDao {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public FishDao(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}
	
	public void insertFish(Fish fish){
		em.getTransaction().begin();
		em.persist(fish);
		em.getTransaction().commit();
	}
}
