package org.rodyce.foncier.datamodel.ladm.party;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_GroupParty", schema="ladm_party")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_GroupParty")
@PrimaryKeyJoinColumn(name="LA_PartyID", referencedColumnName="ID")
public class LA_GroupParty extends LA_Party implements Serializable {
    private static final long serialVersionUID = 1L;
    private LA_GroupPartyType groupPartyType;
    private Set<LA_PartyMember> partyMembers = new HashSet<LA_PartyMember>();
    
    public LA_GroupParty() {
    }
    
    @Column(name="GroupPartyType", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_GroupPartyType getGroupPartyType() {
        return groupPartyType;
    }
    public void setGroupPartyType(LA_GroupPartyType value) {
        this.groupPartyType = value;
    }
    
    @OneToMany(mappedBy="groupParty", targetEntity=LA_PartyMember.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<LA_PartyMember> getPartyMembers() {
        return partyMembers;
    }
    public void setPartyMembers(Set<LA_PartyMember> value) {
        this.partyMembers = value;
    }
    
    public String toString() {
        return super.toString();
    }
}
