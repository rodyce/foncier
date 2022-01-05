package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.IResponsibility;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_ResponsibilityType;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Responsibility", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Responsibility")
@PrimaryKeyJoinColumn(name="RRRID", referencedColumnName="ID")
public class Responsibility extends RRR implements Serializable, Cloneable, IResponsibility<Party, BAUnit> {
    private static final long serialVersionUID = 1L;
    
    private LA_ResponsibilityType type;
    
    protected Responsibility() {
    }

    public static Responsibility newResponsibility(UUID ladmId, long presentationNo, boolean isReadOnly, boolean isSnapshot) {
        Responsibility responsibility = new Responsibility();
        
        responsibility.setLadmId(ladmId);
        responsibility.setPresentationNo(presentationNo);
        responsibility.setReadOnly(isReadOnly);
        responsibility.setSnapshot(isSnapshot);
        
        return responsibility;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_ResponsibilityType getType() {
        return type;
    }
    public void setType(Enum<?> value) {
        this.type = (LA_ResponsibilityType) value;
    }
    
    
    @Override
    public Responsibility clone() {
        Responsibility clonedResponsibility = (Responsibility) super.clone();
        
        clonedResponsibility.setType(type);
        
        return clonedResponsibility;
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
