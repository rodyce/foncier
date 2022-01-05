package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.rodyce.foncier.datamodel.commons.IBAUnit;
import org.rodyce.foncier.datamodel.commons.IParty;
import org.rodyce.foncier.datamodel.commons.IRRR;
import org.rodyce.foncier.datamodel.ladm.special.Rational;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="RRR", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class RRR extends AssociationInfo implements IRRR<Party, BAUnit>, Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    private UUID rID;
    private Party party;
    private BAUnit baunit;
    private String description;
    private Rational share;
    private boolean shareCheck;
    private java.util.Date timeSpec;
    private java.util.Set<AdministrativeSource> adminSources = new java.util.HashSet<AdministrativeSource>();
    
    private UUID partyLadmId;
    
    
    public RRR() {
    }
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getrID() {
        return rID;
    }
    protected void setrID(UUID value) {
        this.rID = value;
    }
    @Transient
    public UUID getRID() {
        return getrID();
    }
    
    @Column(name="Description", nullable=true, length=255)
    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }
    
    @Type(type = "org.rodyce.foncier.datamodel.ladm.special.RationalUserType")
    @Columns(columns = {
            @Column(name = "share_numerator"),
            @Column(name = "share_denominator")
    })
    public org.rodyce.foncier.datamodel.ladm.special.Rational getShare() {
        return share;
    }
    public void setShare(org.rodyce.foncier.datamodel.ladm.special.Rational value) {
        this.share = value;
    }
    
    @Column(name="ShareCheck", nullable=false)
    public boolean getShareCheck() {
        return shareCheck;
    }
    public void setShareCheck(boolean value) {
        this.shareCheck = value;
    }
    
    @Column(name="TimeSpec", nullable=true)
    public java.util.Date getTimeSpec() {
        return timeSpec;
    }
    public void setTimeSpec(java.util.Date value) {
        this.timeSpec = value;
    }
    
    @Override
    @ManyToOne(targetEntity=Party.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="PartyID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public Party getParty() {
        return party;
    }
    @Override
    public void setParty(IParty value) {
        this.party = (Party)value;
    }
    
    @Override
    @ManyToOne(targetEntity=BAUnit.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="BAUnitID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public BAUnit getBaunit() {
        return baunit;
    }
    @Override
    public void setBaunit(IBAUnit value) {
        this.baunit = (BAUnit)value;
    }
    
    @ManyToMany(mappedBy="rrr", targetEntity=AdministrativeSource.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<AdministrativeSource> getAdminSources() {
        return adminSources;
    }
    public void setAdminSources(java.util.Set<AdministrativeSource> value) {
        this.adminSources = value;
    }
    
    @Transient
    public UUID getPartyLadmId() {
        return partyLadmId;
    }
    public void setPartyLadmId(UUID partyLadmId) {
        this.partyLadmId = partyLadmId;
    }
    
    public RRR clone() {
        RRR clonedRrr;
        try {
            clonedRrr = (RRR) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        
        clonedRrr.setrID(null);
        
        clonedRrr.setParty(party);
        clonedRrr.setBaunit(baunit);
        clonedRrr.setDescription(description);
        clonedRrr.setShare(share);
        clonedRrr.setShareCheck(shareCheck);
        clonedRrr.setTimeSpec(timeSpec);
        clonedRrr.setAdminSources(new HashSet<AdministrativeSource>(adminSources));
        clonedRrr.setPartyLadmId(partyLadmId);

        return clonedRrr;
    }

    public String toString() {
        return super.toString();
    }
    
}
