package org.lsi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	private String id_role; // Assuming you want to keep this as a String, adjust if necessary

	private ERole name;

	public Role() {
		super();
	}

	public Role(String id_role, ERole name) {
		super();
		this.id_role = id_role;
		this.name = name;
	}

	public String getId_role() {
		return id_role;
	}

	public void setId_role(String id_role) {
		this.id_role = id_role;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
