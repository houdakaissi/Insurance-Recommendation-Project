package org.lsi.entities;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "contracts")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private User buyer;

	@ManyToOne
	@JoinColumn(name = "seller_id")
	private User seller;

	private BigInteger cost;
	private String date;

	@ManyToOne
	@JoinColumn(name = "property_id")
	private Proprety property;

	private String descc;

	// Constructors, getters, and setters...


	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(Long id, User buyer, User seller, BigInteger cost, String date, Proprety property, String desc) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.seller = seller;
		this.cost = cost;
		this.date = date;
		this.property = property;
		this.descc = descc;
	}
	
	

	public Contract(User buyer, User seller, BigInteger cost, String date, Proprety proprety, String desc) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.cost = cost;
		this.date = date;
		this.property = proprety;
		this.descc = descc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public BigInteger getCost() {
		return cost;
	}

	public void setCost(BigInteger cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Proprety getProp() {
		return property;
	}

	public void setProp(Proprety prop) {
		this.property = prop;
	}

	public String getDesc() {
		return descc;
	}

	public void setDesc(String desc) {
		this.descc = descc;
	}

	
}
