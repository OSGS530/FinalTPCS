/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.uv.dao.*;

/**
 * REST Web Service
 *
 * @author gusky
 */
@Path("generic")
public class GenericResource {
    
    PersonaDAO dao = new PersonaDAO();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of org.uv.GenericResource
     * @return an instance of java.lang.String
     */
    //http://localhost:8084/restfinal/webresources/generic
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getJson() {       
        return dao.mostrarTodos();
    }
    
    @GET
    @Path("{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getOneJson(@PathParam("clave")String clave) {       
        return dao.buscar(clave);
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(Persona p) {
        Persona aux = p;
        System.out.print(p.getClave());
        try {
            boolean res = dao.actualizar(aux);
            return res?"Usuario actualizado":"Error al actualizar";
         } catch (Exception e) {
            return "error: "+e;
         }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(Persona p) {
        
         try {
            boolean res = dao.guardar(p);
            return res?"Usuario guardado":"Error al guardar";
         } catch (Exception e) {
            return "error: "+e;
         }
    }
    
    @DELETE
    @Path("{clave}")
    @Consumes(MediaType.APPLICATION_XHTML_XML)
    public String deleteJson(@PathParam("clave")String clave) {
        try {
            boolean res = dao.eliminar(clave);
            return res?"Usuario eliminado exitosamente":"Error al eliminar";
         } catch (Exception e) {
            return "error: "+e;
         }
    }  
}
