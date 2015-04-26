package org.glassfish.movieplex7.client;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MultiplexBackingBean implements Serializable {

    String multiplexId;
    String multiplexCity;

    public String getMultiplexId() {
        return multiplexId;
    }

    public void setMultiplexId(String multiplexId) {
        this.multiplexId = multiplexId;
    }

    public String getMultiplexCity() {
        return multiplexCity;
    }

    public void setMultiplexCity(String multiplexCity) {
        this.multiplexCity = multiplexCity;
    }

    
}
