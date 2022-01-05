package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ExtValuation extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    public ExtValuation() {
    }
    
    private java.math.BigDecimal value;
    private java.util.Date valueDate;
    private org.rodyce.foncier.datamodel.ladm.external.ExtValuationType valueType;


    @Column(name="Value", nullable=true, precision=19, scale=0)
    public java.math.BigDecimal getValue() {
        return value;
    }
    public void setValue(java.math.BigDecimal value) {
        this.value = value;
    }
    
    @Column(name="ValueDate", nullable=true)
    public java.util.Date getValueDate() {
        return valueDate;
    }
    public void setValueDate(java.util.Date value) {
        this.valueDate = value;
    }
    
    @Column(name="ValueType", nullable=true)
    public org.rodyce.foncier.datamodel.ladm.external.ExtValuationType getValueType() {
        return valueType;
    }
    public void setValueType(org.rodyce.foncier.datamodel.ladm.external.ExtValuationType value) {
        this.valueType = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
