package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.rodyce.foncier.datamodel.commons.IAvailableServices;

@Embeddable
public class HND_AvailableServices implements IAvailableServices, Serializable {
    private static final long serialVersionUID = 1L;
    
    private boolean streets;
    private boolean water;
    private boolean sidewalks;
    private boolean drainage;
    private boolean access;
    private boolean topography;
    private boolean location;
    private boolean electricity;
    private boolean lighting;
    private boolean phone;
    private boolean tvcable;
    private boolean garbageTruck;
    private boolean heritage;
    private boolean landscapeValue;
    private boolean vulnerable;
    private boolean businessClass;
    
    @Column(name="Streets", nullable=false)
    public boolean getStreets() {
        return streets;
    }
    public void setStreets(boolean streets) {
        this.streets = streets;
    }
    
    @Column(name="Water", nullable=false)
    public boolean getWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }

    @Column(name="Sidewalks", nullable=false)
    public boolean getSidewalks() {
        return sidewalks;
    }
    public void setSidewalks(boolean sidewalks) {
        this.sidewalks = sidewalks;
    }
    
    @Column(name="Drainage", nullable=false)
    public boolean getDrainage() {
        return drainage;
    }
    public void setDrainage(boolean drainage) {
        this.drainage = drainage;
    }

    @Column(name="Access", nullable=false)
    public boolean getAccess() {
        return access;
    }
    public void setAccess(boolean access) {
        this.access = access;
    }
    
    @Column(name="Topography", nullable=false)
    public boolean getTopography() {
        return topography;
    }
    public void setTopography(boolean topography) {
        this.topography = topography;
    }

    @Column(name="Location", nullable=false)
    public boolean getLocation() {
        return location;
    }
    public void setLocation(boolean location) {
        this.location = location;
    }

    @Column(name="Electricity", nullable=false)
    public boolean getElectricity() {
        return electricity;
    }
    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    @Column(name="Lighting", nullable=false)
    public boolean getLighting() {
        return lighting;
    }
    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    @Column(name="Phone", nullable=false)
    public boolean getPhone() {
        return phone;
    }
    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    @Column(name="Tvcable", nullable=false)
    public boolean getTvcable() {
        return tvcable;
    }
    public void setTvcable(boolean tvcable) {
        this.tvcable = tvcable;
    }

    @Column(name="GarbageTruck", nullable=false)
    public boolean getGarbageTruck() {
        return garbageTruck;
    }
    public void setGarbageTruck(boolean garbageTruck) {
        this.garbageTruck = garbageTruck;
    }

    @Column(name="Heritage", nullable=false)
    public boolean getHeritage() {
        return heritage;
    }
    public void setHeritage(boolean heritage) {
        this.heritage = heritage;
    }

    @Column(name="LandscapeValue", nullable=false)
    public boolean getLandscapeValue() {
        return landscapeValue;
    }
    public void setLandscapeValue(boolean landscapeValue) {
        this.landscapeValue = landscapeValue;
    }

    @Column(name="Vulnerable", nullable=false)
    public boolean getVulnerable() {
        return vulnerable;
    }
    public void setVulnerable(boolean vulnerable) {
        this.vulnerable = vulnerable;
    }

    @Column(name="BusinessClass", nullable=false)
    public boolean getBusinessClass() {
        return businessClass;
    }
    public void setBusinessClass(boolean businessClass) {
        this.businessClass = businessClass;
    }
}
