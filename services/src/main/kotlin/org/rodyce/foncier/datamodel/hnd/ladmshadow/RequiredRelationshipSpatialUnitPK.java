package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class RequiredRelationshipSpatialUnitPK implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private SpatialUnit relSpatialUnits1spatialunit;
    private SpatialUnit relSpatialUnits2spatialunit;
    

    @ManyToOne(targetEntity=SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="SpatialUnitID", referencedColumnName="ID") })
    public SpatialUnit getRelSpatialUnits1spatialunit()  {
        return this.relSpatialUnits1spatialunit;
    }
    public void setRelSpatialUnits1spatialunit(SpatialUnit value)  {
        this.relSpatialUnits1spatialunit =  value;
    }
    
    
    @ManyToOne(targetEntity=SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="SpatialUnitID2", referencedColumnName="ID") })
    public SpatialUnit getRelSpatialUnits2spatialunit()  {
        return this.relSpatialUnits2spatialunit;
    }
    public void setRelSpatialUnits2spatialunit(SpatialUnit value)  {
        this.relSpatialUnits2spatialunit =  value;
    }
    

    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof RequiredRelationshipSpatialUnitPK))
            return false;
        RequiredRelationshipSpatialUnitPK requiredrelationshipspatialunitpk = (RequiredRelationshipSpatialUnitPK)aObj;
        if (getRelSpatialUnits1spatialunit() == null) {
            if (requiredrelationshipspatialunitpk.getRelSpatialUnits1spatialunit() != null)
                return false;
        }
        else if (!getRelSpatialUnits1spatialunit().equals(requiredrelationshipspatialunitpk.getRelSpatialUnits1spatialunit()))
            return false;
        if (getRelSpatialUnits2spatialunit() == null) {
            if (requiredrelationshipspatialunitpk.getRelSpatialUnits2spatialunit() != null)
                return false;
        }
        else if (!getRelSpatialUnits2spatialunit().equals(requiredrelationshipspatialunitpk.getRelSpatialUnits2spatialunit()))
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
}
