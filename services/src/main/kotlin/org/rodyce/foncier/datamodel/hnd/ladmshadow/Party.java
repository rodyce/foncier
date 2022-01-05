package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IParty;
import org.rodyce.foncier.datamodel.ladm.external.ExtParty;
import org.rodyce.foncier.datamodel.ladm.party.LA_PartyRoleType;
import org.rodyce.foncier.datamodel.ladm.party.LA_PartyType;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Party", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Party")
public class Party extends AssociationInfo implements IParty, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID pID;
    private String name;
    public ExtParty extParty;
    private LA_PartyRoleType role;
    private LA_PartyType type;
    private Set<SpatialSource> spatialSources = new HashSet<SpatialSource>();
    private Set<PartyMember> partymembers = new HashSet<PartyMember>();
    private Set<RRR> rrr = new HashSet<RRR>();
    private Set<Source> sources = new HashSet<Source>();
    private BAUnit baUnit;
    private Set<Mortgage> mortgages = new HashSet<Mortgage>();
    private Set<AdministrativeSource> adminSources = new HashSet<AdministrativeSource>();
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getpID() {
        return pID;
    }
    protected void setpID(UUID value) {
        this.pID = value;
    }
    @Transient
    public UUID getORMID() {
        return getpID();
    }
    
    @OneToOne(targetEntity=ExtParty.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="ExtPartyID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public ExtParty getExtParty() {
        return extParty;
    }
    public void setExtParty(ExtParty extParty) {
        this.extParty = extParty;
    }

    @Column(name="Name", nullable=true, length=255)
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    
    @Column(name="Role", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_PartyRoleType getRole() {
        return role;
    }
    public void setRole(LA_PartyRoleType value) {
        this.role = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_PartyType getType() {
        return type;
    }
    public void setType(LA_PartyType value) {
        this.type = value;
    }
    
    @ManyToMany(targetEntity=SpatialSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="SpatialSource_Party", schema="ladmshadow", joinColumns={ @JoinColumn(name="PartyID") }, inverseJoinColumns={ @JoinColumn(name="SpatialSourceSourceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(Set<SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @OneToMany(mappedBy="party", targetEntity=PartyMember.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<PartyMember> getpartymembers() {
        return partymembers;
    }
    public void setpartymembers(Set<PartyMember> value) {
        this.partymembers = value;
    }
    
    @OneToMany(mappedBy="party", targetEntity=RRR.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<RRR> getRrr() {
        return rrr;
    }
    public void setRrr(Set<RRR> value) {
        this.rrr = value;
    }
    
    @OneToMany(mappedBy="party", targetEntity=Source.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<Source> getSources() {
        return sources;
    }
    public void setSources(Set<Source> value) {
        this.sources = value;
    }
    
    @OneToOne(mappedBy="baParty", targetEntity=BAUnit.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public BAUnit getBaUnit() {
        return baUnit;
    }
    public void setBaUnit(BAUnit value) {
        this.baUnit = value;
    }
    
    @ManyToMany(mappedBy="moneyProvider", targetEntity=Mortgage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<Mortgage> getMortgages() {
        return mortgages;
    }
    public void setMortgages(Set<Mortgage> value) {
        this.mortgages = value;
    }
    
    @ManyToMany(mappedBy="conveyor", targetEntity=AdministrativeSource.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<AdministrativeSource> getAdminSources() {
        return adminSources;
    }
    public void setAdminSources(Set<AdministrativeSource> value) {
        this.adminSources = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
