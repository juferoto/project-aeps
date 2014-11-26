package org.aepscolombia.platform.models.entity;
// Generated Jan 21, 2014 11:35:29 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UsersProfiles generated by hbm2java
 */
@Entity
@Table(name="users_profiles")
public class UsersProfiles  implements java.io.Serializable {


     private UsersProfilesId id;
     private Users users;
     private Profiles profiles;
     private Integer idProjectUsrPro;

    public UsersProfiles() {
    }

	
    public UsersProfiles(UsersProfilesId id, Users users, Profiles profiles) {
        this.id = id;
        this.users = users;
        this.profiles = profiles;
    }
    public UsersProfiles(UsersProfilesId id, Users users, Profiles profiles, Integer idProjectUsrPro) {
       this.id = id;
       this.users = users;
       this.profiles = profiles;
       this.idProjectUsrPro = idProjectUsrPro;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="idUsersUsrPro", column=@Column(name="id_users_usr_pro", nullable=false) ), 
        @AttributeOverride(name="idProfileUsrPro", column=@Column(name="id_profile_usr_pro", nullable=false) ) } )
    public UsersProfilesId getId() {
        return this.id;
    }
    
    public void setId(UsersProfilesId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_users_usr_pro", nullable=false, insertable=false, updatable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_profile_usr_pro", nullable=false, insertable=false, updatable=false)
    public Profiles getProfiles() {
        return this.profiles;
    }
    
    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
    }
    
    @Column(name="id_project_usr_pro")
    public Integer getIdProjectUsrPro() {
        return this.idProjectUsrPro;
    }
    
    public void setIdProjectUsrPro(Integer idProjectUsrPro) {
        this.idProjectUsrPro = idProjectUsrPro;
    }




}

