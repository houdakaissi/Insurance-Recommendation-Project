package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_token")
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Size(max = 220)
	private String token;

	@ManyToOne
	//user_id
	@JoinColumn(name = "user_id")
	private User user;

	public Token() {
	}
//	@Size(max = 5)
	//private String truncatedToken;

	public Token(String jwt, User user) {
		//this.token = jwt;
		this.user = user;
		this.token =truncateToken(jwt);
	}
	private String truncateToken(String originalToken) {
		if (originalToken != null && originalToken.length() > 5) {
			return originalToken.substring(0, 5);
		}
		return originalToken;
	}
	public Token(Long id, String token, User user) {
		this.id = id;
		this.token =truncateToken(token);
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
