package org.rodyce.foncier.datamodel.ladm.external;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ExtPhysicalNetwork", schema="ladm_external")
@Inheritance(strategy=InheritanceType.JOINED)
public class ExtPhysicalNetwork implements Serializable {
    private static final long serialVersionUID = 1L;


    public ExtPhysicalNetwork() {
    }
    
    private UUID extPartyManagerID;
    private boolean directed;
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getExtPartyManagerID() {
        return extPartyManagerID;
    }
    protected void setExtPartyManagerID(UUID value) {
        this.extPartyManagerID = value;
    }
    @Transient
    public UUID getORMID() {
        return getExtPartyManagerID();
    }
    
    
    @Column(name="Directed", nullable=false)    
    public boolean getDirected() {
        return directed;
    }
    public void setDirected(boolean value) {
        this.directed = value;
    }
    
    public String toString() {
        return String.valueOf(getExtPartyManagerID());
    }
}
