package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.rodyce.foncier.datamodel.ladm.external.ExtParty;


@Entity
@Table(name="HND_Person", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="ExtPartyID")
public class HND_Person extends ExtParty implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    private String rtn;
    private String addressDescription;
    private String phones;
    private String emails;
    
    
    @Column(name="Rtn", nullable=true, length=255, unique=false)
    public String getRtn() {
        return rtn;
    }
    public void setRtn(String rtn) {
        this.rtn = rtn;
    }

    @Column(name="AddressDescription", nullable=true, length=255, unique=false)
    public String getAddressDescription() {
        return addressDescription;
    }
    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    @Column(name="Phones", nullable=true, length=100)
    public String getPhones() {
        return phones;
    }
    public void setPhones(String phones) {
        this.phones = phones;
    }

    @Column(name="Emails", nullable=true, length=100)
    public String getEmails() {
        return emails;
    }
    public void setEmails(String emails) {
        this.emails = emails;
    }


    @Override
    @Transient
    public String getFormalIdentity() {
        return rtn;
    }
}
