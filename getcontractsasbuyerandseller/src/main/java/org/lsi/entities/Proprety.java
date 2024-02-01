package org.lsi.entities;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class Proprety {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String typePrp;
	private String descc;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	// Constructors, getters, and setters...


	
	public Proprety() {

		// TODO Auto-generated constructor stub
	}
	
	public  Proprety(Long id, String typePrp, String desc, User owner) {
		super();
		this.id = id;
		this.typePrp = typePrp;
		this.descc = desc;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypePrp() {
		return typePrp;
	}
	public void setTypePrp(String typePrp) {
		this.typePrp = typePrp;
	}
	public String getDesc() {
		return descc;
	}
	public void setDesc(String desc) {
		this.descc = desc;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
