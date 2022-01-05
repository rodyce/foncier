package org.rodyce.foncier.datamodel.hnd.special;

import javax.persistence.Column;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_MunicipalTransactionType;

public class MunicipalTransactionToolbox {
    private HND_MunicipalTransactionType transactionType;
    private boolean showRRR;
    private boolean showMerge;
    private boolean showSplit;
    private boolean showData;
    
    
    public HND_MunicipalTransactionType getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(HND_MunicipalTransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
    @Column(name="ShowRRR", nullable=false)
    public boolean isShowRRR() {
        return showRRR;
    }
    public void setShowRRR(boolean showRRR) {
        this.showRRR = showRRR;
    }
    
    @Column(name="ShowMerge", nullable=false)
    public boolean isShowMerge() {
        return showMerge;
    }
    public void setShowMerge(boolean showMerge) {
        this.showMerge = showMerge;
    }
    
    @Column(name="ShowSplit", nullable=false)
    public boolean isShowSplit() {
        return showSplit;
    }
    public void setShowSplit(boolean showSplit) {
        this.showSplit = showSplit;
    }
    
    @Column(name="ShowData", nullable=false)
    public boolean isShowData() {
        return showData;
    }
    public void setShowData(boolean showData) {
        this.showData = showData;
    }
}
