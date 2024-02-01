package org.lsi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Adjust the type based on your requirements

	@NotBlank
	@Size(max = 20)
	private String token;

	// Assuming you have a user_id column in the database
	private Long user_id;

	public Token() {}

	public Token(String jwt, Long user_id) {
		this.token = jwt;
		this.user_id = user_id;
	}

	public Token(Long id, String token, Long user_id) {
		this.id = id;
		this.token = token;
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
