package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.spatialunit.ISO19125_Type;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="RequiredRelationshipSpatialUnit", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("RequiredRelationship")
@IdClass(RequiredRelationshipSpatialUnitPK.class)
public class RequiredRelationshipSpatialUnit extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID relSpatialUnits1spatialunitId;
    private UUID relSpatialUnits2spatialunitId;
    private SpatialUnit relSpatialUnits1spatialunit;
    private SpatialUnit relSpatialUnits2spatialunit;
    private ISO19125_Type relationship;


    @Id
    @Column(name="SpatialUnitID", nullable=false, insertable=false, updatable=false)
    public UUID getRelSpatialUnits1spatialunitId() {
        return relSpatialUnits1spatialunitId;
    }
    protected void setRelSpatialUnits1spatialunitId(UUID value) {
        this.relSpatialUnits1spatialunitId = value;
    }
    
    @Id
    @Column(name="SpatialUnitID2", nullable=false, insertable=false, updatable=false)
    public UUID getRelSpatialUnits2spatialunitId() {
        return relSpatialUnits2spatialunitId;
    }
    protected void setRelSpatialUnits2spatialunitId(UUID value) {
        this.relSpatialUnits2spatialunitId = value;
    }
    
    @PrimaryKeyJoinColumn
    public SpatialUnit getRelSpatialUnits2spatialunit() {
        return relSpatialUnits2spatialunit;
    }
    public void setRelSpatialUnits2spatialunit(SpatialUnit value) {
        this.relSpatialUnits2spatialunit = value;
    }
    
    @PrimaryKeyJoinColumn
    public SpatialUnit getRelSpatialUnits1spatialunit() {
        return relSpatialUnits1spatialunit;
    }
    public void setRelSpatialUnits1spatialunit(SpatialUnit value) {
        this.relSpatialUnits1spatialunit = value;
    }

    @Column(name="Relationship", nullable=false)
    @Enumerated(EnumType.STRING)
    public ISO19125_Type getRelationship() {
        return relationship;
    }
    public void setRelationship(ISO19125_Type value) {
        this.relationship = value;
    }

    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof RequiredRelationshipSpatialUnit))
            return false;
        RequiredRelationshipSpatialUnit requiredrelationshipspatialunit = (RequiredRelationshipSpatialUnit)aObj;
        if (getRelSpatialUnits1spatialunit() == null) {
            if (requiredrelationshipspatialunit.getRelSpatialUnits1spatialunit() != null)
                return false;
        }
        else if (!getRelSpatialUnits1spatialunit().equals(requiredrelationshipspatialunit.getRelSpatialUnits1spatialunit()))
            return false;
        if (getRelSpatialUnits2spatialunit() == null) {
            if (requiredrelationshipspatialunit.getRelSpatialUnits2spatialunit() != null)
                return false;
        }
        else if (!getRelSpatialUnits2spatialunit().equals(requiredrelationshipspatialunit.getRelSpatialUnits2spatialunit()))
            return false;
        return true;
    }
    
    public int hashCode() {
        int hashcode = 0;
        if (getRelSpatialUnits1spatialunit() != null) {
            hashcode = hashcode + (int) getRelSpatialUnits1spatialunit().getORMID().hashCode();
        }
        if (getRelSpatialUnits2spatialunit() != null) {
            hashcode = hashcode + (int) getRelSpatialUnits2spatialunit().getORMID().hashCode();
        }
        return hashcode;
    }
    
    public String toString() {
        return super.toString();
    }
}
