package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class PartyMemberPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private Party party;
    private GroupParty groupParty;
    
    
    @ManyToOne(targetEntity=Party.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="PartyID", referencedColumnName="ID") })
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
    }
    
    @ManyToOne(targetEntity=GroupParty.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="GroupPartyID", referencedColumnName="PartyID") })
    public GroupParty getGroupParty() {
        return groupParty;
    }
    public void setGroupParty(GroupParty groupParty) {
        this.groupParty = groupParty;
    }

    
    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof PartyMemberPK))
            return false;
        PartyMemberPK partymemberpk = (PartyMemberPK)aObj;
        if (getParty() == null) {
            if (partymemberpk.getParty() != null)
                return false;
        }
        else if (!getParty().equals(partymemberpk.getParty()))
            return false;
        if (getGroupParty() == null) {
            if (partymemberpk.getGroupParty() != null)
                return false;
        }
        else if (!getGroupParty().equals(partymemberpk.getGroupParty()))
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
}
