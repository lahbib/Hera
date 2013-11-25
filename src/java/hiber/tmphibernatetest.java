/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hiber;

import hibernate.Appareil;
import hibernate.Client;
import hibernate.Panne;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import utilhibernate.HibernateUtil;

/**
 *
 * @author PB
 */
public class tmphibernatetest {
    private static Object List;
    
    
   List<Client> clientlist=null;
    
    public static void main(String[] args )throws IOException, ParseException, SQLException{
    String loginclient ="client1";
    String pwdclient = "client1pwd";
    String tmpch1 = null ;
    String returnvalue ;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
          
   List result = session.createQuery("FROM Client as client  where client.idclient = '"+loginclient+"' and client.passwordclient='"+pwdclient+"' ").list();     
      session.getTransaction().commit();
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
     //   session.getTransaction().commit();     
       // clientlist.
      //  result.size();
        returnvalue = tmpch1;
        
    
      }
      System.out.println("return value is "+returnvalue);
    }
    
    
}
