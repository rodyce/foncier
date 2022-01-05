package org.rodyce.foncier.datamodel.ladm.spatialunit;

import java.io.Serializable;
import java.math.BigDecimal;

public class LA_AreaValue implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LA_AreaType areaType;
    private BigDecimal areaSize;
    
    public LA_AreaValue(LA_AreaType areaType, BigDecimal areaSize) {
        this.areaType = areaType;
        this.areaSize = areaSize;
    }
    
    public String getAreaType() {
        return areaType.toString();
    }
    public BigDecimal getAreaSize() {
        return areaSize;
    }
    
    public boolean equals(LA_AreaValue y) {
        return this.getAreaType() == y.getAreaType()
            && this.getAreaSize().equals(y.getAreaSize());
    }
}
