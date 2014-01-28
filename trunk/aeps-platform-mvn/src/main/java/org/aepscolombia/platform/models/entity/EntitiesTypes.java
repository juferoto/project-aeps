package org.aepscolombia.platform.models.entity;
// Generated Jan 21, 2014 11:35:29 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EntitiesTypes generated by hbm2java
 */
@Entity
@Table(name="entities_types"
    ,catalog="madr_bd10"
)
public class EntitiesTypes  implements java.io.Serializable {


     private Integer idEntTyp;
     private String nameEntTyp;

    public EntitiesTypes() {
    }

    public EntitiesTypes(Integer idEntTyp) {
        this.idEntTyp = idEntTyp;
    }
	
    public EntitiesTypes(String nameEntTyp) {
        this.nameEntTyp = nameEntTyp;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_ent_typ", unique=true, nullable=false)
    public Integer getIdEntTyp() {
        return this.idEntTyp;
    }
    
    public void setIdEntTyp(Integer idEntTyp) {
        this.idEntTyp = idEntTyp;
    }
    
    @Column(name="name_ent_typ", nullable=false, length=45)
    public String getNameEntTyp() {
        return this.nameEntTyp;
    }
    
    public void setNameEntTyp(String nameEntTyp) {
        this.nameEntTyp = nameEntTyp;
    }

}

