package com.example.demo.payload.response;

import java.util.List;


public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String id;
	private String username;
	  private String nom;
	  private String prenom;
	  private String password;
	  private String tel;
	  private String CIN;
	  public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}

	private String account_address;
	private List<String> roles;

	public JwtResponse(String accessToken, String id, String username,String password,String nom, String prenom,String CIN,String tel,String account_address, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.password = password;
		this.nom=nom;
		this.prenom=prenom;
		this.CIN=CIN;
		this.tel=tel;
		this.account_address =account_address;
		this.roles = roles;
	}

	public String getAccount_address() {
		return account_address;
	}

	public void setAccount_address(String account_address) {
		this.account_address = account_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<String> getRoles() {
		return roles;
	}
}
