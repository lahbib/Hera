/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hiber;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author PB
 */
@Path("clientauthentwsport")
public class clientAuthentWSPort {
    private hiber_client.ClientAuthentWS port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of clientAuthentWSPort
     */
    public clientAuthentWSPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method clientauthent
     * @param loginclient resource URI parameter
     * @param pwdclient resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("clientauthent/")
    public String getClientauthent(@QueryParam("loginclient") String loginclient, @QueryParam("pwdclient") String pwdclient) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.clientauthent(loginclient, pwdclient);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private hiber_client.ClientAuthentWS getPort() {
        try {
            // Call Web Service Operation
            hiber_client.ClientAuthentWS_Service service = new hiber_client.ClientAuthentWS_Service();
            hiber_client.ClientAuthentWS p = service.getClientAuthentWSPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
