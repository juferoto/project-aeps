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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ChemicalsControls generated by hbm2java
 */
@Entity
@Table(name="chemicals_controls")
public class ChemicalsControls  implements java.io.Serializable {


     private Integer idCheCon;
     private TargetsTypes targetsTypes;
     private String nameCheCon;
     private String comerNameCheCon;

    public ChemicalsControls() {
    }

    public ChemicalsControls(Integer idCheCon, String nameCheCon) {
        this.idCheCon   = idCheCon;
        this.nameCheCon = nameCheCon;
    }
	
    public ChemicalsControls(TargetsTypes targetsTypes, String nameCheCon) {
        this.targetsTypes = targetsTypes;
        this.nameCheCon = nameCheCon;
    }
    public ChemicalsControls(TargetsTypes targetsTypes, String nameCheCon, String comerNameCheCon) {
       this.targetsTypes = targetsTypes;
       this.nameCheCon = nameCheCon;
       this.comerNameCheCon = comerNameCheCon;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_che_con", unique=true, nullable=false)
    public Integer getIdCheCon() {
        return this.idCheCon;
    }
    
    public void setIdCheCon(Integer idCheCon) {
        this.idCheCon = idCheCon;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="target_name_che_con", nullable=false)
    public TargetsTypes getTargetsTypes() {
        return this.targetsTypes;
    }
    
    public void setTargetsTypes(TargetsTypes targetsTypes) {
        this.targetsTypes = targetsTypes;
    }
    
    @Column(name="name_che_con", nullable=false, length=50)
    public String getNameCheCon() {
        return this.nameCheCon;
    }
    
    public void setNameCheCon(String nameCheCon) {
        this.nameCheCon = nameCheCon;
    }
    
    @Column(name="comer_name_che_con", length=200)
    public String getComerNameCheCon() {
        return this.comerNameCheCon;
    }
    
    public void setComerNameCheCon(String comerNameCheCon) {
        this.comerNameCheCon = comerNameCheCon;
    }
}


