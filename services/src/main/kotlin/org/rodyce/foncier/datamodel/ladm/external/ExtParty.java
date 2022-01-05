package org.rodyce.foncier.datamodel.ladm.external;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.ladm.external.ExtAddress;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ExtParty", schema="ladm_external")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="LA_PartyID", referencedColumnName="ID")
public abstract class ExtParty implements Serializable {
    private static final long serialVersionUID = 1L;

    public ExtParty() {
    }
    
    private UUID extPID;
    private java.sql.Blob fingerPrint;
    private String name;
    private java.sql.Blob photo;
    private java.sql.Blob signature;
    private ExtAddress address;

    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getExtPID() {
        return extPID;
    }
    public void setExtPID(UUID extPID) {
        this.extPID = extPID;
    }
    
    @Column(name="FingerPrint", nullable=true)
    public java.sql.Blob getFingerPrint() {
        return fingerPrint;
    }
    public void setFingerPrint(java.sql.Blob value) {
        this.fingerPrint = value;
    }
    
    @Column(name="Name", nullable=true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="Photo", nullable=true)
    public java.sql.Blob getPhoto() {
        return photo;
    }
    public void setPhoto(java.sql.Blob value) {
        this.photo = value;
    }
    
    @Column(name="Signature", nullable=true)
    public java.sql.Blob getSignature() {
        return signature;
    }
    public void setSignature(java.sql.Blob value) {
        this.signature = value;
    }
    
    @OneToOne(mappedBy="party", targetEntity=ExtAddress.class, fetch=FetchType.LAZY)    
    public ExtAddress getAddress() {
        return address;
    }
    public void setAddress(org.rodyce.foncier.datamodel.ladm.external.ExtAddress value) {
        this.address = value;
    }
    
    @Transient
    public abstract String getFormalIdentity();


    public String toString() {
        return super.toString();
    }
}
