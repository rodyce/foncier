package org.rodyce.foncier.datamodel.ladm.party;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class LA_PartyMemberPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private LA_Party party;
    private LA_GroupParty groupParty;
    
    
    @ManyToOne(targetEntity=LA_Party.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_PartyID", referencedColumnName="ID") })
    public LA_Party getParty() {
        return party;
    }
    public void setParty(LA_Party party) {
        this.party = party;
    }

    @ManyToOne(targetEntity=LA_GroupParty.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_GroupPartyID", referencedColumnName="LA_PartyID") })
    public LA_GroupParty getGroupParty() {
        return groupParty;
    }
    public void setGroupParty(LA_GroupParty groupParty) {
        this.groupParty = groupParty;
    }


    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof LA_PartyMemberPK))
            return false;
        LA_PartyMemberPK la_partymemberpk = (LA_PartyMemberPK)aObj;
        if (getParty() == null) {
            if (la_partymemberpk.getParty() != null)
                return false;
        }
        else if (!getParty().equals(la_partymemberpk.getParty()))
            return false;
        if (getGroupParty() == null) {
            if (la_partymemberpk.getGroupParty() != null)
                return false;
        }
        else if (!getGroupParty().equals(la_partymemberpk.getGroupParty()))
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
