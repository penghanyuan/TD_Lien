package polytech.fish.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Typology {

	@Id
	private String name;
	private String description;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "typology")
	private List<Fish> fish;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Groupe group;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Fish> getFish() {
		return fish;
	}

	public void setFish(List<Fish> fish) {
		this.fish = fish;

		for (Fish f : fish) {
			f.setTypology(this);
		}
		
	}


}
