package org.aepscolombia.platform.models.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.aepscolombia.platform.models.entity.Entities;
import org.aepscolombia.platform.models.entity.Municipalities;
//import org.aepscolombia.plataforma.models.dao.IEventoDao;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.aepscolombia.platform.models.entity.Producers;
import org.aepscolombia.platform.util.HibernateUtil;
import org.hibernate.Criteria;

/**
 * Clase ProducersDao
 *
 * Contiene los metodos para interactuar con la tabla Producers de la base de datos (BD)
 *
 * @author Juan Felipe Rodriguez
 * @version 1.0
 */
public class ProducersDao 
{    
    
    public HashMap findById(Integer id) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        
        List<Object[]> events = null;
        Transaction tx = null;
        HashMap result = new HashMap();
        
        String sql = "";
        
        sql += "select p.id_pro, e.id_ent, e.document_number_ent, e.document_type_ent, e.name_ent, e.document_issue_place_ent,";
        sql += " e.cellphone_ent, e.cellphone2_ent, e.phone_ent, e.address_ent, m.nombre_mun, e.email_ent,";
        sql += " e.email_2_ent, e.in_association_ent, e.id_project_ent, e.status_ent, e.validation_number_ent, m.id_departamento_mun,";
        sql += " m.id_mun, e.first_name_1_ent, e.first_name_2_ent, e.last_name_1_ent, e.last_name_2_ent";
        sql += " from producers p";
        sql += " inner join entities e on (p.id_entity_pro=e.id_ent)";	
        sql += " inner join municipalities m on (m.id_mun=e.id_municipality_ent)";
        if (id!=null) {
            sql += " where p.id_pro="+id;
        }
//        args.get("countTotal");
//        events.toArray();
//        System.out.println("sql->"+sql);
        try {
            tx = session.beginTransaction();
            Query query  = session.createSQLQuery(sql);
//            System.out.println("sql->"+query.list().size());
//                         .addEntity("p", Productores.class)
//                         .addEntity("e", Entidades.class);
//                         .addJoin("e", "inner join entidades e on p.id_entidad_pro=e.id_ent")
//                         .addEntity("e", Entidades.class)
//                         .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//            System.out.println("events->"+query.list());            

            
            events = query.list();         
            
            for (Object[] datos : events) {
//                System.out.println(datos);
                HashMap temp = new HashMap();
                temp.put("id_producer", datos[0]);
                temp.put("id_entity", datos[1]);
                temp.put("document", datos[2]);
                temp.put("type_document", datos[3]);
                temp.put("name", datos[4]);
                temp.put("site_document", datos[5]);
                temp.put("cellphone", datos[6]);
                temp.put("cellphone_2", datos[7]);
                temp.put("phone", datos[8]);
                temp.put("direction", datos[9]);
                temp.put("city", datos[10]);
                temp.put("e_mail_1", datos[11]);
                temp.put("e_mail_2", datos[12]);
                temp.put("associate", datos[13]);
//                temp.put("fecha_in", datos[14]);
                temp.put("id_project", datos[14]);
                temp.put("status", datos[15]);
                temp.put("digit", datos[16]);
                temp.put("id_dep", datos[17]);                
                temp.put("id_mun", datos[18]);                
                temp.put("name_1", datos[19]);
                temp.put("name_2", datos[20]);
                temp.put("last_name_1", datos[21]);
                temp.put("last_name_2", datos[22]);                
                result = (temp);
            }
//            System.out.println(result);
//            for (HashMap datos : result) {
//                System.out.println(datos.get("id_productor")+" "+datos.get("id_entidad")+" "+datos.get("cedula"));
//            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

//        Productores event = null;
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            event = (Productores) session.load(Productores.class, id);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return event;
    }
    
    public List<Producers> findAll() {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<Producers> events = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Producers");
            events = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return events;
    }

    public List findByParams(HashMap args) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<Object[]> eventsTotal = null;
        List<Object[]> events = null;
        Transaction tx = null;
        List<HashMap> result = new ArrayList<HashMap>();
        
        String sql = "";
        
//        sql += "select p.*, e.* from productores p";
        sql += "select p.id_pro, e.id_ent, e.document_number_ent, e.document_type_ent, e.name_ent, e.document_issue_place_ent,";
        sql += " e.cellphone_ent, e.cellphone2_ent, e.phone_ent, e.address_ent, m.name_mun, e.email_ent,";
        sql += " e.email_2_ent, e.in_association_ent, e.id_project_ent, e.status_ent";
        sql += " from producers p";
        sql += " inner join entities e on (p.id_entity_pro=e.id_ent)";		
        sql += " inner join municipios m on (m.id_mun=e.id_municipality_ent)";		
        sql += " inner join log_entidades le on (le.id_object_log_ent=e.id_ent and le.table_log_ent='entities')";		
        sql += " where e.status_ent=1 and e.entity_type_ent=2";        
        if (args.containsKey("idEntUser")) {
            sql += " and le.id_entity_log_ent="+args.get("idEntUser");
        }
//        args.get("countTotal");
        
        int valIni = Integer.parseInt(String.valueOf(args.get("pageNow")));
//        int valIni = Integer.parseInt(args.get("pageNow"))*Integer.parseInt((String)args.get("maxResults"));
        int maxResults = Integer.parseInt(String.valueOf(args.get("maxResults")));
        if(valIni!=1){
            valIni = (valIni-1)*maxResults+1;
        }    
        if (args.containsKey("identProducer")) {
            String valIdent = String.valueOf(args.get("identProducer"));
            if(!valIdent.equals("null")) sql += " and (e.document_number_ent!='"+args.get("identProductor")+"' OR e.name_ent not like '%"+args.get("identProducer")+"%')";
        }
        sql += " order by e.name_ent ASC";
//        events.toArray();
//        System.out.println("sql->"+sql);
        try {
            tx = session.beginTransaction();
//            Query query = session.createSQLQuery(sql);
            Query query  = session.createSQLQuery(sql);
//            System.out.println("sql->"+query.list().size());
            HashMap tempTotal = new HashMap();
            tempTotal.put("countTotal", query.list().size());
            result.add(tempTotal);
            query.setFirstResult(valIni);
            query.setMaxResults(maxResults);
//                         .addEntity("p", Productores.class)
//                         .addEntity("e", Entidades.class);
//                         .addJoin("e", "inner join entidades e on p.id_entidad_pro=e.id_ent")
//                         .addEntity("e", Entidades.class)
//                         .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//            System.out.println("events->"+query.list());            

            
            events = query.list();         
            
            for (Object[] datos : events) {
//                System.out.println(datos);
                HashMap temp = new HashMap();
                temp.put("id_producer", datos[0]);
                temp.put("id_entity", datos[1]);
                temp.put("document", datos[2]);
                temp.put("type_document", datos[3]);
                temp.put("name", datos[4]);
                temp.put("site_document", datos[5]);
                temp.put("cellphone", datos[6]);
                temp.put("cellphone_2", datos[7]);
                temp.put("phone", datos[8]);
                temp.put("direction", datos[9]);
                temp.put("city", datos[10]);
                temp.put("e_mail_1", datos[11]);
                temp.put("e_mail_2", datos[12]);
                temp.put("associate", datos[13]);
//                temp.put("fecha_in", datos[14]);
                temp.put("id_project", datos[14]);
                temp.put("status", datos[15]);
                result.add(temp);
            }
//            System.out.println(result);
//            for (HashMap datos : result) {
//                System.out.println(datos.get("id_productor")+" "+datos.get("id_entidad")+" "+datos.get("cedula"));
//            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }   
    
    public Producers objectById(Integer id) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        Producers event = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            event = (Producers) session.load(Producers.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return event;
    }    

    public void save(Producers event) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(event);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(Producers event) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(event);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
