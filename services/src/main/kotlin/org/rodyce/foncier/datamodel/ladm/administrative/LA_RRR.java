package org.rodyce.foncier.datamodel.ladm.administrative;

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
import org.rodyce.foncier.datamodel.ladm.party.LA_Party;
import org.rodyce.foncier.datamodel.ladm.special.Rational;
import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_RRR", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class LA_RRR extends VersionedObject implements IRRR<LA_Party, LA_BAUnit>, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID rID;
    private LA_Party party;
    private LA_BAUnit baunit;
    private String description;
    private Rational share;
    private boolean shareCheck;
    private java.util.Date timeSpec;
    private java.util.Set<LA_AdministrativeSource> adminSources = new HashSet<LA_AdministrativeSource>();
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getrID() {
        return rID;
    }
    public void setrID(UUID value) {
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
    public Rational getShare() {
        return share;
    }
    public void setShare(Rational value) {
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
    
    @ManyToOne(targetEntity=LA_Party.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_PartyID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public LA_Party getParty() {
        return party;
    }
    @Override
    public void setParty(IParty value) {
        this.party = (LA_Party)value;
    }
    
    @Override
    @ManyToOne(targetEntity=LA_BAUnit.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_BAUnitID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public LA_BAUnit getBaunit() {
        return baunit;
    }
    @Override
    public void setBaunit(IBAUnit value) {
        this.baunit = (LA_BAUnit)value;
    }
    
    @ManyToMany(mappedBy="rrr", targetEntity=LA_AdministrativeSource.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_AdministrativeSource> getAdminSources() {
        return adminSources;
    }
    public void setAdminSources(java.util.Set<LA_AdministrativeSource> value) {
        this.adminSources = value;
    }
    
    
    public String toString() {
        return super.toString();
    }
    
}
