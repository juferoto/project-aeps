package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA


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
 * Cassavas generated by hbm2java
 */
@Entity
@Table(name="cassavas")
public class Cassavas  implements java.io.Serializable {


     private Integer idCas;
     private ProductionEvents productionEvents;
     private String cuttingAngleCas;
     private Boolean seedStorageCas;
     private Integer seedStorageTimeCas;
     private Boolean status;
     private Integer createdBy;

    public Cassavas() {
    }

	
    public Cassavas(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
    public Cassavas(ProductionEvents productionEvents, String cuttingAngleCas, Boolean seedStorageCas, Integer seedStorageTimeCas, Boolean status, Integer createdBy) {
       this.productionEvents = productionEvents;
       this.cuttingAngleCas = cuttingAngleCas;
       this.seedStorageCas = seedStorageCas;
       this.seedStorageTimeCas = seedStorageTimeCas;
       this.status = status;
       this.createdBy = createdBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_cas", unique=true, nullable=false)
    public Integer getIdCas() {
        return this.idCas;
    }
    
    public void setIdCas(Integer idCas) {
        this.idCas = idCas;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_production_event_cas", nullable=false)
    public ProductionEvents getProductionEvents() {
        return this.productionEvents;
    }
    
    public void setProductionEvents(ProductionEvents productionEvents) {
        this.productionEvents = productionEvents;
    }
    
    @Column(name="cutting_angle_cas", length=9)
    public String getCuttingAngleCas() {
        return this.cuttingAngleCas;
    }
    
    public void setCuttingAngleCas(String cuttingAngleCas) {
        this.cuttingAngleCas = cuttingAngleCas;
    }
    
    @Column(name="seed_storage_cas")
    public Boolean getSeedStorageCas() {
        return this.seedStorageCas;
    }
    
    public void setSeedStorageCas(Boolean seedStorageCas) {
        this.seedStorageCas = seedStorageCas;
    }
    
    @Column(name="seed_storage_time_cas")
    public Integer getSeedStorageTimeCas() {
        return this.seedStorageTimeCas;
    }
    
    public void setSeedStorageTimeCas(Integer seedStorageTimeCas) {
        this.seedStorageTimeCas = seedStorageTimeCas;
    }
    
    @Column(name="status")
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
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

