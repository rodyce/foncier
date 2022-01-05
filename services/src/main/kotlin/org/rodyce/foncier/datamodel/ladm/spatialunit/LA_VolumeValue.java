package org.rodyce.foncier.datamodel.ladm.spatialunit;

import java.io.Serializable;
import java.math.BigDecimal;

public class LA_VolumeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LA_VolumeType volumeType;
    private BigDecimal volumeSize;
    
    public LA_VolumeValue(LA_VolumeType volumeType, BigDecimal volumeSize) {
        this.volumeType = volumeType;
        this.volumeSize = volumeSize;
    }
    
    public LA_VolumeType getVolumeType() {
        return volumeType;
    }
    public BigDecimal getVolumeSize() {
        return volumeSize;
    }
    
    public boolean equals(LA_VolumeValue y) {
        return this.getVolumeType() == y.getVolumeType()
            && this.getVolumeSize().equals(y.getVolumeSize());
    }
}
