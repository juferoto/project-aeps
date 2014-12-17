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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Farms generated by hbm2java
 */
@Entity
@Table(name="farms")
public class Farms  implements java.io.Serializable {


     private Integer idFar;
     private MeasureUnits measureUnits;
     private Municipalities municipalities;
     private Districts districts;
     private String nameFar;
     private String addressFar;
     private Integer phoneFar;
     private boolean georefFar;
     private Double latitudeFar;
     private Double longitudeFar;
     private Double altitudeFar;
     private Double areaFar;
     private String idProjectFar;
     private String nameCommuneFar;
     private boolean status;
     private Integer createdBy;

    public Farms() {
    }

    public Farms(Integer idFar) {
        this.idFar = idFar;
    }
	
    public Farms(String nameFar, String addressFar, boolean georefFar, boolean status) {
        this.nameFar = nameFar;
        this.addressFar = addressFar;
        this.georefFar = georefFar;
        this.status = status;
    }
    public Farms(MeasureUnits measureUnits, Municipalities municipalities, Districts districts, String nameFar, String addressFar, Integer phoneFar, boolean georefFar, Double latitudeFar, Double longitudeFar, Double altitudeFar, Double areaFar, String idProjectFar, String nameCommuneFar, boolean status, Integer createdBy) {
       this.measureUnits = measureUnits;
       this.municipalities = municipalities;
       this.districts = districts;
       this.nameFar = nameFar;
       this.addressFar = addressFar;
       this.phoneFar = phoneFar;
       this.georefFar = georefFar;
       this.latitudeFar = latitudeFar;
       this.longitudeFar = longitudeFar;
       this.altitudeFar = altitudeFar;
       this.areaFar = areaFar;
       this.idProjectFar = idProjectFar;
       this.nameCommuneFar = nameCommuneFar;
       this.status = status;
       this.createdBy = createdBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_far", unique=true, nullable=false)
    public Integer getIdFar() {
        return this.idFar;
    }
    
    public void setIdFar(Integer idFar) {
        this.idFar = idFar;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="unit_area_far")
    public MeasureUnits getMeasureUnits() {
        return this.measureUnits;
    }
    
    public void setMeasureUnits(MeasureUnits measureUnits) {
        this.measureUnits = measureUnits;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_municipipality_far")
    public Municipalities getMunicipalities() {
        return this.municipalities;
    }
    
    public void setMunicipalities(Municipalities municipalities) {
        this.municipalities = municipalities;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_district_far")
    public Districts getDistricts() {
        return this.districts;
    }
    
    public void setDistricts(Districts districts) {
        this.districts = districts;
    }
    
    @Column(name="name_far", nullable=false, length=45)
    public String getNameFar() {
        return this.nameFar;
    }
    
    public void setNameFar(String nameFar) {
        this.nameFar = nameFar;
    }
    
    @Column(name="address_far", nullable=false, length=45)
    public String getAddressFar() {
        return this.addressFar;
    }
    
    public void setAddressFar(String addressFar) {
        this.addressFar = addressFar;
    }
    
    @Column(name="phone_far")
    public Integer getPhoneFar() {
        return this.phoneFar;
    }
    
    public void setPhoneFar(Integer phoneFar) {
        this.phoneFar = phoneFar;
    }
    
    @Column(name="georef_far", nullable=false)
    public boolean isGeorefFar() {
        return this.georefFar;
    }
    
    public void setGeorefFar(boolean georefFar) {
        this.georefFar = georefFar;
    }
    
    @Column(name="latitude_far", precision=22, scale=0)
    public Double getLatitudeFar() {
        return this.latitudeFar;
    }
    
    public void setLatitudeFar(Double latitudeFar) {
        this.latitudeFar = latitudeFar;
    }
    
    @Column(name="longitude_far", precision=22, scale=0)
    public Double getLongitudeFar() {
        return this.longitudeFar;
    }
    
    public void setLongitudeFar(Double longitudeFar) {
        this.longitudeFar = longitudeFar;
    }
    
    @Column(name="altitude_far", precision=22, scale=0)
    public Double getAltitudeFar() {
        return this.altitudeFar;
    }
    
    public void setAltitudeFar(Double altitudeFar) {
        this.altitudeFar = altitudeFar;
    }
    
    @Column(name="area_far", precision=22, scale=0)
    public Double getAreaFar() {
        return this.areaFar;
    }
    
    public void setAreaFar(Double areaFar) {
        this.areaFar = areaFar;
    }
    
    @Column(name="id_project_far", length=4)
    public String getIdProjectFar() {
        return this.idProjectFar;
    }
    
    public void setIdProjectFar(String idProjectFar) {
        this.idProjectFar = idProjectFar;
    }
    
    @Column(name="name_commune_far", length=100)
    public String getNameCommuneFar() {
        return this.nameCommuneFar;
    }
    
    public void setNameCommuneFar(String nameCommuneFar) {
        this.nameCommuneFar = nameCommuneFar;
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

