package org.aepscolombia.platform.models.entity;
// Generated Jan 21, 2014 11:35:29 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsersProfilesId generated by hbm2java
 */
@Embeddable
public class UsersProfilesId  implements java.io.Serializable {


     private int idUsersUsrPro;
     private int idProfileUsrPro;

    public UsersProfilesId() {
    }

    public UsersProfilesId(int idUsersUsrPro, int idProfileUsrPro) {
       this.idUsersUsrPro = idUsersUsrPro;
       this.idProfileUsrPro = idProfileUsrPro;
    }
   

    @Column(name="id_users_usr_pro", nullable=false)
    public int getIdUsersUsrPro() {
        return this.idUsersUsrPro;
    }
    
    public void setIdUsersUsrPro(int idUsersUsrPro) {
        this.idUsersUsrPro = idUsersUsrPro;
    }

    @Column(name="id_profile_usr_pro", nullable=false)
    public int getIdProfileUsrPro() {
        return this.idProfileUsrPro;
    }
    
    public void setIdProfileUsrPro(int idProfileUsrPro) {
        this.idProfileUsrPro = idProfileUsrPro;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsersProfilesId) ) return false;
		 UsersProfilesId castOther = ( UsersProfilesId ) other; 
         
		 return (this.getIdUsersUsrPro()==castOther.getIdUsersUsrPro())
 && (this.getIdProfileUsrPro()==castOther.getIdProfileUsrPro());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUsersUsrPro();
         result = 37 * result + this.getIdProfileUsrPro();
         return result;
   }   


}

