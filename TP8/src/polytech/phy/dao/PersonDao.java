package polytech.phy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import polytech.phy.model.Person;
public class PersonDao {
	private EntityManagerFactory emf;
	private EntityManager em;

	public PersonDao(EntityManagerFactory emf, EntityManager em) {
		this.emf = emf;
		this.em = em;
	}

	public List<Person> selectPersonByCountry(String country) {
		String querySql = "SELECT person FROM Person person WHERE person.address.country = :country";
		Query query = em.createQuery(querySql);
		query.setParameter("country", country);
		List<Person> result = query.getResultList();
		return result;
	}

}
