package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.IRestriction;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_RestrictionType;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Restriction", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Restriction")
@PrimaryKeyJoinColumn(name="RRRID", referencedColumnName="ID")
public class Restriction extends RRR implements Serializable, Cloneable, IRestriction<Party, BAUnit> {
    private static final long serialVersionUID = 1L;
    
    private boolean partyRequired;
    private LA_RestrictionType type;
    
    protected Restriction() {
    }
    
    public static Restriction newRestriction(UUID ladmId, long presentationNo, boolean isReadOnly, boolean isSnapshot) {
        Restriction restriction = new Restriction();
        
        restriction.setLadmId(ladmId);
        restriction.setPresentationNo(presentationNo);
        restriction.setReadOnly(isReadOnly);
        restriction.setSnapshot(isSnapshot);
        
        return restriction;
    }
    
    @Column(name="PartyRequired", nullable=false)
    public boolean getPartyRequired() {
        return partyRequired;
    }
    public void setPartyRequired(boolean value) {
        this.partyRequired = value;
    }
    
    @Column(name="Type", nullable=true)    
    @Enumerated(EnumType.STRING)
    public LA_RestrictionType getType() {
        return type;
    }
    public void setType(Enum<?> value) {
        this.type = (LA_RestrictionType) value;
    }
    
    @Override
    public Restriction clone() {
        Restriction clonedRestriction = (Restriction) super.clone();
        
        clonedRestriction.setPartyRequired(partyRequired);
        clonedRestriction.setType(type);
        
        return clonedRestriction;
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
