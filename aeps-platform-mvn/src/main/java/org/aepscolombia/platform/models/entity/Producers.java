package org.aepscolombia.platform.models.entity;
// Generated Jan 21, 2014 11:35:29 AM by Hibernate Tools 3.2.1.GA


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
 * Producers generated by hbm2java
 */
@Entity
@Table(name="producers"
    ,catalog="madr_bd10"
)
public class Producers  implements java.io.Serializable {


     private Integer idPro;
     private Entities entities;
     private boolean statusPro;

    public Producers() {
    }

	
    public Producers(Entities entities, boolean statusPro) {
        this.entities = entities;
        this.statusPro = statusPro;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_pro", unique=true, nullable=false)
    public Integer getIdPro() {
        return this.idPro;
    }
    
    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_entity_pro", nullable=false)
    public Entities getEntities() {
        return this.entities;
    }
    
    public void setEntities(Entities entities) {
        this.entities = entities;
    }
    
    @Column(name="status_pro", nullable=false)
    public boolean isStatusPro() {
        return this.statusPro;
    }
    
    public void setStatusPro(boolean statusPro) {
        this.statusPro = statusPro;
    }

}


