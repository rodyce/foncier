package org.rodyce.foncier.datamodel.ladm.spatialunit;

import java.util.UUID;

import org.rodyce.foncier.datamodel.commons.ISpatialUnit;

public interface LA_LegalSpaceBuildingUnit extends ISpatialUnit {
    public UUID getBuildingUnitID();
    
    public LA_BuildingUnitType getType();
    public void setType(LA_BuildingUnitType value);
}
