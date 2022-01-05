package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.party.LA_GroupPartyType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="GroupParty", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("GroupParty")
@PrimaryKeyJoinColumn(name="PartyID", referencedColumnName="ID")
public class GroupParty extends Party implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LA_GroupPartyType groupPartyType;
    private Set<PartyMember> partyMembers = new HashSet<PartyMember>();
    
    public GroupParty() {
    }
    
    @Column(name="GroupPartyType", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_GroupPartyType getGroupPartyType() {
        return groupPartyType;
    }
    public void setGroupPartyType(LA_GroupPartyType value) {
        this.groupPartyType = value;
    }
    
    @OneToMany(mappedBy="groupParty", targetEntity=PartyMember.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<PartyMember> getPartyMembers() {
        return partyMembers;
    }
    public void setPartyMembers(Set<PartyMember> value) {
        this.partyMembers = value;
    }
    
    public String toString() {
        return super.toString();
    }
}
