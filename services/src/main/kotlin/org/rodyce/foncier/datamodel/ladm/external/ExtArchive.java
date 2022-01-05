package org.rodyce.foncier.datamodel.ladm.external;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IExtArchive;
import org.rodyce.foncier.datamodel.commons.ISource;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ExtArchive", schema="ladm_external")
@Inheritance(strategy=InheritanceType.JOINED)
public class ExtArchive implements IExtArchive, Serializable {
    private static final long serialVersionUID = 1L;

    private UUID sID;
    private java.util.Date acceptance;
    private String name;
    private byte[] data;
    private String description;
    private java.util.Date recordation;
    private java.util.Date submission;
    private Boolean external;
    public ISource source;


    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getsID() {
        return sID;
    }
    protected void setsID(UUID value) {
        this.sID = value;
    }
    @Transient
    public UUID getORMID() {
        return getsID();
    }
    
    @Column(name="Acceptance", nullable=true)
    public java.util.Date getAcceptance() {
        return acceptance;
    }
    public void setAcceptance(java.util.Date value) {
        this.acceptance = value;
    }
    
    @Column(name="Name", nullable=true, length=255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="Description", nullable=true, length=1024)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    
    @Column(name="Recordation", nullable=true)
    public java.util.Date getRecordation() {
        return recordation;
    }
    public void setRecordation(java.util.Date value) {
        this.recordation = value;
    }
    
    @Column(name="Submission", nullable=true)
    public java.util.Date getSubmission() {
        return submission;
    }
    public void setSubmission(java.util.Date value) {
        this.submission = value;
    }
    
    @Column(name="External", nullable=true)
    public Boolean isExternal() {
        return external;
    }
    public void setExternal(Boolean external) {
        this.external = external;
    }


    public String toString() {
        return String.valueOf(getsID());
    }
}
