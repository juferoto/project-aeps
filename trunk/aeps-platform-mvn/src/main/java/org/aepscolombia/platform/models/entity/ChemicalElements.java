package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA

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
 * ChemicalElements generated by hbm2java
 */
@Entity
@Table(name="chemical_elements")
public class ChemicalElements  implements java.io.Serializable {


     private Integer idCheEle;
     private String nameCheEle;
     private Double valueCheEle;
     private boolean statusCheEle;

    public ChemicalElements() {
    }

	
    public ChemicalElements(String nameCheEle, boolean statusCheEle) {
        this.nameCheEle = nameCheEle;
        this.statusCheEle = statusCheEle;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_che_ele", unique=true, nullable=false)
    public Integer getIdCheEle() {
        return this.idCheEle;
    }
    
    public void setIdCheEle(Integer idCheEle) {
        this.idCheEle = idCheEle;
    }
    
    @Column(name="name_che_ele", nullable=false, length=45)
    public String getNameCheEle() {
        return this.nameCheEle;
    }
    
    public void setNameCheEle(String nameCheEle) {
        this.nameCheEle = nameCheEle;
    }

    public Double getValueCheEle() {
        return valueCheEle;
    }

    public void setValueCheEle(Double valueCheEle) {
        this.valueCheEle = valueCheEle;
    }  
    
    
    @Column(name="status_che_ele", nullable=false)
    public boolean isStatusCheEle() {
        return this.statusCheEle;
    }
    
    public void setStatusCheEle(boolean statusCheEle) {
        this.statusCheEle = statusCheEle;
    }

}


