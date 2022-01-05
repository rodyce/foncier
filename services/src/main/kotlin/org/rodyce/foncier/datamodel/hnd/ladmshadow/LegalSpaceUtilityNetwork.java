package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_UtilityNetworkStatusType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_UtilityNetworkType;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LegalSpaceUtilityNetwork", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LegalSpaceNetwork")
@PrimaryKeyJoinColumn(name="SpatialUnitID", referencedColumnName="ID")
public class LegalSpaceUtilityNetwork extends SpatialUnit implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private long extPhysicalNetworkID;
    private LA_UtilityNetworkStatusType status;
    private LA_UtilityNetworkType type;
    
    public LegalSpaceUtilityNetwork() {
    }

    @Column(name="ExtPhysicalNetworkID", nullable=false)
    public long getExtPhysicalNetworkID() {
        return extPhysicalNetworkID;
    }
    public void setExtPhysicalNetworkID(long value) {
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
