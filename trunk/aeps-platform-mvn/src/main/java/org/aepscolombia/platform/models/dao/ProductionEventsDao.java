package org.aepscolombia.platform.models.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.aepscolombia.platform.models.entity.Entities;
//import org.aepscolombia.plataforma.models.dao.IEventoDao;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.aepscolombia.platform.models.entity.ProductionEvents;
import org.aepscolombia.platform.util.HibernateUtil;

/**
 * Clase ProductionEventsDao
 *
 * Contiene los metodos para interactuar con la tabla ProductionEvents de la base de datos (BD)
 *
 * @author Juan Felipe Rodriguez
 * @version 1.0
 */
public class ProductionEventsDao 
{    
    
    public HashMap findById(Integer id) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        
        List<Object[]> events = null;
        Transaction tx = null;
        HashMap result = new HashMap();
        
        String sql = "";
        String sqlAdd = "";    
        
        sql += "select pe.id_pro_eve, l.id_fie, l.name_fie, pe.id_crop_type_pro_eve, pe.expected_production_pro_eve,";
        sql += " pe.former_crop_pro_eve, pe.draining_pro_eve, pe.status, pe.other_former_crop_pro_eve";
        sql += " from production_events pe";
        sql += " inner join log_entities le on le.id_object_log_ent=pe.id_pro_eve and le.table_log_ent='production_events' and le.action_type_log_ent='C'";   
        sql += " inner join fields l on l.id_fie=pe.id_field_pro_eve";
        sql += " where l.status=1 and pe.status=1";
        if (id!=null) {
            sql += " and pe.id_pro_eve="+id;
        }
//        args.get("countTotal");
//        events.toArray();
//        System.out.println("sql->"+sql);        
        try {
            tx = session.beginTransaction();
            Query query  = session.createSQLQuery(sql);            
            events = query.list();         
            
            for (Object[] data : events) {
//                System.out.println(data);
                HashMap temp = new HashMap();
                temp.put("idCrop", data[0]);
                temp.put("idField", data[1]);
                temp.put("nameField", data[2]);             
                temp.put("typeCrop", data[3]);                
                temp.put("performObj", data[4]);                
                temp.put("drainPlot", data[6]);                
                temp.put("status", data[7]);
                if (data[8]!=null) {                    
                    temp.put("lastCrop", 1000000);
                    temp.put("otherCrop", data[8]);
                } else {
                    if (data[5]==null) {
                        temp.put("lastCrop", 1000000);
                    } else {
                        temp.put("lastCrop", data[5]);
                    }
                    temp.put("otherCrop", "");
                }
                result = (temp);
            }
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
    
    public List<ProductionEvents> findAll() {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<ProductionEvents> events = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from ProductionEvents");
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
        String sqlAdd = "";     
                      
        sql += "select pe.id_pro_eve, e.document_type_ent, e.document_number_ent, e.name_ent, f.id_far, f.name_far,";
        sql += " l.id_fie, l.name_fie, s.date_sow, mg.name_gen, pe.status, e.entity_type_ent, le.date_log_ent, ct.name_cro_typ, har.date_har";
        sql += " from production_events pe";
        sql += " inner join crops_types ct on ct.id_cro_typ=pe.id_crop_type_pro_eve";
//        sql += " left join sowing s on pe.id_pro_eve=s.id_production_event_sow and s.status=1";
        sql += " left join sowing s on pe.id_pro_eve=s.id_production_event_sow and s.status=1";
        sql += " left join harvests har on pe.id_pro_eve=har.id_production_event_har and har.status=1";
//        sql += " left join genotypes mg on mg.id_gen=s.genotype_sow and mg.status_gen=1";    
        sql += " left join genotypes mg on mg.id_gen=s.genotype_sow";    
    
        sql += " inner join log_entities le on le.id_object_log_ent=pe.id_pro_eve and le.table_log_ent='production_events' and le.action_type_log_ent='C'";   
        sql += " inner join fields l on l.id_fie=pe.id_field_pro_eve";
        sql += " inner join farms f on f.id_far=l.id_farm_fie";
        sql += " inner join farms_producers fp on f.id_far=fp.id_farm_far_pro"; 
        sql += " inner join producers p on p.id_pro=fp.id_producer_far_pro"; 
        sql += " inner join entities e on e.id_ent=p.id_entity_pro"; 
        sql += " where l.status=1 and f.status=1 and pe.status=1 and e.status=1 and ct.status_cro_typ=1";        
        
        if (args.containsKey("idEntUser")) {
            sqlAdd += " and le.id_entity_log_ent="+args.get("idEntUser");
        }
     
        if (args.containsKey("search_crop")) {
            String valIdent = String.valueOf(args.get("search_crop"));
            if(!valIdent.equals(" ") && !valIdent.equals("-1") && !valIdent.equals("") && !valIdent.equals("null")) { 
                sql += " and ((e.name_ent like '%"+valIdent+"%')";
                try {
                    String dateAsign = new SimpleDateFormat("yyyy-dd-MM").format(new Date(valIdent));
                    sql += " or (s.date_sow like '%"+dateAsign+"%')";
                    sql += " or (har.date_har like '%"+dateAsign+"%')";
                } catch (IllegalArgumentException ex) {
                }
                
                sql += " or (pe.id_pro_eve like '%"+valIdent+"%')";
                sql += " or (e.document_type_ent='"+valIdent+"')";
                sql += " or (e.document_number_ent like '%"+valIdent+"%')";
                
                sql += " or (f.id_far like '%"+valIdent+"%')";
                sql += " or (f.name_far like '%"+valIdent+"%')";
                sql += " or (l.id_farm_fie like '%"+valIdent+"%')";
                sql += " or (l.name_fie like '%"+valIdent+"%'))";
            }
        }
        
        if (args.containsKey("date_sowing")) {
            String valIdent = String.valueOf(args.get("date_sowing"));            
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) {
                String dateAsign = new SimpleDateFormat("yyyy-dd-MM").format(new Date(valIdent));
                sql += " and s.date_sow like '%"+dateAsign+"%'";
            }
        }
        
        if (args.containsKey("date_harvest")) {
            String valIdent = String.valueOf(args.get("date_harvest"));            
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) {
                String dateAsign = new SimpleDateFormat("yyyy-dd-MM").format(new Date(valIdent));
                sql += " and har.date_har like '%"+dateAsign+"%'";
            }
        }
        
        if (args.containsKey("name_producer")) {
            String valIdent = String.valueOf(args.get("name_producer"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.name_ent like '%"+valIdent+"%'";
        }
        if (args.containsKey("idCrop")) {
            String valIdent = String.valueOf(args.get("idCrop"));
            if(!valIdent.equals("0") && !valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and pe.id_pro_eve like '%"+valIdent+"%'";
        }
        if (args.containsKey("type_doc")) {
            String valIdent = String.valueOf(args.get("type_doc"));
            if(!valIdent.equals("0") && !valIdent.equals("-1") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.document_type_ent='"+valIdent+"'";
        }
        if (args.containsKey("num_doc")) {
            String valIdent = String.valueOf(args.get("num_doc"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.document_number_ent like '%"+valIdent+"%'";
        }
        if (args.containsKey("num_farm")) {
            String valIdent = String.valueOf(args.get("num_farm"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and f.id_far like '%"+valIdent+"%'";
        }        
        if (args.containsKey("name_farm")) {
            String valIdent = String.valueOf(args.get("name_farm"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and f.name_far like '%"+valIdent+"%'";
        }   
        if (args.containsKey("num_field")) {
            String valIdent = String.valueOf(args.get("num_field"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and l.id_farm_fie like '%"+valIdent+"%'";
        } 
        if (args.containsKey("name_field")) {
            String valIdent = String.valueOf(args.get("name_field"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and l.name_fie like '%"+valIdent+"%'";
        } 
        // if ($identProductor!='' ) sql += "where";
        sql += sqlAdd;

//        args.get("countTotal");
        
        int valIni = Integer.parseInt(String.valueOf(args.get("pageNow")));
//        int valIni = Integer.parseInt(args.get("pageNow"))*Integer.parseInt((String)args.get("maxResults"));
        int maxResults = Integer.parseInt(String.valueOf(args.get("maxResults")));
        if(valIni!=1){
//            valIni = ((valIni-1)*maxResults)+1;
            valIni = ((valIni-1)*maxResults);
        } else {
            valIni = 0;
        }     
        sql += " order by pe.id_pro_eve ASC";
//        events.toArray();
        System.out.println("sql->"+sql);
        try {
            tx = session.beginTransaction();
//            Query query = session.createSQLQuery(sql);
            Query query  = session.createSQLQuery(sql);
//            System.out.println("sql->"+query.list().size());
            HashMap tempTotal = new HashMap();
            tempTotal.put("countTotal", query.list().size());
            result.add(tempTotal);
            if(query.list().size()>maxResults) {
                query.setFirstResult(valIni);
                query.setMaxResults(maxResults);      
            }
            events = query.list();     
                    
            for (Object[] data : events) {
                HashMap temp = new HashMap();
                temp.put("idCrop", data[0]);
                temp.put("num_crop", data[0]);
                temp.put("type_doc", data[1]);
                temp.put("num_doc", data[2]);             
                temp.put("name_producer", data[3]);                
                temp.put("num_farm", data[4]);
                temp.put("name_farm", data[5]);
                temp.put("num_field", data[6]);                
                temp.put("name_field", data[7]);                
                temp.put("date_sowing", data[8]);
                temp.put("name_genotype", data[9]);
                temp.put("status", data[10]);
                temp.put("typeEnt", data[11]);
                temp.put("dateLog", data[12]);
                temp.put("nameCrop", data[13]);
                temp.put("date_harvest", data[14]);
                result.add(temp);
            }
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
    
    public HashMap getReportAnnualAgronomist(HashMap args, String semester, int posVal) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<Object[]> events = null;
        Transaction tx = null;
        HashMap result = new HashMap();
        String resultInfo = "";
        String resultOut  = "";
        
        String sql = "";        
//        sql += "select ep.id_pro_eve, year(har.date_har), ent.id_ent, ent.name_ent, har.yield_har";
        sql += "select ep.id_pro_eve, har.date_har, ent.id_ent, ent.name_ent, har.yield_har";
        sql += " from production_events ep";
        sql += " inner join fields l on ep.id_field_pro_eve = l.id_fie";
        sql += " inner join farms f on l.id_farm_fie=f.id_far";
        sql += " inner join farms_producers fp on f.id_far = fp.id_farm_far_pro";
        sql += " inner join producers p on p.id_pro = fp.id_producer_far_pro";
        sql += " inner join entities ent on ent.id_ent = p.id_entity_pro";
        sql += " inner join harvests har on ep.id_pro_eve = har.id_production_event_har";
        sql += " inner join log_entities le on le.id_object_log_ent=ep.id_pro_eve and le.table_log_ent='production_events' and le.action_type_log_ent='C'";
        sql += " where ep.status=1";        
        
        if (args.containsKey("idEntUser")) {
            sql += " and le.id_entity_log_ent="+args.get("idEntUser");
        }
        
        if (args.containsKey("name_producer")) {
            String valIdent = String.valueOf(args.get("name_producer"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.name_ent like '%"+valIdent+"%'";
        }
        
        if (args.containsKey("type_doc")) {
            String valIdent = String.valueOf(args.get("type_doc"));
            if(!valIdent.equals("0") && !valIdent.equals("-1") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.document_type_ent='"+valIdent+"'";
        }
        
        if (args.containsKey("num_doc")) {
            String valIdent = String.valueOf(args.get("num_doc"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.document_number_ent like '%"+valIdent+"%'";
        }
        
        if(!semester.equals(" ") && !semester.equals("") && !semester.equals("null")) {
            sql += " and har.date_har between "+semester;
        }
        
        sql += " order by har.yield_har";
//        sql += " order by har.date_har";
        
//        System.out.println("sql->"+sql);
        try {
            tx = session.beginTransaction();
            Query query  = session.createSQLQuery(sql);
            events       = query.list();     
            Integer totalVal = query.list().size();
            int q1 = (int) Math.round(totalVal*0.25);
            int q2 = (int) Math.round(totalVal*0.50);
            int q3 = (int) Math.round(totalVal*0.75);
            resultInfo = "["+events.get(q1-1)+","+events.get(q2-1)+","+events.get(q3-1)+"]";
//            resultOut = "["+events.get(q1-1)+","+events.get(q2-1)+","+events.get(q3-1)+"]";
            result.put("info", resultInfo);
            result.put("out", resultOut);
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
    
    public String getReportAnnualProducer(HashMap args) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<Object[]> events = null;
        Transaction tx = null;
        String result  = "[";
        
        String sql = "";        
        sql += "select ep.id_pro_eve, year(har.date_har), month(har.date_har), day(har.date_har), ent.id_ent, ent.name_ent, har.yield_har";
        sql += " from production_events ep";
        sql += " inner join fields l on ep.id_field_pro_eve = l.id_fie";
        sql += " inner join farms f on l.id_farm_fie=f.id_far";
        sql += " inner join farms_producers fp on f.id_far = fp.id_farm_far_pro";
        sql += " inner join producers p on p.id_pro = fp.id_producer_far_pro";
        sql += " inner join entities ent on ent.id_ent = p.id_entity_pro";
        sql += " inner join harvests har on ep.id_pro_eve = har.id_production_event_har";
        sql += " inner join log_entities le on le.id_object_log_ent=ep.id_pro_eve and le.table_log_ent='production_events' and le.action_type_log_ent='C'";
        sql += " where ep.status=1";        
        
        if (args.containsKey("idEntUser")) {
            sql += " and le.id_entity_log_ent="+args.get("idEntUser");
        }
        
        if (args.containsKey("selYear")) {
            String selYear = String.valueOf(args.get("selYear"));
            if (selYear.equals("1")) {
                if (args.containsKey("year_begin")) {
                    String valIdent = String.valueOf(args.get("year_begin"));            
                    if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) {
                        sql += " and year(har.date_har) = '"+valIdent+"'";
                    }
                }
            } else if (selYear.equals("2")) {
                if (args.containsKey("year_begin") && args.containsKey("year_end")) {
                    String valBegin = String.valueOf(args.get("year_begin"));            
                    String valEnd   = String.valueOf(args.get("year_end"));            
                    if((!valBegin.equals(" ") && !valBegin.equals("") && !valBegin.equals("null")) && (!valEnd.equals(" ") && !valEnd.equals("") && !valEnd.equals("null"))) {
                        sql += " and (year(har.date_har) = '"+valBegin+"' and year(har.date_har) = '"+valEnd+")'";
                    }
                }
            }          
        }        
        
        if (args.containsKey("name_producer")) {
            String valIdent = String.valueOf(args.get("name_producer"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.name_ent like '%"+valIdent+"%'";
        }
        
        if (args.containsKey("type_doc")) {
            String valIdent = String.valueOf(args.get("type_doc"));
            if(!valIdent.equals("0") && !valIdent.equals("-1") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.document_type_ent='"+valIdent+"'";
        }
        
        if (args.containsKey("num_doc")) {
            String valIdent = String.valueOf(args.get("num_doc"));
            if(!valIdent.equals(" ") && !valIdent.equals("") && !valIdent.equals("null")) sql += " and e.document_number_ent like '%"+valIdent+"%'";
        }
        
        sql += " order by har.date_har";
        try {
            tx = session.beginTransaction();
            Query query  = session.createSQLQuery(sql);
            events       = query.list();     
            int totalVal = query.list().size();
            int cont = 0;
            for (Object[] data : events) {
                if (cont!=totalVal) {
                    result += "[gd("+data[1]+","+data[2]+","+data[3]+"), "+data[6]+"],";
                } else {
                    result += "[gd("+data[1]+","+data[2]+","+data[3]+"), "+data[6]+"]";
                }
                cont++;
            }
            result += "]";
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
    
    
    
    public static Integer countData(HashMap args) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        Object[] events = null;
        Transaction tx = null;
        Integer result = 0;
        
        String sql = "";     
        String sqlAdd = "";     
                      
        sql += "select count(pe.id_pro_eve), pe.id_field_pro_eve";
        sql += " from production_events pe";  
        sql += " inner join log_entities le on le.id_object_log_ent=pe.id_pro_eve and le.table_log_ent='production_events' and le.action_type_log_ent='C'";   
        sql += " inner join fields l on l.id_fie=pe.id_field_pro_eve";
        sql += " inner join farms f on f.id_far=l.id_farm_fie";        
        sql += " inner join farms_producers fp on fp.id_farm_far_pro=f.id_far"; 
        sql += " inner join producers p on p.id_pro=fp.id_producer_far_pro"; 
        sql += " inner join entities e on e.id_ent=p.id_entity_pro";
        sql += " where l.status=1 and f.status=1 and pe.status=1 and e.status=1";        
        
        if (args.containsKey("idEntUser")) {
            sqlAdd += " and le.id_entity_log_ent="+args.get("idEntUser");
        }
        sql += sqlAdd;
//        System.out.println("sql->"+sql);
        try {
            tx = session.beginTransaction();
            Query query  = session.createSQLQuery(sql);
            events = (Object[])query.uniqueResult();
            result = Integer.parseInt(String.valueOf(events[0]));
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
    
    public ProductionEvents objectById(Integer id) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        ProductionEvents event = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            String hql  = "FROM ProductionEvents E WHERE E.idProEve = :id_crop";
            Query query = session.createQuery(hql);
            query.setParameter("id_crop", id);
            event = (ProductionEvents)query.uniqueResult();
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

    public void save(ProductionEvents event) {
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

    public void delete(ProductionEvents event) {
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
