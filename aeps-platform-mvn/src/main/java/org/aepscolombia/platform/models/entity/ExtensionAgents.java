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
 * ExtensionAgents generated by hbm2java
 */
@Entity
@Table(name="extension_agents"
    ,catalog="madr_bd13"
)
public class ExtensionAgents  implements java.io.Serializable {


     private Integer idExtAge;
     private Entities entities;
     private Boolean status;
     private Integer createdBy;
     private WorkTypeExtAgent workTypeExtAge;
     private String nameAssoExtAge;

    public ExtensionAgents() {
    }

	
    public ExtensionAgents(Entities entities) {
        this.entities = entities;
    }
    public ExtensionAgents(Entities entities, WorkTypeExtAgent workTypeExtAge, String nameAssoExtAge, Boolean status, Integer createdBy) {
       this.entities = entities;
       this.workTypeExtAge = workTypeExtAge;
       this.status = status;
       this.nameAssoExtAge = nameAssoExtAge;
       this.createdBy = createdBy;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_ext_age", unique=true, nullable=false)
    public Integer getIdExtAge() {
        return this.idExtAge;
    }
    
    public void setIdExtAge(Integer idExtAge) {
        this.idExtAge = idExtAge;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_entity_ext_age", nullable=false)
    public Entities getEntities() {
        return this.entities;
    }
    
    public void setEntities(Entities entities) {
        this.entities = entities;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="work_type_ext_age")
    public WorkTypeExtAgent getWorkTypeExtAge() {
        return this.workTypeExtAge;
    }
    
    public void setWorkTypeExtAge(WorkTypeExtAgent workTypeExtAge) {
        this.workTypeExtAge = workTypeExtAge;
    }
    
    @Column(name="name_asso_ext_age", length=200)
    public String getNameAssoExtAge() {
        return this.nameAssoExtAge;
    }
    
    public void setNameAssoExtAge(String nameAssoExtAge) {
        this.nameAssoExtAge = nameAssoExtAge;
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


