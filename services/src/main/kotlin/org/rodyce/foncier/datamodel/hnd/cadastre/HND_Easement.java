package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

import org.rodyce.foncier.datamodel.commons.IEasement;
import org.rodyce.foncier.datamodel.commons.IRegistration;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_Registration;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_Easement", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_Easement implements IEasement {
    private UUID id;
    private HND_EasementType type;
    private HND_DocumentType documentType;
    private Integer beneficiaryNumber;
    private HND_Registration registration = new HND_Registration();
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name="Type", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_EasementType getType() {
        return type;
    }
    public void setType(HND_EasementType type) {
        this.type = type;
    }
    
    @Column(name="DocumentType", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_DocumentType getDocumentType() {
        return documentType;
    }
    public void setDocumentType(HND_DocumentType documentType) {
        this.documentType = documentType;
    }
    
    @Column(name="BeneficiaryNumber", nullable=true)
    public Integer getBeneficiaryNumber() {
        return beneficiaryNumber;
    }
    public void setBeneficiaryNumber(Integer beneficiaryNumber) {
        this.beneficiaryNumber = beneficiaryNumber;
    }
    
    @Embedded
    public HND_Registration getRegistration() {
        return registration;
    }
    public void setRegistration(IRegistration registration) {
        if (registration != null && !(registration instanceof HND_Registration))
            throw new IllegalArgumentException("HND_Registration type required");
        this.registration = (HND_Registration) registration;
    }
}
