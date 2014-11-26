package org.aepscolombia.platform.models.entity;
// Generated Apr 8, 2014 9:37:27 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FieldsProducersId generated by hbm2java
 */
@Embeddable
public class FieldsProducersId  implements java.io.Serializable {


     private int idFieldFiePro;
     private int idProducerFiePro;

    public FieldsProducersId() {
    }

    public FieldsProducersId(int idFieldFiePro, int idProducerFiePro) {
       this.idFieldFiePro = idFieldFiePro;
       this.idProducerFiePro = idProducerFiePro;
    }
   

    @Column(name="id_field_fie_pro", nullable=false)
    public int getIdFieldFiePro() {
        return this.idFieldFiePro;
    }
    
    public void setIdFieldFiePro(int idFieldFiePro) {
        this.idFieldFiePro = idFieldFiePro;
    }

    @Column(name="id_producer_fie_pro", nullable=false)
    public int getIdProducerFiePro() {
        return this.idProducerFiePro;
    }
    
    public void setIdProducerFiePro(int idProducerFiePro) {
        this.idProducerFiePro = idProducerFiePro;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FieldsProducersId) ) return false;
		 FieldsProducersId castOther = ( FieldsProducersId ) other; 
         
		 return (this.getIdFieldFiePro()==castOther.getIdFieldFiePro())
 && (this.getIdProducerFiePro()==castOther.getIdProducerFiePro());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdFieldFiePro();
         result = 37 * result + this.getIdProducerFiePro();
         return result;
   }   


}

