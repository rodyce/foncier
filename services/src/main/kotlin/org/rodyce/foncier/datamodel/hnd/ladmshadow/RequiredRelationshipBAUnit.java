package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="RequiredRelationshipBAUnit", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(RequiredRelationshipBAUnitPK.class)
public class RequiredRelationshipBAUnit extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID baunits2baunitId;
    private UUID baunits1baunitId;
    private BAUnit baunits2baunit;
    private BAUnit baunits1baunit;
    private String relationship;

    
    @Id
    @Column(name="BAUnitID", nullable=false, insertable=false, updatable=false)
    public UUID getBaunits1baunitId() {
        return baunits1baunitId;
    }
    protected void setBaunits1baunitId(UUID value) {
        this.baunits1baunitId = value;
    }

    @Id
    @Column(name="BAUnitID2", nullable=false, insertable=false, updatable=false)
    public UUID getBaunits2baunitId() {
        return baunits2baunitId;
    }
    protected void setBaunits2baunitId(UUID value) {
        this.baunits2baunitId = value;
    }
    
    
    @PrimaryKeyJoinColumn
    public BAUnit getBaunits1baunit() {
        return baunits1baunit;
    }
    public void setBaunits1baunit(BAUnit value) {
        this.baunits1baunit = value;
    }
    
    @PrimaryKeyJoinColumn
    public BAUnit getBaunits2baunit() {
        return baunits2baunit;
    }
    public void setBaunits2baunit(BAUnit value) {
        this.baunits2baunit = value;
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
        if (!(aObj instanceof RequiredRelationshipBAUnit))
            return false;
        RequiredRelationshipBAUnit requiredrelationshipbaunit = (RequiredRelationshipBAUnit)aObj;
        if (getBaunits2baunit() == null) {
            if (requiredrelationshipbaunit.getBaunits2baunit() != null)
                return false;
        }
        else if (!getBaunits2baunit().equals(requiredrelationshipbaunit.getBaunits2baunit()))
            return false;
        if (getBaunits1baunit() == null) {
            if (requiredrelationshipbaunit.getBaunits1baunit() != null)
                return false;
        }
        else if (!getBaunits1baunit().equals(requiredrelationshipbaunit.getBaunits1baunit()))
            return false;
        return true;
    }
    
    public int hashCode() {
        int hashcode = 0;
        if (getBaunits2baunit() != null) {
            hashcode = hashcode + (int) getBaunits2baunit().getORMID().hashCode();
        }
        if (getBaunits1baunit() != null) {
            hashcode = hashcode + (int) getBaunits1baunit().getORMID().hashCode();
        }
        return hashcode;
    }
    
    public String toString() {
        return super.toString();
    }
    
    private boolean _saved = false;
    
    public void onSave() {
        _saved=true;
    }
    
    
    public void onLoad() {
        _saved=true;
    }
    
    
    @Transient
    public boolean isSaved() {
        return _saved;
    }
    
    
}
