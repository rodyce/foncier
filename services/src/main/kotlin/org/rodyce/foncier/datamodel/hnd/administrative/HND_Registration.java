package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;

import org.rodyce.foncier.datamodel.commons.IRegistration;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

@Embeddable

public class HND_Registration implements IRegistration, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Boolean hasRegistrationData = false;
    private String code;
    private Integer tome;
    private Integer folio;
    private Integer annotationNumber;
    
    
    @Column(name="HasRegistrationData", nullable=false)
    public Boolean getHasRegistrationData() {
        return hasRegistrationData;
    }
    public void setHasRegistrationData(Boolean hasRegistrationData) {
        this.hasRegistrationData = hasRegistrationData;
    }
    
    @Column(name="Code", nullable=true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name="Tome", nullable=true)
    public Integer getTome() {
        return tome;
    }
    public void setTome(Integer tome) {
        this.tome = tome;
    }
    
    @Column(name="Folio", nullable=true)
    public Integer getFolio() {
        return folio;
    }
    public void setFolio(Integer folio) {
        this.folio = folio;
    }
    
    @Column(name="AnnotationNumber", nullable=true)
    public Integer getAnnotationNumber() {
        return annotationNumber;
    }
    public void setAnnotationNumber(Integer annotationNumber) {
        this.annotationNumber = annotationNumber;
    }
    
    @Transient
    @PreUpdate
    @PrePersist
    public void setHasRegistrationDataFlag() {
        setHasRegistrationData( !(getCode() == null && getTome() == null && getFolio() == null && getAnnotationNumber() == null) );
    }
}
