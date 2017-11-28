package polytech.fish.model;

import javax.persistence.*;

@Entity
public class Bassin {
	@Id@GeneratedValue
	private int id;
	
	private float capacity;
	private String material;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="bassin")
	private Groupe group;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Groupe getGroup() {
		return group;
	}

	public void setGroup(Groupe group) {
		this.group = group;
	}
	
}
