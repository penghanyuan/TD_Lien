package polytech.fish.model;

import javax.persistence.*;

@Entity
public class Fish {
	
	@Id@GeneratedValue
	private int id;
	private String species;
	private float waterVolume;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Typology typology;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public float getWaterVolume() {
		return waterVolume;
	}

	public void setWaterVolume(float waterVolume) {
		this.waterVolume = waterVolume;
	}

	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}
	
	
}
