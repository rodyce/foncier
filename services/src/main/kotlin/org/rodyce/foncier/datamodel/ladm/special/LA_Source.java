package org.rodyce.foncier.datamodel.ladm.special;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IExtArchive;
import org.rodyce.foncier.datamodel.commons.ISource;
import org.rodyce.foncier.datamodel.ladm.external.ExtArchive;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Source", schema="ladm_special")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Source")
public abstract class LA_Source extends VersionedObject implements ISource, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID sID;
    private org.rodyce.foncier.datamodel.ladm.party.LA_Party party;
    private java.util.Date lifeSpanStamp;
    private byte mainType;
    private java.util.Date acceptance;
    private java.util.Date recordation;
    private java.util.Date submission;
    private IExtArchive archive;


    public LA_Source() {
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

    @ManyToOne(targetEntity=org.rodyce.foncier.datamodel.ladm.party.LA_Party.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="LA_PartyID", referencedColumnName="ID") })
    public org.rodyce.foncier.datamodel.ladm.party.LA_Party getParty() {
        return party;
    }
    public void setParty(org.rodyce.foncier.datamodel.ladm.party.LA_Party value) {
        this.party = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
