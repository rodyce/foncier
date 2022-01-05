package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private long presentationNo;
    private UUID ladmId;
    private boolean isReadOnly;
    private boolean isModified = false;
    private boolean isSnapshot;
    private boolean isOriginal = false;
    private Date beginLifespanVersion;
    private Date endLifespanVersion;
    
    
    @Column(name="PresentationNo", nullable=false)
    //TODO: indexar campos @org.hibernate.annotations.Index(name = "IDX_END_DATE")
    public long getPresentationNo() {
        return presentationNo;
    }
    public void setPresentationNo(long presentationNo) {
        this.presentationNo = presentationNo;
    }
    
    //TODO: indexar campos @org.hibernate.annotations.Index(name = "IDX_END_DATE")
    @Column(name="LadmID", nullable=true)
    public UUID getLadmId() {
        return ladmId;
    }
    public void setLadmId(UUID ladmId) {
        this.ladmId = ladmId;
    }
    
    //Por default true cuando es una parcela vecina a la que se esta modificando
    @Column(name="IsReadOnly", nullable=false)
    public boolean isReadOnly() {
        return isReadOnly;
    }
    public void setReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }
    
    @Column(name="IsModified", nullable=false)
    public boolean isModified() {
        return isModified;
    }
    public void setModified(boolean isModified) {
        this.isModified = isModified;
    }
    
    @Column(name="IsSnapshot", nullable=false)
    public boolean isSnapshot() {
        return isSnapshot;
    }
    public void setSnapshot(boolean isSnapshot) {
        this.isSnapshot = isSnapshot;
    }
    
    @Column(name="IsOriginal", nullable=false)
    public boolean isOriginal() {
        return isOriginal;
    }
    public void setOriginal(boolean isOriginal) {
        this.isOriginal = isOriginal;
    }
    
    @Column(name="BeginLifespanVersion", nullable=true)
    public Date getBeginLifespanVersion() {
        return beginLifespanVersion;
    }
    public void setBeginLifespanVersion(Date beginLifespanVersion) {
        this.beginLifespanVersion = beginLifespanVersion;
    }
    
    @Column(name="EndLifespanVersion", nullable=true)
    public Date getEndLifespanVersion() {
        return endLifespanVersion;
    }
    public void setEndLifespanVersion(Date endLifespanVersion) {
        this.endLifespanVersion = endLifespanVersion;
    }
    
    @Transient
    public boolean isAlive() {
        return endLifespanVersion == null;
    }
}
