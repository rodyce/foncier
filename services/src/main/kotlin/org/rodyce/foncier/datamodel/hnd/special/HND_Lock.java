package org.rodyce.foncier.datamodel.hnd.special;

import java.io.Serializable;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_Transaction;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;


@Embeddable
public class HND_Lock implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private HND_LockLevelType lockLevel = HND_LockLevelType.UNLOCKED;
    private HND_Transaction lockingTransaction;
    
    
    @Column(name="LockLevel", nullable=false)
    @Enumerated(value=EnumType.STRING)
    public HND_LockLevelType getLockLevel() {
        return lockLevel;
    }
    public void setLockLevel(HND_LockLevelType lockLevel) {
        this.lockLevel = lockLevel;
    }

    @ManyToOne(targetEntity=HND_Transaction.class, optional=true, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LockingTransactionID", referencedColumnName="id") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_Transaction getLockingTransaction() {
        return lockingTransaction;
    }
    public void setLockingTransaction(HND_Transaction lockingTransaction) {
        this.lockingTransaction = lockingTransaction;
    }
    
    
    
    @Transient
    public boolean isLocked() {
        return lockingTransaction != null;
    }
    @Transient
    public void unlock() {
        lockLevel = HND_LockLevelType.UNLOCKED;
        lockingTransaction = null;
    }


    @Transient
    @PreUpdate
    @PrePersist
    public void setLockLevelState() {
        if (getLockingTransaction() == null) setLockLevel(HND_LockLevelType.UNLOCKED);
    }
        
    public static HND_LockLevelType neighborLevel2LockLevel(int neighborLevel) {
        HND_LockLevelType lockLevel = HND_LockLevelType.UNLOCKED;
        if (neighborLevel == 0)
            lockLevel = HND_LockLevelType.LOCKED_EXPLICIT;
        else if (neighborLevel == 1)
            lockLevel = HND_LockLevelType.LOCKED_IMPLICIT;
        else if (neighborLevel > 1)
            lockLevel = HND_LockLevelType.LOCKED_IMPLICIT_2;
        
        return lockLevel;
    }

}
