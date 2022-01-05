package org.rodyce.foncier.datamodel.ladm.external;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ExtAddress", schema="ladm_external")
@Inheritance(strategy=InheritanceType.JOINED)
public class ExtAddress implements Serializable {
    private static final long serialVersionUID = 1L;


    private UUID addressID;
    private String addressAreaName;
    private Point addressCoordinate;
    private String buildingName;
    private String buildingNumber;
    private String city;
    private String country;
    private String postalCode;
    private String postBox;
    private String state;
    private String streetName;
    private ExtParty party;

    
    @Transient
    public UUID getORMID() {
        return getAddressID();
    }

    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getAddressID() {
        return addressID;
    }
    protected void setAddressID(UUID value) {
        this.addressID = value;
    }
    
    
    @Column(name="AddressAreaName", nullable=true, length=255)    
    public String getAddressAreaName() {
        return addressAreaName;
    }
    public void setAddressAreaName(String value) {
        this.addressAreaName = value;
    }
    
    @Column(name="AddressCoordinate", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Point getAddressCoordinate() {
        return addressCoordinate;
    }
    public void setAddressCoordinate(Point value) {
        this.addressCoordinate = value;
    }
    
    @Column(name="BuildingName", nullable=true, length=255)    
    public String getBuildingName() {
        return buildingName;
    }
    public void setBuildingName(String value) {
        this.buildingName = value;
    }
    
    @Column(name="BuildingNumber", nullable=true, length=255)    
    public String getBuildingNumber() {
        return buildingNumber;
    }
    public void setBuildingNumber(String value) {
        this.buildingNumber = value;
    }
    
    @Column(name="City", nullable=true, length=255)
    public String getCity() {
        return city;
    }
    public void setCity(String value) {
        this.city = value;
    }
    
    @Column(name="Country", nullable=true, length=255)
    public String getCountry() {
        return country;
    }
    public void setCountry(String value) {
        this.country = value;
    }
    
    @Column(name="PostalCode", nullable=true, length=255)
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String value) {
        this.postalCode = value;
    }
    
    @Column(name="PostBox", nullable=true, length=255)
    public String getPostBox() {
        return postBox;
    }
    public void setPostBox(String value) {
        this.postBox = value;
    }
    
    @Column(name="State", nullable=true, length=255)
    public String getState() {
        return state;
    }
    public void setState(String value) {
        this.state = value;
    }
    
    @Column(name="StreetName", nullable=true, length=255)
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String value) {
        this.streetName = value;
    }
    
    @OneToOne(targetEntity=org.rodyce.foncier.datamodel.ladm.external.ExtParty.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="ExtPartyLA_PartyID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public org.rodyce.foncier.datamodel.ladm.external.ExtParty getParty() {
        return party;
    }
    public void setParty(org.rodyce.foncier.datamodel.ladm.external.ExtParty value) {
        this.party = value;
    }
    
    
    public String toString() {
        return String.valueOf(getAddressID());
    }
    
}
