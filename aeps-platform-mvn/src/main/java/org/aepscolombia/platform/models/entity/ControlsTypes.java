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
 * ControlsTypes generated by hbm2java
 */
@Entity
@Table(name="controls_types")
public class ControlsTypes  implements java.io.Serializable {


     private Integer idConTyp;
     private String nameConType;
     private Boolean statusConTyp;

    public ControlsTypes() {
    }

	
    public ControlsTypes(String nameConType) {
        this.nameConType = nameConType;
    }
    public ControlsTypes(String nameConType, Boolean statusConTyp) {
       this.nameConType = nameConType;
       this.statusConTyp = statusConTyp;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_con_typ", unique=true, nullable=false)
    public Integer getIdConTyp() {
        return this.idConTyp;
    }
    
    public void setIdConTyp(Integer idConTyp) {
        this.idConTyp = idConTyp;
    }
    
    @Column(name="name_con_type", nullable=false, length=45)
    public String getNameConType() {
        return this.nameConType;
    }
    
    public void setNameConType(String nameConType) {
        this.nameConType = nameConType;
    }
    
    @Column(name="status_con_typ")
    public Boolean getStatusConTyp() {
        return this.statusConTyp;
    }
    
    public void setStatusConTyp(Boolean statusConTyp) {
        this.statusConTyp = statusConTyp;
    }

}


