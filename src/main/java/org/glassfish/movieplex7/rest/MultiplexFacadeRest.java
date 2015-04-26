
package org.glassfish.movieplex7.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.glassfish.movieplex7.entities.Multiplex;

@Named
@Stateless
@Path("multiplexes")
public class MultiplexFacadeRest extends AbstractFacade<Multiplex> {

    @PersistenceContext
    protected EntityManager entityManager;

    public MultiplexFacadeRest() {
        super(Multiplex.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Multiplex multiplex) {
        super.create(multiplex);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    @Path("{id}")
    public void edit(Multiplex multiplex) {
        super.edit(multiplex);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Multiplex find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Multiplex> getAll() {
        return super.getAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Multiplex> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String getCount() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
