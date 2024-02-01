package org.lsi.entities;
import org.lsi.repositories.UserRepository;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "complaintss") // Define the table name in MySQL
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private String date;
	private String email;

	private String reponse;


	//



	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private User buyer;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private User seller;







	//

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Complaint() {
		// Default constructor
	}

	public Complaint(String desc, String date, String email) {
		this.description = desc;
		this.date = date;
		this.email = email;
	}

	public Complaint(String desc, String date, String email, String reponse,User buyer, User seller) {
		this.description = desc;
		this.date = date;
		this.email = email;
		this.reponse = reponse;
	this.buyer = buyer;
		this.seller = seller;
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

