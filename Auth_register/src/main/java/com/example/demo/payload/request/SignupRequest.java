package com.example.demo.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    
    
    @NotBlank
    @Size(max = 20)
    private String nom;
    
    @NotBlank
    @Size(max = 20)
    private String prenom;
    
    //@NotBlank
    @Size(max = 20)
    private String telephone;
    
    //@NotBlank
    @Size(max = 100)
    private String acount_address;
    
    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    @NotBlank
    @Size(min = 6, max = 40)
    private String wallet;
  
    public String getAcount_address() {
		return acount_address;
	}

	public void setAcount_address(String acount_address) {
		this.acount_address = acount_address;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}






	public String getUsername() {
        return username;
    }
    public String getWallet() {
        return wallet;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public void setRole(Set<String> roles) {
      this.roles = roles;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
    
    
}
