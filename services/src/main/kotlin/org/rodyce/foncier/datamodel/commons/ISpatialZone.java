package org.rodyce.foncier.datamodel.commons;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_LandUse;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.vividsolutions.jts.geom.Geometry;

public interface ISpatialZone extends ISpatialUnit {
    Geometry getShape();
    void setShape(Geometry shape);
    
    String getZoneName();
    void setZoneName(String zoneName);
    
    String getLocationInCountry();
    void setLocationInCountry(String value);

    BigDecimal getGeometryPerimeter();
    void setGeometryPerimeter(BigDecimal geometryPerimeter);
    
    BigDecimal getMeasuredPerimeter();
    void setMeasuredPerimeter(BigDecimal measuredPerimeter);
    
    BigDecimal getDocumentedPerimeter();
    void setDocumentedPerimeter(BigDecimal documentedPerimeter);
    
    BigDecimal getGeometryArea();
    void setGeometryArea(BigDecimal geometryArea);
    
    BigDecimal getDocumentedArea();
    void setDocumentedArea(BigDecimal documentedArea);
    
    BigDecimal getMeasuredArea();
    void setMeasuredArea(BigDecimal measuredArea);

    HND_LandUse getLandUse();
    void setLandUse(HND_LandUse landUse);
    
    HND_LandUse getProposedLandUse();
    void setProposedLandUse(HND_LandUse proposedLandUse);

    List<HND_LandUse> getOtherLandUses();
    void setOtherLandUses(List<HND_LandUse> otherLandUses);

    
    IProperty getProperty();
}
