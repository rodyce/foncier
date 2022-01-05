package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class HND_PermitNorm {
    private HND_SpatialZone spatialZone;
    
    public HND_PermitNorm(HND_SpatialZone spatialZone) {
        this.spatialZone = spatialZone;
    }


    public Integer getMaxNumberOfFloors() {
        return spatialZone.getMaxNumberOfFloors();
    }
    public void setMaxNumberOfFloors(Integer maxNumberOfFloors) {
        spatialZone.setMaxNumberOfFloors(maxNumberOfFloors);
    }
    
    public BigDecimal getMaxBuiltArea() {
        return spatialZone.getMaxBuiltArea();
    }
    public void setMaxBuiltArea(BigDecimal maxBuiltArea) {
        spatialZone.setMaxBuiltArea(maxBuiltArea);
    }
    
    public List<HND_BuildingMaterial> getForbiddenBuildingMaterials() {
        return spatialZone.getForbiddenBuildingMaterials();
    }
    public void setForbiddenBuildingMaterials(
            List<HND_BuildingMaterial> forbiddenBuildingMaterials) {
        spatialZone.setForbiddenBuildingMaterials(forbiddenBuildingMaterials);
    }
}
