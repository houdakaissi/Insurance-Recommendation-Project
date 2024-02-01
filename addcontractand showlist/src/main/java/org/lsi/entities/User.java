package org.lsi.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long user_id;
    private Long id;
    private String username;

    private String password;

    private String nom;

    private String prenom;

    private String tel;

    private String CIN;

    private String account_address;



   // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          //name = "users_roles",
          name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String nom, String prenom, String tel) {
        super();
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public User(Long id, String username, String password, String nom, String prenom,
                String tel, String CIN, String account_address, Set<Role> roles) {
        super();
      //  this.user_id = id;
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.CIN = CIN;
        this.account_address = account_address;
        this.roles = roles;
    }

    public Long getId() {
      // return user_id;
         return id;
    }

    public void setId(Long id) {
       // this.user_id = id;
        this.id = id;

    }

    public String getUsername() {
        return username;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getAccount_address() {
        return account_address;
    }

    public void setAccount_address(String account_address) {
        this.account_address = account_address;
    }
}
