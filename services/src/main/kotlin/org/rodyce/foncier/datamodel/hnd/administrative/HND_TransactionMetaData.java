package org.rodyce.foncier.datamodel.hnd.administrative;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_TransactionMetaData", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_TransactionMetaData {
    private HND_MunicipalTransactionType municipalTrxType;
    private boolean canMutateRRR;
    private boolean canSplit;
    private boolean canMerge;
    private boolean canEditData;


    @Id
    @Column(name="MunicipalTrxType", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_MunicipalTransactionType getMunicipalTrxType() {
        return municipalTrxType;
    }
    public void setMunicipalTrxType(HND_MunicipalTransactionType municipalTrxType) {
        this.municipalTrxType = municipalTrxType;
    }
    
    @Column(name="CanMutateRRR", nullable=false)
    public boolean isCanMutateRRR() {
        return canMutateRRR;
    }
    public void setCanMutateRRR(boolean canMutateRRR) {
        this.canMutateRRR = canMutateRRR;
    }

    @Column(name="CanSplit", nullable=false)
    public boolean isCanSplit() {
        return canSplit;
    }
    public void setCanSplit(boolean canSplit) {
        this.canSplit = canSplit;
    }
    
    @Column(name="CanMerge", nullable=false)
    public boolean isCanMerge() {
        return canMerge;
    }
    public void setCanMerge(boolean canMerge) {
        this.canMerge = canMerge;
    }

    @Column(name="CanEditData", nullable=false)
    public boolean isCanEditData() {
        return canEditData;
    }
    public void setCanEditData(boolean canEditData) {
        this.canEditData = canEditData;
    }    
}
