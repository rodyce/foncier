package org.rodyce.foncier.datamodel.hnd.administrative;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_SpatialZone;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class HND_SpatialZoneInTransactionPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private HND_Transaction transaction;
    private HND_SpatialZone spatialZone;


    @ManyToOne(targetEntity=HND_Transaction.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="TransactionID", referencedColumnName="ID") })
    public HND_Transaction getTransaction()  {
        return this.transaction;
    }
    public void setTransaction(HND_Transaction value)  {
        this.transaction =  value;
    }
    
    @ManyToOne(targetEntity=HND_SpatialZone.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="SpatialZoneID", referencedColumnName="LA_SpatialUnitID") })
    public HND_SpatialZone getSpatialZone()  {
        return this.spatialZone;
    }
    public void setSpatialZone(HND_SpatialZone spatialZone)  {
        this.spatialZone = spatialZone;
    }
    

    @Override
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof HND_SpatialZoneInTransactionPK))
            return false;
        HND_SpatialZoneInTransactionPK hnd_spatialzoneintransactionpk = (HND_SpatialZoneInTransactionPK)aObj;
        if (getTransaction() == null) {
            if (hnd_spatialzoneintransactionpk.getTransaction() != null)
                return false;
        }
        else if (!getTransaction().equals(hnd_spatialzoneintransactionpk.getTransaction()))
            return false;
        if (getSpatialZone() == null) {
            if (hnd_spatialzoneintransactionpk.getSpatialZone() != null)
                return false;
        }
        else if (!getSpatialZone().equals(hnd_spatialzoneintransactionpk.getSpatialZone()))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashcode = 0;
        if (getTransaction() != null) {
            hashcode = (int) (hashcode + getTransaction().getORMID().hashCode());
        }
        if (getSpatialZone() != null) {
            hashcode = hashcode + (int) getSpatialZone().getORMID().hashCode();
        }
        return hashcode;
    }
}
