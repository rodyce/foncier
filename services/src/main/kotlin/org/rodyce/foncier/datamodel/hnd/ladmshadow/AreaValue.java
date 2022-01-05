package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_AreaType;

import java.io.Serializable;
import java.math.BigDecimal;

public class AreaValue implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private LA_AreaType areaType;
    private BigDecimal areaSize;
    
    public AreaValue(LA_AreaType areaType, BigDecimal areaSize) {
        this.areaType = areaType;
        this.areaSize = areaSize;
    }
    
    public String getAreaType() {
        return areaType.toString();
    }
    public BigDecimal getAreaSize() {
        return areaSize;
    }
    
    public boolean equals(AreaValue y) {
        return this.getAreaType() == y.getAreaType()
            && this.getAreaSize().equals(y.getAreaSize());
    }
}
