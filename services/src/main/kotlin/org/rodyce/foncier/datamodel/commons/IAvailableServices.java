package org.rodyce.foncier.datamodel.commons;

public interface IAvailableServices {

    boolean getStreets();

    void setStreets(boolean streets);

    boolean getWater();

    void setWater(boolean water);

    boolean getSidewalks();

    void setSidewalks(boolean sidewalks);

    boolean getDrainage();

    void setDrainage(boolean drainage);

    boolean getAccess();

    void setAccess(boolean access);

    boolean getTopography();

    void setTopography(boolean topography);

    boolean getLocation();

    void setLocation(boolean location);

    boolean getElectricity();

    void setElectricity(boolean electricity);

    boolean getLighting();

    void setLighting(boolean lighting);

    boolean getPhone();

    void setPhone(boolean phone);

    boolean getTvcable();

    void setTvcable(boolean tvcable);

    boolean getGarbageTruck();

    void setGarbageTruck(boolean garbageTruck);

    boolean getHeritage();

    void setHeritage(boolean heritage);

    boolean getLandscapeValue();

    void setLandscapeValue(boolean landscapeValue);

    boolean getVulnerable();

    void setVulnerable(boolean vulnerable);

    boolean getBusinessClass();

    void setBusinessClass(boolean businessClass);

}