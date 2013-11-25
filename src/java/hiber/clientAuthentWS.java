/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hiber;

import hibernate.Appareil;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.sf.cglib.proxy.Factory;
import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
import utilhibernate.HibernateUtil;
import org.hibernate.Session;


/**
 *
 * @author PB
 */
@WebService(serviceName = "clientAuthentWS")
public class clientAuthentWS {
    private Object List;
    private String tmpch1="";
    private String returnvalue="";
  @WebMethod(operationName = "clientauthent")

    public String clientauthent(@WebParam(name = "loginclient") String loginclient, @WebParam(name = "pwdclient") String pwdclient) {
  
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
          
   List result = session.createQuery("FROM Client as client  where client.idclient = '"+loginclient+"' and client.passwordclient='"+pwdclient+"' ").list();     
      
      if (result.isEmpty()) {
          System.out.println("listevide");
          session.close();
         returnvalue= "empty";
        }
      else
      {
             List result2 = session.createQuery("FROM Appareil as appareil  where idclient = '"+loginclient+"' ").list();     
  
       
       for (Iterator iterator =  result2.iterator(); 
           iterator.hasNext();){
           Appareil cli = (  Appareil ) iterator.next(); 
           System.out.println("First id: " + cli.getIdappareil()); 
       tmpch1 = tmpch1 +"@"+  cli.getIdappareil() ;
       }
       //emplacement a verifier
       //   session.getTransaction().commit();     

       //pour supprimer l'ancienne chaine
       returnvalue = tmpch1;
       tmpch1=""; 
      }
  //     session.save(List);
     
        return returnvalue;
    }


    }

