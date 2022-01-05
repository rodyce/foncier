package org.rodyce.foncier.datamodel.ladm.administrative;

import org.rodyce.foncier.datamodel.commons.IRestriction;
import org.rodyce.foncier.datamodel.ladm.party.LA_Party;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Restriction", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Restriction")
@PrimaryKeyJoinColumn(name="LA_RRRID", referencedColumnName="ID")
public class LA_Restriction extends LA_RRR implements Serializable, IRestriction<LA_Party, LA_BAUnit> {
    private static final long serialVersionUID = 1L;
    
    private boolean partyRequired;
    private LA_RestrictionType type;
    
    
    @Column(name="PartyRequired", nullable=false)
    public boolean getPartyRequired() {
        return partyRequired;
    }
    public void setPartyRequired(boolean value) {
        this.partyRequired = value;
    }
    
    @Override
    @Column(name="Type", nullable=true)    
    @Enumerated(EnumType.STRING)
    public LA_RestrictionType getType() {
        return type;
    }
    public void setType(Enum<?> value) {
        this.type = (LA_RestrictionType) value;
    }


    public String toString() {
        return super.toString();
    }


    @Transient
    @Override
    public int restrictionsHash() {
        return (int)((long)getShare().hashCode() + getExtPID().hashCode() + getType().hashCode());
    }

    @Transient
    @Override
    public UUID getExtPID() {
        return getParty().getExtParty().getExtPID();
    }
    
}
