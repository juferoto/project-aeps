package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Profiles generated by hbm2java
 */
@Entity
@Table(name="profiles")
public class Profiles  implements java.io.Serializable {


     private Integer idPro;
     private String namePro;
     private String descriptionPro;
     private Integer idProjectPro;
     private Boolean status;

    public Profiles() {
    }

    public Profiles(Integer idPro) {
        this.idPro = idPro;
    }
	
    public Profiles(String namePro, String descriptionPro) {
        this.namePro = namePro;
        this.descriptionPro = descriptionPro;
    }
    public Profiles(String namePro, String descriptionPro, Integer idProjectPro, Boolean status) {
       this.namePro = namePro;
       this.descriptionPro = descriptionPro;
       this.idProjectPro = idProjectPro;
       this.status = status;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_pro", unique=true, nullable=false)
    public Integer getIdPro() {
        return this.idPro;
    }
    
    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }
    
    @Column(name="name_pro", nullable=false, length=50)
    public String getNamePro() {
        return this.namePro;
    }
    
    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }
    
    @Column(name="description_pro", nullable=false)
    public String getDescriptionPro() {
        return this.descriptionPro;
    }
    
    public void setDescriptionPro(String descriptionPro) {
        this.descriptionPro = descriptionPro;
    }
    
    @Column(name="id_project_pro")
    public Integer getIdProjectPro() {
        return this.idProjectPro;
    }
    
    public void setIdProjectPro(Integer idProjectPro) {
        this.idProjectPro = idProjectPro;
    }
    
    @Column(name="status")
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }

}

