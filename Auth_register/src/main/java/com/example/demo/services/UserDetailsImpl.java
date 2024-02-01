package com.example.demo.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String nom;

    private String prenom;

    private String tel;

    private String CIN;

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    private String account_address;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String id, String username, String password, String nom, String prenom,String CIN,String tel,
                           String account_address,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
        this.CIN=CIN;
        this.authorities = authorities;
        this.account_address = account_address;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = (user.getRoles()).stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                String.valueOf(user.getId()),
                user.getUsername(),
                user.getPassword(),
                user.getNom(),
                user.getPrenom(),
                user.getCIN(),
                user.getTel(),
                user.getAccount_address(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getId() {
        return id;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public String getTel() {
        return tel;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    public String getAcount_address() {
        return account_address;
    }

    public void setAcount_address(String acount_address) {
        this.account_address = acount_address;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}