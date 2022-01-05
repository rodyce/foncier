package org.rodyce.foncier.datamodel.ladm.special;

import org.rodyce.foncier.datamodel.commons.IVersionedObject;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

@MappedSuperclass
public abstract class VersionedObject implements IVersionedObject, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Date beginLifespanVersion;
    private Date endLifespanVersion;
    //private byte quality;
    //private byte source;
    
    
    @Column(name="BeginLifespanVersion", nullable=true)
    public Date getBeginLifespanVersion() {
        return beginLifespanVersion;
    }
    public void setBeginLifespanVersion(Date value) {
        this.beginLifespanVersion = value;
    }
    
    @Column(name="EndLifespanVersion", nullable=true)
    public Date getEndLifespanVersion() {
        return endLifespanVersion;
    }
    public void setEndLifespanVersion(Date value) {
        this.endLifespanVersion = value;
    }
    
    
    /*
     * TODO: Complete these fields in a future version of the software
     * 
     * 
    @Column(name="Quality", nullable=false)
    public byte getQuality() {
        return quality;
    }
    public void setQuality(byte value) {
        this.quality = value;
    }
    
    @Column(name="Source", nullable=false)
    public byte getSource() {
        return source;
    }
    public void setSource(byte value) {
        this.source = value;
    }
    */

    @Transient
    public boolean isAlive() {
        return getEndLifespanVersion() == null;
    }

}
