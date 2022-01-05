package org.rodyce.foncier.datamodel.ladm.administrative;

import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_RequiredRelationshipBAUnit", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(LA_RequiredRelationshipBAUnitPK.class)
public class LA_RequiredRelationshipBAUnit extends VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID baunits1La_baunitId;
    private UUID baunits2La_baunitId;
    private LA_BAUnit baunits1La_baunit;
    private LA_BAUnit baunits2La_baunit;
    private String relationship;

    
    @Id
    @Column(name="LA_BAUnitID", nullable=false, insertable=false, updatable=false)
    public UUID getBaunits1La_baunitId() {
        return baunits1La_baunitId;
    }
    protected void setBaunits1La_baunitId(UUID value) {
        this.baunits1La_baunitId = value;
    }
    
    @Id
    @Column(name="LA_BAUnitID2", nullable=false, insertable=false, updatable=false)
    public UUID getBaunits2La_baunitId() {
        return baunits2La_baunitId;
    }
    protected void setBaunits2La_baunitId(UUID value) {
        this.baunits2La_baunitId = value;
    }

    
    @PrimaryKeyJoinColumn
    public LA_BAUnit getBaunits1La_baunit() {
        return baunits1La_baunit;
    }
    public void setBaunits1La_baunit(LA_BAUnit value) {
        this.baunits1La_baunit = value;
    }
    
    @PrimaryKeyJoinColumn
    public LA_BAUnit getBaunits2La_baunit() {
        return baunits2La_baunit;
    }
    public void setBaunits2La_baunit(LA_BAUnit value) {
        this.baunits2La_baunit = value;
    }
    
    @Column(name="Relationship", nullable=true, length=255)
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String value) {
        this.relationship = value;
    }

    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof LA_RequiredRelationshipBAUnit))
            return false;
        LA_RequiredRelationshipBAUnit la_requiredrelationshipbaunit = (LA_RequiredRelationshipBAUnit)aObj;
        if (getBaunits2La_baunit() == null) {
            if (la_requiredrelationshipbaunit.getBaunits2La_baunit() != null)
                return false;
        }
        else if (!getBaunits2La_baunit().equals(la_requiredrelationshipbaunit.getBaunits2La_baunit()))
            return false;
        if (getBaunits1La_baunit() == null) {
            if (la_requiredrelationshipbaunit.getBaunits1La_baunit() != null)
                return false;
        }
        else if (!getBaunits1La_baunit().equals(la_requiredrelationshipbaunit.getBaunits1La_baunit()))
            return false;
        return true;
    }
    
    public int hashCode() {
        int hashcode = 0;
        if (getBaunits1La_baunit() != null) {
            hashcode = hashcode + (int) getBaunits1La_baunit().getORMID().hashCode();
        }
        if (getBaunits2La_baunit() != null) {
            hashcode = hashcode + (int) getBaunits2La_baunit().getORMID().hashCode();
        }
        return hashcode;
    }
    
    public String toString() {
        return super.toString();
    }
}
