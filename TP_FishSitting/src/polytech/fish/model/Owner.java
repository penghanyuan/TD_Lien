package polytech.fish.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Owner {
	
	@Id@GeneratedValue
	private int id;
	
	private String name;
	private String telephone;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="owner")
	private List<Groupe> group;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Groupe> getGroup() {
		return group;
	}

	public void setGroup(List<Groupe> group) {
		this.group = group;
	}
	
	
}
