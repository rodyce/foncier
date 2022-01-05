package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.InheritanceType;


@Entity
@Table(name="HND_NaturalPerson", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="ExtPartyID")
public class HND_NaturalPerson extends HND_Person implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private String firstName1;
    private String firstName2;
    private String lastName1;
    private String lastName2;
    private Character gender;
    private String nationality;
    private Date dob;
    private Character maritalStatus;
    private String identity;

    
    @Column(name="FirstName1", nullable=false, length=255)
    public String getFirstName1() {
        return firstName1;
    }
    public void setFirstName1(String value) {
        this.firstName1 = value;
        updateName();
    }
    
    @Column(name="FirstName2", nullable=true, length=255)
    public String getFirstName2() {
        return firstName2;
    }
    public void setFirstName2(String value) {
        this.firstName2 = value;
        updateName();
    }
    
    @Column(name="LastName1", nullable=true, length=255)
    public String getLastName1() {
        return lastName1;
    }
    public void setLastName1(String value) {
        this.lastName1 = value;
        updateName();
    }
    
    @Column(name="LastName2", nullable=true, length=255)
    public String getLastName2() {
        return lastName2;
    }
    public void setLastName2(String value) {
        this.lastName2 = value;
        updateName();
    }
    
    @Column(name="Gender", nullable=true, length=1)
    public Character getGender() {
        return gender;
    }
    public void setGender(Character value) {
        this.gender = value;
    }
    
    @Column(name="Nationality", nullable=true, length=255)
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String value) {
        this.nationality = value;
    }
    
    @Column(name="Dob", nullable=true)
    public java.util.Date getDob() {
        return dob;
    }
    public void setDob(Date value) {
        this.dob = value;
    }
    
    @Column(name="MaritalStatus", nullable=true, length=1)
    public Character getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(Character value) {
        this.maritalStatus = value;
    }
    
    @Column(name="Identity", nullable=true, length=255, unique=false)
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String value) {
        this.identity = value;
    }
    
    
    @Transient
    public String getFullNameLastNameFirst() {
        StringBuffer sb = new StringBuffer();
        sb.append(lastName1);
        if (lastName2 != null) sb.append(" " + lastName2);
        sb.append(", " + firstName1);
        if (firstName2 != null) sb.append(firstName2);
        
        return sb.toString();
    }
    
    
    @Transient
    private void updateName() {
        StringBuffer sb = new StringBuffer();
        sb.append(firstName1);
        if (firstName2 != null) sb.append(" " + firstName2);
        if (lastName1 != null) sb.append(" " + lastName1);
        if (lastName2 != null) sb.append(" " + lastName2);
        
        setName(sb.toString());
    }


    @Override
    @Transient
    public String getFormalIdentity() {
        return identity;
    }
    
    @Override
    public HND_NaturalPerson clone() {
        try {
            return (HND_NaturalPerson)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public String toString() {
        return super.toString();
    }

}
