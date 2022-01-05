package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IBAUnit;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnitType;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="BAUnit", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("BAUnit")
public class BAUnit extends AssociationInfo implements IBAUnit, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID uID;
    private Party baParty;
    private String name;
    private LA_BAUnitType type;
    private java.util.Set<SpatialSource> spatialSources = new java.util.HashSet<SpatialSource>();
    private java.util.Set<RRR> rrr = new java.util.HashSet<RRR>();
    private java.util.Set<RequiredRelationshipBAUnit> baunits1requiredrelationshipbaunits = new java.util.HashSet<RequiredRelationshipBAUnit>();
    private java.util.Set<SpatialUnit> spatialUnits = new java.util.HashSet<SpatialUnit>();
    private java.util.Set<AdministrativeSource> adminSources = new java.util.HashSet<AdministrativeSource>();
    private java.util.Set<RequiredRelationshipBAUnit> baunits2requiredrelationshipbaunits = new java.util.HashSet<RequiredRelationshipBAUnit>();
    
    public BAUnit() {
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
    
    @ManyToMany(targetEntity=SpatialSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="SpatialSource_BAUnit", schema="ladmshadow", joinColumns={ @JoinColumn(name="BAUnitID") }, inverseJoinColumns={ @JoinColumn(name="SpatialSourceSourceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(java.util.Set<SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @OneToMany(mappedBy="baunit", targetEntity=RRR.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<RRR> getRrr() {
        return rrr;
    }
    public void setRrr(java.util.Set<RRR> value) {
        this.rrr = value;
    }
    
    @OneToMany(mappedBy="baunits2baunit", targetEntity=RequiredRelationshipBAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<RequiredRelationshipBAUnit> getBaunits1requiredrelationshipbaunits() {
        return baunits1requiredrelationshipbaunits;
    }
    public void setBaunits1requiredrelationshipbaunits(java.util.Set<RequiredRelationshipBAUnit> value) {
        this.baunits1requiredrelationshipbaunits = value;
    }
    
    @OneToOne(targetEntity=Party.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="PartyID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public Party getBaParty() {
        return baParty;
    }
    public void setBaParty(Party value) {
        this.baParty = value;
    }
    
    @ManyToMany(targetEntity=SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="BAUnit_SpatialUnit", schema="ladmshadow", joinColumns={ @JoinColumn(name="BAUnitID") }, inverseJoinColumns={ @JoinColumn(name="SpatialUnitID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialUnit> getSpatialUnits() {
        return spatialUnits;
    }
    public void setSpatialUnits(java.util.Set<SpatialUnit> value) {
        this.spatialUnits = value;
    }
    
    @ManyToMany(mappedBy="units", targetEntity=AdministrativeSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<AdministrativeSource> getAdminSources() {
        return adminSources;
    }
    public void setAdminSources(java.util.Set<AdministrativeSource> value) {
        this.adminSources = value;
    }
    
    @OneToMany(mappedBy="baunits1baunit", targetEntity=RequiredRelationshipBAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<RequiredRelationshipBAUnit> getBaunits2requiredrelationshipbaunits() {
        return baunits2requiredrelationshipbaunits;
    }
    public void setBaunits2requiredrelationshipbaunits(java.util.Set<RequiredRelationshipBAUnit> value) {
        this.baunits2requiredrelationshipbaunits = value;
    }
    
    
    
    public String toString() {
        return super.toString();
    }
}
