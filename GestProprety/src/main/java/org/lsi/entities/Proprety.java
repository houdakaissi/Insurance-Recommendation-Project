package org.lsi.entities;

import javax.persistence.*;

@Entity
public class Proprety {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String typePrp;
	String desc;


	@ManyToOne
	private User owner;
	// Other fields and methods...

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Other getters and setters...



public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
