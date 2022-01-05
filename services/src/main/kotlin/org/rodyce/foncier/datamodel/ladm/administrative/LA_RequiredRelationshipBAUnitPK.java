package org.rodyce.foncier.datamodel.ladm.administrative;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class LA_RequiredRelationshipBAUnitPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private LA_BAUnit baunits1La_baunit;
    private LA_BAUnit baunits2La_baunit;


    @ManyToOne(targetEntity=LA_BAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_BAUnitID", referencedColumnName="ID") })
    public LA_BAUnit getBaunits1La_baunit()  {
        return this.baunits1La_baunit;
    }
    public void setBaunits1La_baunit(LA_BAUnit value)  {
        this.baunits1La_baunit =  value;
    }

    @ManyToOne(targetEntity=org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_BAUnitID2", referencedColumnName="ID") })
    public LA_BAUnit getBaunits2La_baunit()  {
        return this.baunits2La_baunit;
    }
    public void setBaunits2La_baunit(LA_BAUnit value)  {
        this.baunits2La_baunit =  value;
    }

    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof LA_RequiredRelationshipBAUnitPK))
            return false;
        LA_RequiredRelationshipBAUnitPK la_requiredrelationshipbaunitpk = (LA_RequiredRelationshipBAUnitPK)aObj;
        if (getBaunits2La_baunit() == null) {
            if (la_requiredrelationshipbaunitpk.getBaunits2La_baunit() != null)
                return false;
        }
        else if (!getBaunits2La_baunit().equals(la_requiredrelationshipbaunitpk.getBaunits2La_baunit()))
            return false;
        if (getBaunits1La_baunit() == null) {
            if (la_requiredrelationshipbaunitpk.getBaunits1La_baunit() != null)
                return false;
        }
        else if (!getBaunits1La_baunit().equals(la_requiredrelationshipbaunitpk.getBaunits1La_baunit()))
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
}
