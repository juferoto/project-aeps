package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TmpIssueReports generated by hbm2java
 */
@Entity
@Table(name="tmp_issue_reports")
public class TmpIssueReports  implements java.io.Serializable {

    private Integer idIss;
    private String nameIss;
    private String descriptionIss;
    private Integer createdBy;

    public TmpIssueReports() {
    }
	
    public TmpIssueReports(String descriptionIss) {
        this.descriptionIss = descriptionIss;
    }
    
    public TmpIssueReports(String nameIss, String descriptionIss, Integer createdBy) {
       this.nameIss = nameIss;
       this.descriptionIss = descriptionIss;
       this.createdBy = createdBy;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_iss", unique=true, nullable=false)
    public Integer getIdIss() {
        return this.idIss;
    }
    
    public void setIdIss(Integer idIss) {
        this.idIss = idIss;
    }
    
    @Column(name="name_iss", length=65535)
    public String getNameIss() {
        return this.nameIss;
    }
    
    public void setNameIss(String nameIss) {
        this.nameIss = nameIss;
    }
    
    @Column(name="description_iss", nullable=false, length=65535)
    public String getDescriptionIss() {
        return this.descriptionIss;
    }
    
    public void setDescriptionIss(String descriptionIss) {
        this.descriptionIss = descriptionIss;
    }
    
    @Column(name="created_by")
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
}


