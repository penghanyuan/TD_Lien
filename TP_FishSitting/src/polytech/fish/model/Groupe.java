package polytech.fish.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Groupe {

	@Id
	@GeneratedValue
	private int id;

	private int feedingTimes;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Owner owner;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Bassin bassin;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Fish_Groupe", joinColumns = {
			@JoinColumn(name = "Group_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "Fish_ID", referencedColumnName = "species") })
	private List<Fish> fish;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFeedingTimes() {
		return feedingTimes;
	}

	public void setFeedingTimes(int feedingTimes) {
		this.feedingTimes = feedingTimes;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Bassin getBassin() {
		return bassin;
	}

	public void setBassin(Bassin bassin) {
		this.bassin = bassin;
		bassin.setGroup(this);
	}

	public List<Fish> getFish() {
		return fish;
	}

	public void setFish(List<Fish> fish) {
		this.fish = fish;
	}

}
