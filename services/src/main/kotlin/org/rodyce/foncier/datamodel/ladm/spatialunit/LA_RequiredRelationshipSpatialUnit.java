package org.rodyce.foncier.datamodel.ladm.spatialunit;

import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_RequiredRelationshipSpatialUnit", schema="ladm_spatialunit")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(LA_RequiredRelationshipSpatialUnitPK.class)
public class LA_RequiredRelationshipSpatialUnit extends VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID spatialUnit1Id;
    private UUID spatialUnit2Id;
    private LA_SpatialUnit spatialUnit1;
    private LA_SpatialUnit spatialUnit2;
    private ISO19125_Type relationship;


    @Id
    @Column(name="LA_SpatialUnitID", nullable=false, insertable=false, updatable=false)
    public UUID getSpatialUnit1Id() {
        return spatialUnit1Id;
    }
    public void setSpatialUnit1Id(UUID value) {
        this.spatialUnit1Id = value;
    }
    
    @Id
    @Column(name="LA_SpatialUnitID2", nullable=false, insertable=false, updatable=false)
    public UUID getSpatialUnit2Id() {
        return spatialUnit2Id;
    }
    public void setSpatialUnit2Id(UUID value) {
        this.spatialUnit2Id = value;
    }
    
    
    @PrimaryKeyJoinColumn
    public LA_SpatialUnit getSpatialUnit1() {
        return spatialUnit1;
    }
    public void setSpatialUnit1(LA_SpatialUnit value) {
        this.spatialUnit1 = value;
    }

    @PrimaryKeyJoinColumn
    public LA_SpatialUnit getSpatialUnit2() {
        return spatialUnit2;
    }
    public void setSpatialUnit2(LA_SpatialUnit value) {
        this.spatialUnit2 = value;
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
        if (!(aObj instanceof LA_RequiredRelationshipSpatialUnit))
            return false;
        LA_RequiredRelationshipSpatialUnit la_requiredrelationshipspatialunit = (LA_RequiredRelationshipSpatialUnit)aObj;
        if (getSpatialUnit1() == null) {
            if (la_requiredrelationshipspatialunit.getSpatialUnit1() != null)
                return false;
        }
        else if (!getSpatialUnit1().equals(la_requiredrelationshipspatialunit.getSpatialUnit1()))
            return false;
        if (getSpatialUnit2() == null) {
            if (la_requiredrelationshipspatialunit.getSpatialUnit2() != null)
                return false;
        }
        else if (!getSpatialUnit2().equals(la_requiredrelationshipspatialunit.getSpatialUnit2()))
            return false;
        return true;
    }
    
    public int hashCode() {
        int hashcode = 0;
        if (getSpatialUnit1() != null) {
            hashcode = hashcode + (int) getSpatialUnit1().getORMID().hashCode();
        }
        if (getSpatialUnit2() != null) {
            hashcode = hashcode + (int) getSpatialUnit2().getORMID().hashCode();
        }
        return hashcode;
    }
    
    public String toString() {
        return super.toString();
    }
}
