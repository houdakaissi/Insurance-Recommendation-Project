package org.lsi.entities;


import javax.persistence.*;


@Entity
@Table(name = "properties")
public class Proprety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String descc;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    public Proprety() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Proprety(Long id, String type, String desc, User owner) {
        super();
        this.id = id;
        this.type = type;
        this.descc = desc;
        this.owner = owner;
    }
    public Proprety(String descc) {
        this.descc = descc;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTypePrp() {
        return type;
    }
    public void setTypePrp(String typePrp) {
        this.type = typePrp;
    }
    public String getDesc() {
        return descc;
    }
    public void setDesc(String desc) {
        this.descc = desc;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }


}
