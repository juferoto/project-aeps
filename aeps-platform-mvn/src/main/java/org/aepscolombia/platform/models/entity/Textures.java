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
 * Textures generated by hbm2java
 */
@Entity
@Table(name="textures"
    ,catalog="madr_bd13"
)
public class Textures  implements java.io.Serializable {


     private Integer idTex;
     private String nameTex;

    public Textures() {
    }
    
    public Textures(Integer idTex) {
       this.idTex = idTex;
    }

    public Textures(String nameTex) {
       this.nameTex = nameTex;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_tex", unique=true, nullable=false)
    public Integer getIdTex() {
        return this.idTex;
    }
    
    public void setIdTex(Integer idTex) {
        this.idTex = idTex;
    }
    
    @Column(name="name_tex", length=45)
    public String getNameTex() {
        return this.nameTex;
    }
    
    public void setNameTex(String nameTex) {
        this.nameTex = nameTex;
    }

}


