package org.rodyce.foncier.datamodel.hnd.administrative;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_SpatialZone;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_SpatialZoneInTransaction", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(HND_SpatialZoneInTransactionPK.class)
public class HND_SpatialZoneInTransaction implements Serializable {
    private static final long serialVersionUID = -8681093805861444803L;
    
    private UUID transactionId;
    private UUID spatialZoneId;
    private HND_Transaction transaction;
    private HND_SpatialZone spatialZone;
    private int neighborLevel;


    @Id
    @Column(name="TransactionID", nullable=false, insertable=false, updatable=false)    
    public UUID getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(UUID value) {
        this.transactionId = value;
    }

    @Id    
    @Column(name="SpatialZoneID", nullable=false, insertable=false, updatable=false)
    public UUID getSpatialZoneId() {
        return spatialZoneId;
    }
    public void setSpatialZoneId(UUID spatialZoneId) {
        this.spatialZoneId = spatialZoneId;
    }


    @PrimaryKeyJoinColumn
    public HND_Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(HND_Transaction value) {
        this.transaction = value;
    }

    @PrimaryKeyJoinColumn
    public HND_SpatialZone getSpatialZone() {
        return spatialZone;
    }
    public void setSpatialZone(HND_SpatialZone spatialZone) {
        this.spatialZone = spatialZone;
    }


    @Column(name="NeighborLevel", nullable=false)
    public int getNeighborLevel() {
        return neighborLevel;
    }
    public void setNeighborLevel(int neighborLevel) {
        this.neighborLevel = neighborLevel;
    }


    @Transient
    public boolean isUserRequested() {
        return neighborLevel == 0;
    }
}
