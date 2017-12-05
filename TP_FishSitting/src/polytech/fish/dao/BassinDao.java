package polytech.fish.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import polytech.fish.model.Bassin;
import polytech.fish.model.Fish;

public class BassinDao {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public BassinDao(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}
	
	public void insertBassin(Bassin bassin){
		em.getTransaction().begin();
		em.persist(bassin);
		em.getTransaction().commit();
	}
}
