package polytech.fish.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import polytech.fish.model.Fish;
import polytech.fish.model.Typology;

public class MainController {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_fish");
	private static EntityManager em = emf.createEntityManager();
	
	
	public static void test(){
		Typology typ = new Typology();
		List<Fish> fs = new ArrayList<Fish>();
		Fish f1 = new Fish();
		f1.setSpecies("ddd");
		f1.setWaterVolume(10);
		Fish f2 = new Fish();
		f2.setSpecies("dsssd");
		f2.setWaterVolume(10);
		fs.add(f1);
		fs.add(f2);
		typ.setGroup(null);
		typ.setName("test1");
		typ.setFish(fs);
		
		Typology typ1 = new Typology();
		typ1.setName("test11111");

		Fish f3 = new Fish();
		f3.setSpecies("dsssd333");
		f3.setWaterVolume(10);
		f3.setTypology(typ);
		em.getTransaction().begin();
		em.persist(typ);
		em.persist(f3);
		em.getTransaction().commit();
		
	}
	public static void insertFish(String species, float waterVolume, Typology typology) {
		
	}
}
