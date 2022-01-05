package org.rodyce.foncier.datamodel.ladm.party;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.IParty;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_SpatialSource;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_RRR;
import org.rodyce.foncier.datamodel.ladm.special.LA_Source;
import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_Mortgage;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_AdministrativeSource;
import org.rodyce.foncier.datamodel.ladm.external.ExtParty;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Party", schema="ladm_party")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Party")
public class LA_Party extends VersionedObject implements IParty, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID pID;
    private String name;
    private ExtParty extParty;
    private LA_PartyRoleType role;
    private LA_PartyType type;
    private Set<LA_SpatialSource> spatialSources = new java.util.HashSet<LA_SpatialSource>();
    private Set<LA_PartyMember> partyMembers = new java.util.HashSet<LA_PartyMember>();
    private Set<LA_RRR> rrr = new java.util.HashSet<LA_RRR>();
    private Set<LA_Source> sources = new java.util.HashSet<LA_Source>();
    private org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit baUnit;
    private Set<LA_Mortgage> mortgages = new java.util.HashSet<LA_Mortgage>();
    private Set<LA_AdministrativeSource> adminSources = new java.util.HashSet<LA_AdministrativeSource>();
    
    public LA_Party() {
    }
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getpID() {
        return pID;
    }
    public void setpID(UUID value) {
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
    
    @ManyToMany(targetEntity=LA_SpatialSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="LA_SpatialSource_LA_Party", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_PartyID") }, inverseJoinColumns={ @JoinColumn(name="LA_SpatialSourceLA_SourceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<LA_SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(Set<LA_SpatialSource> value) {
        this.spatialSources = value;
    }
    
    
    @OneToMany(mappedBy="party", targetEntity=LA_PartyMember.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<LA_PartyMember> getPartyMembers() {
        return partyMembers;
    }
    public void setPartyMembers(Set<LA_PartyMember> value) {
        this.partyMembers = value;
    }
    
    @OneToMany(mappedBy="party", targetEntity=LA_RRR.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<LA_RRR> getRrr() {
        return rrr;
    }
    public void setRrr(Set<LA_RRR> value) {
        this.rrr = value;
    }
    
    @OneToMany(mappedBy="party", targetEntity=LA_Source.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<LA_Source> getSources() {
        return sources;
    }
    public void setSources(Set<LA_Source> value) {
        this.sources = value;
    }
    
    @OneToOne(mappedBy="baParty", targetEntity=org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.PROXY)    
    public LA_BAUnit getBaUnit() {
        return baUnit;
    }
    public void setBaUnit(LA_BAUnit value) {
        this.baUnit = value;
    }
    
    @ManyToMany(mappedBy="moneyProvider", targetEntity=LA_Mortgage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<LA_Mortgage> getMortgages() {
        return mortgages;
    }
    public void setMortgages(Set<LA_Mortgage> value) {
        this.mortgages = value;
    }
    
    @ManyToMany(mappedBy="conveyor", targetEntity=LA_AdministrativeSource.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<LA_AdministrativeSource> getAdminSources() {
        return adminSources;
    }
    public void setAdminSources(Set<LA_AdministrativeSource> value) {
        this.adminSources = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
