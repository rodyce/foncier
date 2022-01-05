package org.rodyce.foncier.datamodel.ladm.spatialunit;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class LA_RequiredRelationshipSpatialUnitPK implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LA_SpatialUnit spatialUnit1;
    private LA_SpatialUnit spatialUnit2;
    
    
    @ManyToOne(targetEntity=LA_SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_SpatialUnitID", referencedColumnName="ID") })
    public LA_SpatialUnit getSpatialUnit1()  {
        return this.spatialUnit1;
    }
    public void setSpatialUnit1(LA_SpatialUnit value)  {
        this.spatialUnit1 =  value;
    }

    @ManyToOne(targetEntity=LA_SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_SpatialUnitID2", referencedColumnName="ID") })
    public LA_SpatialUnit getSpatialUnit2()  {
        return this.spatialUnit2;
    }
    public void setSpatialUnit2(LA_SpatialUnit value)  {
        this.spatialUnit2 =  value;
    }
    
    
    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof LA_RequiredRelationshipSpatialUnitPK))
            return false;
        LA_RequiredRelationshipSpatialUnitPK la_requiredrelationshipspatialunitpk = (LA_RequiredRelationshipSpatialUnitPK)aObj;
        if (getSpatialUnit1() == null) {
            if (la_requiredrelationshipspatialunitpk.getSpatialUnit1() != null)
                return false;
        }
        else if (!getSpatialUnit1().equals(la_requiredrelationshipspatialunitpk.getSpatialUnit1()))
            return false;
        
        if (getSpatialUnit2() == null) {
            if (la_requiredrelationshipspatialunitpk.getSpatialUnit2() != null)
                return false;
        }
        else if (!getSpatialUnit2().equals(la_requiredrelationshipspatialunitpk.getSpatialUnit2()))
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
}
