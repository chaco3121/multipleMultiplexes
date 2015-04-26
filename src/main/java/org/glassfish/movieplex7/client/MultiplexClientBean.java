package org.glassfish.movieplex7.client;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.movieplex7.entities.Multiplex;
import org.glassfish.movieplex7.json.MultiplexWriter;

@Named
@RequestScoped
public class MultiplexClientBean {

    @Inject
    MultiplexBackingBean bean;

    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target(
                "http://localhost:8080/movieplex7/webresources/multiplexes/");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Multiplex[] getMultiplexs() {
        return target.request().get(Multiplex[].class);
    }

    public Multiplex getMultiplex() {
        Multiplex multiplex = target
                .path("{multiplexId}")
                .resolveTemplate("multiplexId", bean.getMultiplexId())
                .request()
                .get(Multiplex.class);
        return multiplex;
    }

    public void deleteMultiplex() {
        target
                .path("{multiplexId}")
                .resolveTemplate("multiplexId", bean.getMultiplexId())
                .request()
                .delete();
    }

    public void addMultiplex() {
        Multiplex multiplex = new Multiplex();
        multiplex.setId(bean.getMultiplexId());
        multiplex.setCity(bean.getMultiplexCity());
        target
                .register(MultiplexWriter.class)
                .request()
                .post(Entity.entity(multiplex, MediaType.APPLICATION_JSON));
    }
}
