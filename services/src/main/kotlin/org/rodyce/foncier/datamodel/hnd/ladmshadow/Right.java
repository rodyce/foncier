package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.IRight;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_RightType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Right", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Right")
@PrimaryKeyJoinColumn(name="RRRID", referencedColumnName="ID")
public class Right extends RRR implements Serializable, Cloneable, IRight<Party, BAUnit> {
    private static final long serialVersionUID = 1L;
    
    private LA_RightType type;
    private java.util.Set<Mortgage> mortgages = new java.util.HashSet<Mortgage>();
    
    protected Right() {
    }

    public static Right newRight(UUID ladmId, long presentationNo, boolean isReadOnly, boolean isSnapshot) {
        Right right = new Right();
        
        right.setLadmId(ladmId);
        right.setPresentationNo(presentationNo);
        right.setReadOnly(isReadOnly);
        right.setSnapshot(isSnapshot);
        
        return right;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_RightType getType() {
        return type;
    }
    public void setType(Enum<?> value) {
        this.type = (LA_RightType) value;
    }
    
    @ManyToMany(mappedBy="rights", targetEntity=Mortgage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<Mortgage> getMortgages() {
        return mortgages;
    }
    public void setMortgages(java.util.Set<Mortgage> value) {
        this.mortgages = value;
    }
    
    public Right clone() {
        Right clonedRight = (Right) super.clone();
        
        clonedRight.setType(type);
        //TODO: !!! Ver si clonar cada mortgage individualmente
        clonedRight.setMortgages(new HashSet<Mortgage>(mortgages));
        
        return clonedRight;
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
