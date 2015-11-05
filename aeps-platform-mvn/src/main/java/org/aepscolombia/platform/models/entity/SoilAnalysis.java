package org.aepscolombia.platform.models.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SoilAnalysis generated by hbm2java
 */
@Entity
@Table(name="soil_analysis")
public class SoilAnalysis  implements java.io.Serializable {


     private Integer idSoAna;
     private ProductionEvents productionEvents;
     private Textures textures;
     private Date dateSamplingSoAna;
     private Integer sampleNumberSoAna;
     private Double sandSoAna;
     private Double lemonSoAna;
     private Double claySoAna;
     private Double organicMaterialSoAna;
     private Double dapaSoAna;
     private Double phSoAna;
     private Double elecConductivitySoAna;
     private Double cationInterchangeabilitySoAna;
     private Double coSoAna;
     private Double nitrogenSoAna;
     private Double phosphorusSoAna;
     private Double potassiumSoAna;
     private Double calciumSoAna;
     private Double magnesiumSoAna;
     private Double sulfurSoAna;
     private Double boronSoAna;
     private Double zincSoAna;
     private Double ironSoAna;
     private Double sodiumSoAna;
     private Double manganeseSoAna;
     private Double copperSoAna;
     private Double siliconSoAna;
     private Double exchangeableAcidityHSoAna;
     private Double exchangeableAcidityThreeSoAna;
     private String idProjectSoAna;
     private boolean status;
     private Integer createdBy;

    public SoilAnalysis() {
    }
    
    public SoilAnalysis(Integer idSoAna) {
        this.idSoAna = idSoAna;
    }
	
    public SoilAnalysis(ProductionEvents productionEvents, Date dateSamplingSoAna, Integer sampleNumberSoAna, boolean status) {
        this.productionEvents = productionEvents;
        this.dateSamplingSoAna = dateSamplingSoAna;
        this.sampleNumberSoAna = sampleNumberSoAna;
        this.status = status;
    }
    public SoilAnalysis(ProductionEvents productionEvents, Textures textures, Date dateSamplingSoAna, Integer sampleNumberSoAna, Double sandSoAna, Double lemonSoAna, Double claySoAna, Double organicMaterialSoAna, Double dapaSoAna, Double phSoAna, Double elecConductivitySoAna, Double cationInterchangeabilitySoAna, Double coSoAna, Double nitrogenSoAna, Double phosphorusSoAna, Double potassiumSoAna, Double calciumSoAna, Double magnesiumSoAna, Double sulfurSoAna, Double boronSoAna, Double zincSoAna, Double ironSoAna, Double sodiumSoAna, Double manganeseSoAna, Double copperSoAna, Double siliconSoAna, Double exchangeableAcidityHSoAna, Double exchangeableAcidityThreeSoAna, String idProjectSoAna, boolean status, Integer createdBy) {
       this.productionEvents = productionEvents;
       this.textures = textures;
       this.dateSamplingSoAna = dateSamplingSoAna;
       this.sampleNumberSoAna = sampleNumberSoAna;
       this.sandSoAna = sandSoAna;
       this.lemonSoAna = lemonSoAna;
       this.claySoAna = claySoAna;
       this.organicMaterialSoAna = organicMaterialSoAna;
       this.dapaSoAna = dapaSoAna;
       this.phSoAna = phSoAna;
       this.elecConductivitySoAna = elecConductivitySoAna;
       this.cationInterchangeabilitySoAna = cationInterchangeabilitySoAna;
       this.coSoAna = coSoAna;
       this.nitrogenSoAna = nitrogenSoAna;
       this.phosphorusSoAna = phosphorusSoAna;
       this.potassiumSoAna = potassiumSoAna;
       this.calciumSoAna = calciumSoAna;
       this.magnesiumSoAna = magnesiumSoAna;
       this.sulfurSoAna = sulfurSoAna;
       this.boronSoAna = boronSoAna;
       this.zincSoAna = zincSoAna;
       this.ironSoAna = ironSoAna;
       this.sodiumSoAna = sodiumSoAna;
       this.manganeseSoAna = manganeseSoAna;
       this.copperSoAna = copperSoAna;
       this.siliconSoAna = siliconSoAna;
       this.exchangeableAcidityHSoAna = exchangeableAcidityHSoAna;
       this.exchangeableAcidityThreeSoAna = exchangeableAcidityThreeSoAna;
       this.idProjectSoAna = idProjectSoAna;
       this.status = status;
       this.createdBy = createdBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_so_ana", unique=true, nullable=false)
    public Integer getIdSoAna() {
        return this.idSoAna;
    }
    
    public void setIdSoAna(Integer idSoAna) {
        this.idSoAna = idSoAna;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_production_event_so_ana", nullable=false)
    public ProductionEvents getProductionEvents() {
        return this.productionEvents;
    }
    
    public void setProductionEvents(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="texture_so_ana")
    public Textures getTextures() {
        return this.textures;
    }
    
    public void setTextures(Textures textures) {
        this.textures = textures;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_sampling_so_ana", nullable=false, length=19)
    public Date getDateSamplingSoAna() {
        return this.dateSamplingSoAna;
    }
    
    public void setDateSamplingSoAna(Date dateSamplingSoAna) {
        this.dateSamplingSoAna = dateSamplingSoAna;
    }

    
    @Column(name="sample_number_so_ana", nullable=false)
    public Integer getSampleNumberSoAna() {
        return this.sampleNumberSoAna;
    }
    
    public void setSampleNumberSoAna(Integer sampleNumberSoAna) {
        this.sampleNumberSoAna = sampleNumberSoAna;
    }

    
    @Column(name="sand_so_ana", precision=22, scale=0)
    public Double getSandSoAna() {
        return this.sandSoAna;
    }
    
    public void setSandSoAna(Double sandSoAna) {
        this.sandSoAna = sandSoAna;
    }

    
    @Column(name="lemon_so_ana", precision=22, scale=0)
    public Double getLemonSoAna() {
        return this.lemonSoAna;
    }
    
    public void setLemonSoAna(Double lemonSoAna) {
        this.lemonSoAna = lemonSoAna;
    }

    
    @Column(name="clay_so_ana", precision=22, scale=0)
    public Double getClaySoAna() {
        return this.claySoAna;
    }
    
    public void setClaySoAna(Double claySoAna) {
        this.claySoAna = claySoAna;
    }

    
    @Column(name="organic_material_so_ana", precision=22, scale=0)
    public Double getOrganicMaterialSoAna() {
        return this.organicMaterialSoAna;
    }
    
    public void setOrganicMaterialSoAna(Double organicMaterialSoAna) {
        this.organicMaterialSoAna = organicMaterialSoAna;
    }

    
    @Column(name="dapa_so_ana", precision=22, scale=0)
    public Double getDapaSoAna() {
        return this.dapaSoAna;
    }
    
    public void setDapaSoAna(Double dapaSoAna) {
        this.dapaSoAna = dapaSoAna;
    }

    
    @Column(name="ph_so_ana", precision=22, scale=0)
    public Double getPhSoAna() {
        return this.phSoAna;
    }
    
    public void setPhSoAna(Double phSoAna) {
        this.phSoAna = phSoAna;
    }

    
    @Column(name="elec_conductivity_so_ana", precision=22, scale=0)
    public Double getElecConductivitySoAna() {
        return this.elecConductivitySoAna;
    }
    
    public void setElecConductivitySoAna(Double elecConductivitySoAna) {
        this.elecConductivitySoAna = elecConductivitySoAna;
    }

    
    @Column(name="cation_interchangeability_so_ana", precision=22, scale=0)
    public Double getCationInterchangeabilitySoAna() {
        return this.cationInterchangeabilitySoAna;
    }
    
    public void setCationInterchangeabilitySoAna(Double cationInterchangeabilitySoAna) {
        this.cationInterchangeabilitySoAna = cationInterchangeabilitySoAna;
    }

    
    @Column(name="co_so_ana", precision=22, scale=0)
    public Double getCoSoAna() {
        return this.coSoAna;
    }
    
    public void setCoSoAna(Double coSoAna) {
        this.coSoAna = coSoAna;
    }

    
    @Column(name="nitrogen_so_ana", precision=22, scale=0)
    public Double getNitrogenSoAna() {
        return this.nitrogenSoAna;
    }
    
    public void setNitrogenSoAna(Double nitrogenSoAna) {
        this.nitrogenSoAna = nitrogenSoAna;
    }

    
    @Column(name="phosphorus_so_ana", precision=22, scale=0)
    public Double getPhosphorusSoAna() {
        return this.phosphorusSoAna;
    }
    
    public void setPhosphorusSoAna(Double phosphorusSoAna) {
        this.phosphorusSoAna = phosphorusSoAna;
    }

    
    @Column(name="potassium_so_ana", precision=22, scale=0)
    public Double getPotassiumSoAna() {
        return this.potassiumSoAna;
    }
    
    public void setPotassiumSoAna(Double potassiumSoAna) {
        this.potassiumSoAna = potassiumSoAna;
    }

    
    @Column(name="calcium_so_ana", precision=22, scale=0)
    public Double getCalciumSoAna() {
        return this.calciumSoAna;
    }
    
    public void setCalciumSoAna(Double calciumSoAna) {
        this.calciumSoAna = calciumSoAna;
    }

    
    @Column(name="magnesium_so_ana", precision=22, scale=0)
    public Double getMagnesiumSoAna() {
        return this.magnesiumSoAna;
    }
    
    public void setMagnesiumSoAna(Double magnesiumSoAna) {
        this.magnesiumSoAna = magnesiumSoAna;
    }

    
    @Column(name="sulfur_so_ana", precision=22, scale=0)
    public Double getSulfurSoAna() {
        return this.sulfurSoAna;
    }
    
    public void setSulfurSoAna(Double sulfurSoAna) {
        this.sulfurSoAna = sulfurSoAna;
    }

    
    @Column(name="boron_so_ana", precision=22, scale=0)
    public Double getBoronSoAna() {
        return this.boronSoAna;
    }
    
    public void setBoronSoAna(Double boronSoAna) {
        this.boronSoAna = boronSoAna;
    }

    
    @Column(name="zinc_so_ana", precision=22, scale=0)
    public Double getZincSoAna() {
        return this.zincSoAna;
    }
    
    public void setZincSoAna(Double zincSoAna) {
        this.zincSoAna = zincSoAna;
    }

    
    @Column(name="iron_so_ana", precision=22, scale=0)
    public Double getIronSoAna() {
        return this.ironSoAna;
    }
    
    public void setIronSoAna(Double ironSoAna) {
        this.ironSoAna = ironSoAna;
    }

    
    @Column(name="sodium_so_ana", precision=22, scale=0)
    public Double getSodiumSoAna() {
        return this.sodiumSoAna;
    }
    
    public void setSodiumSoAna(Double sodiumSoAna) {
        this.sodiumSoAna = sodiumSoAna;
    }

    
    @Column(name="manganese_so_ana", precision=22, scale=0)
    public Double getManganeseSoAna() {
        return this.manganeseSoAna;
    }
    
    public void setManganeseSoAna(Double manganeseSoAna) {
        this.manganeseSoAna = manganeseSoAna;
    }

    
    @Column(name="copper_so_ana", precision=22, scale=0)
    public Double getCopperSoAna() {
        return this.copperSoAna;
    }
    
    public void setCopperSoAna(Double copperSoAna) {
        this.copperSoAna = copperSoAna;
    }

    
    @Column(name="silicon_so_ana", precision=22, scale=0)
    public Double getSiliconSoAna() {
        return this.siliconSoAna;
    }
    
    public void setSiliconSoAna(Double siliconSoAna) {
        this.siliconSoAna = siliconSoAna;
    }

    
    @Column(name="exchangeable_acidity_h_so_ana", precision=22, scale=0)
    public Double getExchangeableAcidityHSoAna() {
        return this.exchangeableAcidityHSoAna;
    }
    
    public void setExchangeableAcidityHSoAna(Double exchangeableAcidityHSoAna) {
        this.exchangeableAcidityHSoAna = exchangeableAcidityHSoAna;
    }

    
    @Column(name="exchangeable_acidity_three_so_ana", precision=22, scale=0)
    public Double getExchangeableAcidityThreeSoAna() {
        return this.exchangeableAcidityThreeSoAna;
    }
    
    public void setExchangeableAcidityThreeSoAna(Double exchangeableAcidityThreeSoAna) {
        this.exchangeableAcidityThreeSoAna = exchangeableAcidityThreeSoAna;
    }

    
    @Column(name="id_project_so_ana", length=4)
    public String getIdProjectSoAna() {
        return this.idProjectSoAna;
    }
    
    public void setIdProjectSoAna(String idProjectSoAna) {
        this.idProjectSoAna = idProjectSoAna;
    }

    
    @Column(name="status", nullable=false)
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    
    @Column(name="created_by")
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

}