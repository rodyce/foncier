package org.rodyce.foncier.datamodel.ladm.party;

import org.rodyce.foncier.datamodel.ladm.special.Rational;
import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_PartyMember", schema="ladm_party")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(LA_PartyMemberPK.class)
public class LA_PartyMember extends VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID partyId;
    private UUID groupPartyId;
    private LA_GroupParty groupParty;
    private LA_Party party;
    private Rational share;

    
    @Id
    @Column(name="LA_PartyID", nullable=false, insertable=false, updatable=false)
    public UUID getPartyId() {
        return partyId;
    }
    protected void setPartyId(UUID value) {
        this.partyId = value;
    }
    
    @Id
    @Column(name="LA_GroupPartyID", nullable=false, insertable=false, updatable=false)
    public UUID getGroupPartyId() {
        return groupPartyId;
    }
    protected void setGroupPartyId(UUID value) {
        this.groupPartyId = value;
    }
    
    
    @PrimaryKeyJoinColumn
    public LA_Party getParty() {
        return party;
    }
    public void setParty(LA_Party value) {
        this.party = value;
    }

    @PrimaryKeyJoinColumn
    public LA_GroupParty getGroupParty() {
        return groupParty;
    }
    public void setGroupParty(LA_GroupParty value) {
        this.groupParty = value;
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

    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof LA_PartyMember))
            return false;
        LA_PartyMember la_partymember = (LA_PartyMember)aObj;
        
        if (getParty() == null) {
            if (la_partymember.getParty() != null)
                return false;
        }
        else if (!getParty().equals(la_partymember.getParty()))
            return false;
        
        if (getGroupParty() == null) {
            if (la_partymember.getGroupParty() != null)
                return false;
        }
        else if (!getGroupParty().equals(la_partymember.getGroupParty()))
            return false;
        return true;
    }
    
    public int hashCode() {
        int hashcode = 0;
        if (getParty() != null) {
            hashcode = hashcode + (int) getParty().getORMID().hashCode();
        }
        if (getGroupParty() != null) {
            hashcode = hashcode + (int) getGroupParty().getORMID().hashCode();
        }
        return hashcode;
    }
    
    
    public String toString() {
        return super.toString();
    }
}
