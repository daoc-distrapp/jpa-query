/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import negocio.EjbBdd;
import persistencia.Libro;

/**
 *
 * @author dordonez
 */
@ApplicationPath("rest")
@Path("libro")
public class Rest extends Application {
    @EJB
    EjbBdd ejb;
        
    @GET//solo por prueba. Debería ser @POST
    @Path("{autor}/{titulo}")
    @Produces("application/xml")
    public Libro nuevo(@PathParam("autor") String autor, @PathParam("titulo") String titulo) {
        return ejb.nuevo(autor, titulo);
    }    

    @GET//solo por prueba. Debería ser @PUT
    @Path("{id}/{autor}/{titulo}")
    @Produces("application/xml")
    public Libro cambia(@PathParam("id") long id, @PathParam("autor") String autor, @PathParam("titulo") String titulo) {
        return ejb.cambia(id, autor, titulo);
    }     
    
    @GET
    @Path("todos")
    @Produces("application/xml")
    public List<Libro> todos() {
        return ejb.todos();
    }
    
    @GET
    @Path("autor/{autor}")
    @Produces("application/xml")
    public List<Libro> algunos(@PathParam("autor") String autor) {
        return ejb.algunos(autor);
    }    
}
