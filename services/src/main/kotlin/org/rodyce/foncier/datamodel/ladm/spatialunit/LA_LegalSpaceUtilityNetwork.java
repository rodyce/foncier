package org.rodyce.foncier.datamodel.ladm.spatialunit;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_LegalSpaceUtilityNetwork", schema="ladm_spatialunit")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_LegalSpaceNetwork")
@PrimaryKeyJoinColumn(name="LA_SpatialUnitID", referencedColumnName="ID")
public class LA_LegalSpaceUtilityNetwork extends LA_SpatialUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID extPhysicalNetworkID;
    private LA_UtilityNetworkStatusType status;
    private LA_UtilityNetworkType type;
    
    public LA_LegalSpaceUtilityNetwork() {
    }

    @Column(name="ExtPhysicalNetworkID", nullable=false)
    public UUID getExtPhysicalNetworkID() {
        return extPhysicalNetworkID;
    }
    protected void setExtPhysicalNetworkID(UUID value) {
        this.extPhysicalNetworkID = value;
    }
    
    @Column(name="Status", nullable=true)    
    @Enumerated(EnumType.STRING)
    public LA_UtilityNetworkStatusType getStatus() {
        return status;
    }
    public void setStatus(LA_UtilityNetworkStatusType value) {
        this.status = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_UtilityNetworkType getType() {
        return type;
    }
    public void setType(LA_UtilityNetworkType value) {
        this.type = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
