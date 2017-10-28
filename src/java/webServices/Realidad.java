/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author FAMILIA
 */
@Path("realidad/interface1")
public class Realidad {

    @Context
    private UriInfo context;

    public Realidad() {
    }

    @GET
    @Path("bloque1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getABloque1(
          @QueryParam("usuario") String value1,
          @QueryParam("otra cosa") String valor2
    ) {

        return "{'valor1':'" + value1 + "','value2':'" +valor2 + "'}";
    }

    @GET
    @Path("bloque2")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String getABloque2() {

        return "{}";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
