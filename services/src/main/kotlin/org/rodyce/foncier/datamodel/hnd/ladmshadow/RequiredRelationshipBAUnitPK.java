package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import javax.persistence.*;

public class RequiredRelationshipBAUnitPK implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private BAUnit baunits2baunit;
    private BAUnit baunits1baunit;

    
    @ManyToOne(targetEntity=BAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="BAUnitID", referencedColumnName="ID") })
    public BAUnit getBaunits1baunit()  {
        return this.baunits1baunit;
    }
    public void setBaunits1baunit(BAUnit value)  {
        this.baunits1baunit =  value;
    }

    @ManyToOne(targetEntity=BAUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="BAUnitID2", referencedColumnName="ID") })
    public BAUnit getBaunits2baunit()  {
        return this.baunits2baunit;
    }
    public void setBaunits2baunit(BAUnit value)  {
        this.baunits2baunit =  value;
    }

    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof RequiredRelationshipBAUnitPK))
            return false;
        RequiredRelationshipBAUnitPK requiredrelationshipbaunitpk = (RequiredRelationshipBAUnitPK)aObj;
        if (getBaunits2baunit() == null) {
            if (requiredrelationshipbaunitpk.getBaunits2baunit() != null)
                return false;
        }
        else if (!getBaunits2baunit().equals(requiredrelationshipbaunitpk.getBaunits2baunit()))
            return false;
        if (getBaunits1baunit() == null) {
            if (requiredrelationshipbaunitpk.getBaunits1baunit() != null)
                return false;
        }
        else if (!getBaunits1baunit().equals(requiredrelationshipbaunitpk.getBaunits1baunit()))
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
}
