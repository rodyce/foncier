package org.rodyce.foncier.datamodel.ladm.administrative;

import org.rodyce.foncier.datamodel.commons.IRight;
import org.rodyce.foncier.datamodel.ladm.party.LA_Party;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Right", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Right")
@PrimaryKeyJoinColumn(name="LA_RRRID", referencedColumnName="ID")
public class LA_Right extends LA_RRR implements Serializable, IRight<LA_Party, LA_BAUnit> {
    private static final long serialVersionUID = 1L;
    
    private LA_RightType type;
    private java.util.Set<LA_Mortgage> mortgages = new java.util.HashSet<LA_Mortgage>();
    
    public LA_Right() {
    }

    @Override
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_RightType getType() {
        return type;
    }
    public void setType(Enum<?> value) {
        this.type = (LA_RightType) value;
    }
    
    @ManyToMany(mappedBy="rights", targetEntity=LA_Mortgage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_Mortgage> getMortgages() {
        return mortgages;
    }
    public void setMortgages(java.util.Set<LA_Mortgage> value) {
        this.mortgages = value;
    }
    
    
    public String toString() {
        return super.toString();
    }

    @Transient
    @Override
    public int rightHash() {
        return (int)((long)getShare().hashCode() + getExtPID().hashCode() + getType().hashCode());
    }

    
    @Transient
    @Override
    public UUID getExtPID() {
        return getParty().getExtParty().getExtPID();
    }
}
