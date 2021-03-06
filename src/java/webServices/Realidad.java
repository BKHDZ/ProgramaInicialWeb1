/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
            @QueryParam("nombre") String valor1,
            @QueryParam("edad") String valor2
    ) {
        System.out.println("Entro WS [" + valor1 + "][" + valor2 + "]");
        String respuesta = "{}";
        try {
            Socket socket = new Socket("localhost", 4000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("CREAR SER VIVO");
            out.println(valor1);
            out.println(valor2);
            out.println("Humano");
            respuesta = "{'respuestaSocket':'" + in.readLine() + "'}";
        } catch (Exception e) {
            respuesta = "{'respuestaSocket':'" + e.getMessage() + "'}";
        }

        return respuesta;
    }

    @GET
    @Path("bloque2")
    @Produces(MediaType.APPLICATION_JSON)
    public String getABloque2(
            @QueryParam("tipoNave") String valor1,
            @QueryParam("nombreNave") String valor2
    ) {
        System.out.println("Entro WS [" + valor1 + "][" + valor2 + "]");
        return "{'valor1':'" + valor1 + "','value2':'" + valor2 + "'}";
    }

    @POST
    @Path("bloque3")
    @Produces(MediaType.APPLICATION_JSON)
    public String getABloque3(
            @QueryParam("nombre") String valor1
    ) {
        System.out.println("Entro WS [" + valor1 + "][" + "---" + "]");
        return "{'valor1':'" + valor1 + "','value2':'" + "---" + "'}";
        //return "POST works!";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
