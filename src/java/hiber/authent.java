/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hiber;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author PB
 */
@WebService(serviceName = "authent")
public class authent {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "authentification")
    public String authentification(@WebParam(name = "login") String login, @WebParam(name = "motdepasse") String motdepasse) {
     
        //TODO write your implementation code here:
        String message = "dehors boucle" ;
        if ("admin".equals(login) && "admin".equals(motdepasse) ) 
        {message="success";}
        else if (login != "admin" || motdepasse !="admin")
        {
        message="failed!!!!";};
        return message;
    }
}
