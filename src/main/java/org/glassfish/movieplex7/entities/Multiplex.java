package org.glassfish.movieplex7.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "MULTIPLEXES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multiplex.findAll", query = "SELECT m FROM Multiplex m"),
    @NamedQuery(name = "Multiplex.findById",
            query = "SELECT m FROM Multiplex m WHERE m.id = :id"),
    @NamedQuery(name = "Multiplex.findByCity",
            query = "SELECT m FROM Multiplex m WHERE m.city = :city")})

public class Multiplex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Size(min = 1, max = 50)
    private String id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String city;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "multiplex")
    private Collection<ShowTiming> showTimings;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<ShowTiming> showTimings;
    
    @XmlTransient
    public Collection<ShowTiming> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(Collection<ShowTiming> showTimings) {
        this.showTimings = showTimings;
    }
    */

    @XmlTransient
    public Collection<ShowTiming> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(Collection<ShowTiming> showTimings) {
        this.showTimings = showTimings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    

    public Multiplex() {
    }

    public Multiplex(String id) {
        this.id = id;
    }

    public Multiplex(String id, String city) {
        this.id = id;
        this.city = city;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multiplex)) {
            return false;
        }
        Multiplex other = (Multiplex) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id;
    }
}
