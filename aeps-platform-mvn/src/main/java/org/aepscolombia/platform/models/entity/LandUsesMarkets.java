package org.aepscolombia.platform.models.entity;
// Generated Jan 21, 2014 11:35:29 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LandUsesMarkets generated by hbm2java
 */
@Entity
@Table(name="land_uses_markets"
    ,catalog="madr_bd10"
)
public class LandUsesMarkets  implements java.io.Serializable {


     private Integer idLanUseMar;
     private CropsTypes cropsTypes;
     private Markets markets;
     private Boolean cropProportionLanUseMar;
     private String harvestMonthsLanUseMar;

    public LandUsesMarkets() {
    }

    public LandUsesMarkets(CropsTypes cropsTypes, Markets markets, Boolean cropProportionLanUseMar, String harvestMonthsLanUseMar) {
       this.cropsTypes = cropsTypes;
       this.markets = markets;
       this.cropProportionLanUseMar = cropProportionLanUseMar;
       this.harvestMonthsLanUseMar = harvestMonthsLanUseMar;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_lan_use_mar", unique=true, nullable=false)
    public Integer getIdLanUseMar() {
        return this.idLanUseMar;
    }
    
    public void setIdLanUseMar(Integer idLanUseMar) {
        this.idLanUseMar = idLanUseMar;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_crop_type_lan_use_mar")
    public CropsTypes getCropsTypes() {
        return this.cropsTypes;
    }
    
    public void setCropsTypes(CropsTypes cropsTypes) {
        this.cropsTypes = cropsTypes;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_markets_lan_use_mar")
    public Markets getMarkets() {
        return this.markets;
    }
    
    public void setMarkets(Markets markets) {
        this.markets = markets;
    }
    
    @Column(name="crop_proportion_lan_use_mar")
    public Boolean getCropProportionLanUseMar() {
        return this.cropProportionLanUseMar;
    }
    
    public void setCropProportionLanUseMar(Boolean cropProportionLanUseMar) {
        this.cropProportionLanUseMar = cropProportionLanUseMar;
    }
    
    @Column(name="harvest_months_lan_use_mar", length=50)
    public String getHarvestMonthsLanUseMar() {
        return this.harvestMonthsLanUseMar;
    }
    
    public void setHarvestMonthsLanUseMar(String harvestMonthsLanUseMar) {
        this.harvestMonthsLanUseMar = harvestMonthsLanUseMar;
    }




}


