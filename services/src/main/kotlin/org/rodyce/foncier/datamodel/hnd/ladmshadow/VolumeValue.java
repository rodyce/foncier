package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_VolumeType;

import java.io.Serializable;
import java.math.BigDecimal;

public class VolumeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LA_VolumeType volumeType;
    private BigDecimal volumeSize;
    
    public VolumeValue(LA_VolumeType volumeType, BigDecimal volumeSize) {
        this.volumeType = volumeType;
        this.volumeSize = volumeSize;
    }
    
    public LA_VolumeType getVolumeType() {
        return volumeType;
    }
    public BigDecimal getVolumeSize() {
        return volumeSize;
    }
    
    public boolean equals(VolumeValue y) {
        return this.getVolumeType() == y.getVolumeType()
            && this.getVolumeSize().equals(y.getVolumeSize());
    }
}
