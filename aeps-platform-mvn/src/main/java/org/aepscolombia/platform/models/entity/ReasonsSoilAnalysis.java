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
 * ReasonsSoilAnalysis generated by hbm2java
 */
@Entity
@Table(name="reasons_soil_analysis"
    ,catalog="madr_bd10"
)
public class ReasonsSoilAnalysis  implements java.io.Serializable {


     private Integer idReaSoiAna;
     private boolean keyReaSoiAna;
     private String reasonReaSoiAna;

    public ReasonsSoilAnalysis() {
    }

	
    public ReasonsSoilAnalysis(boolean keyReaSoiAna, String reasonReaSoiAna) {
        this.keyReaSoiAna = keyReaSoiAna;
        this.reasonReaSoiAna = reasonReaSoiAna;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_rea_soi_ana", unique=true, nullable=false)
    public Integer getIdReaSoiAna() {
        return this.idReaSoiAna;
    }
    
    public void setIdReaSoiAna(Integer idReaSoiAna) {
        this.idReaSoiAna = idReaSoiAna;
    }
    
    @Column(name="key_rea_soi_ana", nullable=false)
    public boolean isKeyReaSoiAna() {
        return this.keyReaSoiAna;
    }
    
    public void setKeyReaSoiAna(boolean keyReaSoiAna) {
        this.keyReaSoiAna = keyReaSoiAna;
    }
    
    @Column(name="reason_rea_soi_ana", nullable=false, length=45)
    public String getReasonReaSoiAna() {
        return this.reasonReaSoiAna;
    }
    
    public void setReasonReaSoiAna(String reasonReaSoiAna) {
        this.reasonReaSoiAna = reasonReaSoiAna;
    }

}


