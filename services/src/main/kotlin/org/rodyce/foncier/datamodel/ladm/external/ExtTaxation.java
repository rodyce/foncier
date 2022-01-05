package org.rodyce.foncier.datamodel.ladm.external;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ExtTaxation extends org.rodyce.foncier.datamodel.ladm.special.VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.math.BigDecimal amount;
    private java.util.Date taxDate;
    private org.rodyce.foncier.datamodel.ladm.external.ExtTaxType taxType;
    
    
    @Column(name="Amount", nullable=true, precision=19, scale=0)
    public java.math.BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(java.math.BigDecimal value) {
        this.amount = value;
    }
    
    @Column(name="TaxDate", nullable=true)
    public java.util.Date getTaxDate() {
        return taxDate;
    }
    public void setTaxDate(java.util.Date value) {
        this.taxDate = value;
    }
    
    @Column(name="TaxType", nullable=true)
    public org.rodyce.foncier.datamodel.ladm.external.ExtTaxType getTaxType() {
        return taxType;
    }
    public void setTaxType(org.rodyce.foncier.datamodel.ladm.external.ExtTaxType value) {
        this.taxType = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
