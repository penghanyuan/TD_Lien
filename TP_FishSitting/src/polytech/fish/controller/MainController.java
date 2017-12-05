package polytech.fish.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import polytech.fish.dao.*;
import polytech.fish.model.*;

public class MainController {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_fish");
	private static EntityManager em = emf.createEntityManager();
	private static FishDao fishDao = new FishDao(emf, em);
	private static BassinDao bassinDao = new BassinDao(emf, em);
	private static GroupDao groupDao = new GroupDao(emf, em);
	
	public static void initData() {

		Typology typology = new Typology();
		Typology typology2 = new Typology();
		Typology typology3 = new Typology();
		
		typology.setName("River");
		typology2.setName("Sea");
		typology3.setName("Ground");
		
		MainController.insertFish("Liyu", 1.2f, typology);
		MainController.insertFish("Jiyu", 1.5f, typology);
		MainController.insertFish("Sanwenyu", 2.4f, typology2);
		MainController.insertFish("Niqiu", 4f, typology3);
		
		Groupe group = new Groupe();
		Groupe group1 = new Groupe();
	
		
		List<Fish> listF = new ArrayList<Fish>();
		List<Fish> listF1 = new ArrayList<Fish>();
		listF.add(em.find(Fish.class, "Jiyu"));
		
		listF.add(em.find(Fish.class, "Jiyu"));
		group.setFish(listF);
		//group1.setFish(listF1);
		em.getTransaction().begin();
		em.persist(group);
		//em.persist(group1);
		em.getTransaction().commit();
		
		String sql = "select group from Groupe group where group.id = :id";
		Query query = em.createQuery(sql);
		//List<Fish> result = null;
		Groupe result = null;
		query.setParameter("id", 1);
		try {
			result =  (Groupe) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result");
		}
		System.out.println(result.getFish());
		
	}

	public static Fish insertFish(String species, float waterVolume, Typology typology) {
		Fish fish = new Fish();
		fish.setSpecies(species);
		fish.setWaterVolume(waterVolume);
		fish.setTypology(typology);
		fishDao.insertFish(fish);
		return fish;
	}

	public static void insertBassin(float capacity, String material, Groupe group) {
		Bassin bassin = new Bassin();
		bassin.setCapacity(capacity);
		bassin.setMaterial(material);
		bassin.setGroup(group);
		bassinDao.insertBassin(bassin);
	}

	public static boolean verifySpecies(int groupId) {
		boolean result = true;
		Groupe group = groupDao.getGroupById(groupId);
//		if (group.getTypologies().size() == 1) {
//			Typology typology = group.getTypologies().get(0);
//			String species = typology.getFish().get(0).getSpecies();
//			for (Fish fish : typology.getFish()) {
//				if (!species.equalsIgnoreCase(fish.getSpecies())) {
//					result = false;
//					break;
//				}
//			}
//		} else {
//			result = false;
//		}
		return result;
	}

}
