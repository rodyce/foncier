package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import javax.persistence.*;

import org.rodyce.foncier.datamodel.ladm.administrative.LA_AdministrativeSourceType;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_AvailabilityStatusType;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="AdministrativeSource", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("AdministrativeSource")
@PrimaryKeyJoinColumn(name="SourceID", referencedColumnName="ID")
public class AdministrativeSource extends Source implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private LA_AvailabilityStatusType availabilityStatus;
    private java.sql.Clob text;
    private LA_AdministrativeSourceType type;
    private java.util.Set<BAUnit> units = new java.util.HashSet<BAUnit>();
    private java.util.Set<RRR> rrr = new java.util.HashSet<RRR>();
    private java.util.Set<Party> conveyor = new java.util.HashSet<Party>();
    
    public AdministrativeSource() {
    }
    
    
    @Column(name="AvailabilityStatus", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_AvailabilityStatusType getAvailabilityStatus() {
        return availabilityStatus;
    }
    public void setAvailabilityStatus(LA_AvailabilityStatusType value) {
        this.availabilityStatus = value;
    }
    
    @Column(name="Text", nullable=true)
    public java.sql.Clob getText() {
        return text;
    }
    public void setText(java.sql.Clob value) {
        this.text = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_AdministrativeSourceType getType() {
        return type;
    }
    public void setType(LA_AdministrativeSourceType value) {
        this.type = value;
    }
    
    @ManyToMany(targetEntity=BAUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="BAUnit_AdministrativeSource", schema="ladmshadow", joinColumns={ @JoinColumn(name="AdministrativeSourceSourceID") }, inverseJoinColumns={ @JoinColumn(name="BAUnitID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<BAUnit> getUnits() {
        return units;
    }
    public void setUnits(java.util.Set<BAUnit> value) {
        this.units = value;
    }
    
    @ManyToMany(targetEntity=RRR.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="RRR_AdministrativeSource", schema="ladmshadow", joinColumns={ @JoinColumn(name="AdministrativeSourceSourceID") }, inverseJoinColumns={ @JoinColumn(name="RRRID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<RRR> getRrr() {
        return rrr;
    }
    public void setRrr(java.util.Set<RRR> value) {
        this.rrr = value;
    }
    
    @ManyToMany(targetEntity=Party.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Party_AdministrativeSource", schema="ladmshadow", joinColumns={ @JoinColumn(name="AdministrativeSourceSourceID") }, inverseJoinColumns={ @JoinColumn(name="PartyID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<Party> getConveyor() {
        return conveyor;
    }
    public void setConveyor(java.util.Set<Party> value) {
        this.conveyor = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
