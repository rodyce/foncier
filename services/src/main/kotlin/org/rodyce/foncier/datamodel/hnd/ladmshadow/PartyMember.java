package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.special.Rational;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="PartyMember", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(PartyMemberPK.class)
public class PartyMember extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID partyId;
    private UUID groupPartyId;
    private GroupParty groupParty;
    private Party party;
    private Rational share;

    
    @Id
    @Column(name="PartyID", nullable=false, insertable=false, updatable=false)
    public UUID getPartyId() {
        return partyId;
    }
    protected void setPartyId(UUID value) {
        this.partyId = value;
    }
    
    @Id
    @Column(name="GroupPartyPartyID", nullable=false, insertable=false, updatable=false)
    public UUID getGrouppartyId() {
        return groupPartyId;
    }
    protected void setGrouppartyId(UUID value) {
        this.groupPartyId = value;
    }
    
    @PrimaryKeyJoinColumn
    public GroupParty getGroupParty() {
        return groupParty;
    }
    public void setGroupParty(GroupParty value) {
        this.groupParty = value;
    }
    
    @PrimaryKeyJoinColumn
    public Party getParty() {
        return party;
    }
    public void setParty(Party value) {
        this.party = value;
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
        if (!(aObj instanceof PartyMember))
            return false;
        PartyMember partymember = (PartyMember)aObj;
        if (getParty() == null) {
            if (partymember.getParty() != null)
                return false;
        }
        else if (!getParty().equals(partymember.getParty()))
            return false;
        if (getGroupParty() == null) {
            if (partymember.getGroupParty() != null)
                return false;
        }
        else if (!getGroupParty().equals(partymember.getGroupParty()))
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
