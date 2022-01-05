package org.rodyce.foncier.datamodel.ladm.administrative;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IBAUnit;
import org.rodyce.foncier.datamodel.ladm.party.LA_Party;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_SpatialSource;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit;
import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_BAUnit", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_BAUnit")
public class LA_BAUnit extends VersionedObject implements IBAUnit, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID uID;
    private LA_Party baParty;
    private String name;
    private LA_BAUnitType type;
    private java.util.Set<LA_SpatialSource> spatialSources = new java.util.HashSet<LA_SpatialSource>();
    private java.util.Set<LA_RRR> rrr = new java.util.HashSet<LA_RRR>();
    private java.util.Set<LA_RequiredRelationshipBAUnit> baunits1La_requiredrelationshipbaunits = new java.util.HashSet<LA_RequiredRelationshipBAUnit>();
    private java.util.Set<LA_SpatialUnit> spatialUnits = new java.util.HashSet<LA_SpatialUnit>();
    private java.util.Set<LA_AdministrativeSource> adminSources = new java.util.HashSet<LA_AdministrativeSource>();
    private java.util.Set<LA_RequiredRelationshipBAUnit> baunits2La_requiredrelationshipbaunits = new java.util.HashSet<LA_RequiredRelationshipBAUnit>();
    
    public LA_BAUnit() {
    }
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getuID() {
        return uID;
    }
    public void setuID(UUID value) {
        this.uID = value;
    }
    @Transient
    public UUID getORMID() {
        return getuID();
    }
    
    @Column(name="Name", nullable=true, length=255)
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_BAUnitType getType() {
        return type;
    }
    public void setType(LA_BAUnitType value) {
        this.type = value;
    }
    
    @ManyToMany(targetEntity=LA_SpatialSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="LA_SpatialSource_LA_BAUnit", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_BAUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_SpatialSourceLA_SourceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(java.util.Set<LA_SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @OneToMany(mappedBy="baunit", targetEntity=LA_RRR.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_RRR> getRrr() {
        return rrr;
    }
    public void setRrr(java.util.Set<LA_RRR> value) {
        this.rrr = value;
    }
    
    @OneToMany(mappedBy="baunits2La_baunit", targetEntity=LA_RequiredRelationshipBAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_RequiredRelationshipBAUnit> getBaunits1La_requiredrelationshipbaunits() {
        return baunits1La_requiredrelationshipbaunits;
    }
    public void setBaunits1La_requiredrelationshipbaunits(java.util.Set<LA_RequiredRelationshipBAUnit> value) {
        this.baunits1La_requiredrelationshipbaunits = value;
    }
    
    @OneToOne(targetEntity=org.rodyce.foncier.datamodel.ladm.party.LA_Party.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_PartyID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public org.rodyce.foncier.datamodel.ladm.party.LA_Party getBaParty() {
        return baParty;
    }
    public void setBaParty(org.rodyce.foncier.datamodel.ladm.party.LA_Party value) {
        this.baParty = value;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @ManyToMany(targetEntity=LA_SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="LA_BAUnit_LA_SpatialUnit", schema="ladm_administrative", joinColumns={ @JoinColumn(name="LA_BAUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_SpatialUnitID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<LA_SpatialUnit> getSpatialUnits() {
        return spatialUnits;
    }
    public void setSpatialUnits(java.util.Set<LA_SpatialUnit> value) {
        this.spatialUnits = value;
    }
    
    @ManyToMany(mappedBy="units", targetEntity=LA_AdministrativeSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_AdministrativeSource> getAdminSources() {
        return adminSources;
    }
    public void setAdminSources(java.util.Set<LA_AdministrativeSource> value) {
        this.adminSources = value;
    }
    
    @OneToMany(mappedBy="baunits1La_baunit", targetEntity=LA_RequiredRelationshipBAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_RequiredRelationshipBAUnit> getBaunits2La_requiredrelationshipbaunits() {
        return baunits2La_requiredrelationshipbaunits;
    }
    public void setBaunits2La_requiredrelationshipbaunits(java.util.Set<LA_RequiredRelationshipBAUnit> value) {
        this.baunits2La_requiredrelationshipbaunits = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
