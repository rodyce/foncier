package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_BuildingUnitType;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LegalSpaceBuildingUnit", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LegalSpaceBuildingUnit")
@PrimaryKeyJoinColumn(name="SpatialUnitID", referencedColumnName="ID")
public class LegalSpaceBuildingUnit extends SpatialUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID buildingUnitID;
    private LA_BuildingUnitType type;

    public LegalSpaceBuildingUnit() {
    }

    @Column(name="BuildingUnitID", nullable=false)
    public UUID getBuildingUnitID() {
        return buildingUnitID;
    }
    public void setBuildingUnitID(UUID value) {
        this.buildingUnitID = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_BuildingUnitType getType() {
        return type;
    }
    public void setType(LA_BuildingUnitType value) {
        this.type = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
