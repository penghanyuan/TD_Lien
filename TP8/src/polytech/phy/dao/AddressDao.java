package polytech.phy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import polytech.phy.model.Address;

public class AddressDao {

	private EntityManagerFactory emf;
	private EntityManager em;

	public AddressDao(EntityManagerFactory emf, EntityManager em) {
		super();
		this.emf = emf;
		this.em = em;
	}

	public void insertAddress(Address address) {
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
	}
}
