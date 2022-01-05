package org.rodyce.foncier.datamodel.hnd.special;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.rodyce.foncier.datamodel.ladm.external.ExtArchiveKey;

@Entity
@Table(name="ArchiveInternalRepository", schema="hnd_special")
@Inheritance(strategy=InheritanceType.JOINED)
public class ArchiveInternalRepository implements Serializable {
    private static final long serialVersionUID = 1L;

    private ExtArchiveKey extArchiveKeyId;
    private byte[] data;
    
    @Id
    public ExtArchiveKey getExtArchiveKeyId() {
        return extArchiveKeyId;
    }
    public void setExtArchiveKeyId(ExtArchiveKey extArchiveKeyId) {
        this.extArchiveKeyId = extArchiveKeyId;
    }    

    @Column(name="Data", nullable=true)
    @Lob
    @Basic(fetch=FetchType.LAZY)
    public byte[] getData() {
        return data;
    }
    public void setData(byte[] value) {
        this.data = value;
    }
}
