package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IExtArchive;
import org.rodyce.foncier.datamodel.commons.ISource;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Source", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Source")
public abstract class Source extends AssociationInfo implements ISource, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID sID;
    private Party party;
    private java.util.Date acceptance;
    private IExtArchive archive;
    private java.util.Date lifeSpanStamp;
    private byte mainType;
    private java.util.Date recordation;
    private java.util.Date submission;

    public Source() {
    }

    
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

    
    
    @OneToOne(targetEntity=ExtArchive.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="ExtArchiveID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public IExtArchive getArchive() {
        return archive;
    }
    public void setArchive(IExtArchive value) {
        this.archive = value;
    }
    
    
    
    @Column(name="LifeSpanStamp", nullable=true)
    public java.util.Date getLifeSpanStamp() {
        return lifeSpanStamp;
    }
    public void setLifeSpanStamp(java.util.Date value) {
        this.lifeSpanStamp = value;
    }
    
    @Column(name="MainType", nullable=false)
    public byte getMainType() {
        return mainType;
    }
    public void setMainType(byte value) {
        this.mainType = value;
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
    
    @ManyToOne(targetEntity=Party.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="PartyID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public Party getParty() {
        return party;
    }
    public void setParty(Party value) {
        this.party = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
