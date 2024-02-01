package org.lsi.controller.dto;

import java.math.BigInteger;

import java.util.Objects;


public class AddLandDto {
	String numeroContract;
    String idProprety;
    String ownerLand;
    String buyerLand;
    BigInteger cost;
    String desc;
    String date;
	boolean hascar;
	public AddLandDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddLandDto(String numeroContract, String idProprety, String ownerLand, String buyerLand, BigInteger cost,
			String desc, String date,boolean hascar) {
		super();
		this.numeroContract = numeroContract;
		this.idProprety = idProprety;
		this.ownerLand = ownerLand;
		this.buyerLand = buyerLand;
		this.cost = cost;
		this.desc = desc;
		this.date = date;
		this.hascar=hascar;
	}
	public String getNumeroContract() {
		return numeroContract;
	}
	public void setNumeroContract(String numeroContract) {
		this.numeroContract = numeroContract;
	}
	public String getIdProprety() {
		return idProprety;
	}
	public void setIdProprety(String idProprety) {
		this.idProprety = idProprety;
	}
	public String getOwnerLand() {
		return ownerLand;
	}
	public void setOwnerLand(String ownerLand) {
		this.ownerLand = ownerLand;
	}
	public String getBuyerLand() {
		return buyerLand;
	}
	public void setBuyerLand(String buyerLand) {
		this.buyerLand = buyerLand;
	}
	public BigInteger getCost() {
		return cost;
	}
	public void setCost(BigInteger cost) {
		this.cost = cost;
	}
	public void sethascar(boolean hascar) {
		this.hascar = hascar;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDate() {
		return date;
	}
	public boolean gethascar() {
		return hascar;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(buyerLand, cost, date, desc, idProprety, numeroContract, ownerLand);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddLandDto other = (AddLandDto) obj;
		return Objects.equals(buyerLand, other.buyerLand) && Objects.equals(cost, other.cost)
				&& Objects.equals(date, other.date) && Objects.equals(desc, other.desc)
				&& Objects.equals(idProprety, other.idProprety) && Objects.equals(numeroContract, other.numeroContract)
				&& Objects.equals(ownerLand, other.ownerLand);
	}
	
	

	

}
