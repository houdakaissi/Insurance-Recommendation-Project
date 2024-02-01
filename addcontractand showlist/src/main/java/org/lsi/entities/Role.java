package org.lsi.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //private Long id_role;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;




  @Enumerated(EnumType.STRING)
  @Column(name = "name", length = 20)
  private ERole name;

  public Role() {}

  public Role(ERole name) {
    this.name = name;
  }

  public Long getId() {
    return id;
    //return id_role;
  }

  public void setId(Long id) {
    this.id = id;
    //this.id_role = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }
}
