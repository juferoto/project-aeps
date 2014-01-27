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
 * Clusters generated by hbm2java
 */
@Entity
@Table(name="clusters"
    ,catalog="madr_bd10"
)
public class Clusters  implements java.io.Serializable {


     private Integer idClu;
     private Fields fields;
     private int cropTypeClu;
     private int numberClusterClu;

    public Clusters() {
    }

    public Clusters(Fields fields, int cropTypeClu, int numberClusterClu) {
       this.fields = fields;
       this.cropTypeClu = cropTypeClu;
       this.numberClusterClu = numberClusterClu;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_clu", unique=true, nullable=false)
    public Integer getIdClu() {
        return this.idClu;
    }
    
    public void setIdClu(Integer idClu) {
        this.idClu = idClu;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_field_clu", nullable=false)
    public Fields getFields() {
        return this.fields;
    }
    
    public void setFields(Fields fields) {
        this.fields = fields;
    }
    
    @Column(name="crop_type_clu", nullable=false)
    public int getCropTypeClu() {
        return this.cropTypeClu;
    }
    
    public void setCropTypeClu(int cropTypeClu) {
        this.cropTypeClu = cropTypeClu;
    }
    
    @Column(name="number_cluster_clu", nullable=false)
    public int getNumberClusterClu() {
        return this.numberClusterClu;
    }
    
    public void setNumberClusterClu(int numberClusterClu) {
        this.numberClusterClu = numberClusterClu;
    }




}

