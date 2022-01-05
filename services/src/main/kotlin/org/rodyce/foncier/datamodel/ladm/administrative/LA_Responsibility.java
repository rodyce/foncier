package org.rodyce.foncier.datamodel.ladm.administrative;

import org.rodyce.foncier.datamodel.commons.IResponsibility;
import org.rodyce.foncier.datamodel.ladm.party.LA_Party;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Responsibility", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Responsibility")
@PrimaryKeyJoinColumn(name="LA_RRRID", referencedColumnName="ID")
public class LA_Responsibility extends LA_RRR implements Serializable, IResponsibility<LA_Party, LA_BAUnit> {
    private static final long serialVersionUID = 1L;
    
    private LA_ResponsibilityType type;
    
    @Override
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_ResponsibilityType getType() {
        return type;
    }
    public void setType(Enum<?> value) {
        this.type = (LA_ResponsibilityType) value;
    }
    
    public String toString() {
        return super.toString();
    }


    @Transient
    @Override
    public int responsibilitiesHash() {
        return (int)((long)getShare().hashCode() + getExtPID().hashCode() + getType().hashCode());
    }


    @Transient
    @Override
    public UUID getExtPID() {
        return getParty().getExtParty().getExtPID();
    }
    
}
