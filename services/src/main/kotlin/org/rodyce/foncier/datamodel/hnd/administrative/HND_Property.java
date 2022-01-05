package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.rodyce.foncier.datamodel.commons.IParcel;
import org.rodyce.foncier.datamodel.commons.IProperty;
import org.rodyce.foncier.datamodel.commons.IRegistration;
import org.rodyce.foncier.datamodel.commons.IResponsibility;
import org.rodyce.foncier.datamodel.commons.IRestriction;
import org.rodyce.foncier.datamodel.commons.IRight;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_AdministrativeSource;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_RRR;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_RequiredRelationshipBAUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_SpatialSource;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_Property", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="LA_BAUnitID", referencedColumnName="ID")
public class HND_Property extends LA_BAUnit implements Serializable, Cloneable, IProperty {
    private static final long serialVersionUID = 1L;
    
    private HND_Registration registration = new HND_Registration();
    
    @Embedded
    public HND_Registration getRegistration() {
        return registration;
    }
    public void setRegistration(IRegistration registration) {
        if (registration != null && !(registration instanceof HND_Registration))
            throw new IllegalArgumentException("HND_Registration type required");
        this.registration = (HND_Registration) registration;
    }


    @Transient
    public Set<IParcel> getParcels() {
        Set<LA_SpatialUnit> suSet = super.getSpatialUnits();
        Set<IParcel> parcelSet = new HashSet<IParcel>();

        for (LA_SpatialUnit lasu : suSet)
            if (lasu instanceof IParcel)
                parcelSet.add((IParcel) lasu);

        return parcelSet;
    }


    @Transient
    public String toString() {
        return super.toString();
    }

    
    @Override
    public HND_Property clone() {
        HND_Property clonedHndPropery;
        try {
            clonedHndPropery = (HND_Property) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

        //this is in order to mark the object as unsaved
        clonedHndPropery.setuID(null);
        
        Set<LA_SpatialSource> spatialSources = new HashSet<LA_SpatialSource>(getSpatialSources());
        Set<LA_RRR> rrr = new HashSet<LA_RRR>(getRrr());
        Set<LA_RequiredRelationshipBAUnit> baunits1requiredrelationshipbaunits = new HashSet<LA_RequiredRelationshipBAUnit>(getBaunits1La_requiredrelationshipbaunits());
        Set<LA_RequiredRelationshipBAUnit> baunits2requiredrelationshipbaunits = new HashSet<LA_RequiredRelationshipBAUnit>(getBaunits2La_requiredrelationshipbaunits());
        Set<LA_SpatialUnit> spatialUnits = new HashSet<LA_SpatialUnit>(getSpatialUnits());
        Set<LA_AdministrativeSource> adminSources = new HashSet<LA_AdministrativeSource>(getAdminSources());
        
        clonedHndPropery.setSpatialSources(spatialSources);
        clonedHndPropery.setRrr(rrr);
        clonedHndPropery.setBaunits1La_requiredrelationshipbaunits(baunits1requiredrelationshipbaunits);
        clonedHndPropery.setBaunits2La_requiredrelationshipbaunits(baunits2requiredrelationshipbaunits);
        clonedHndPropery.setSpatialUnits(spatialUnits);
        clonedHndPropery.setAdminSources(adminSources);

        return clonedHndPropery;
    }


    @Transient
    @Override
    public int rightsHash() {
        int hash = 0;
        for (IRight<?,?> ir : getRights())
            hash += ir.rightHash();
        return hash;
    }

    @Transient
    @Override
    public List<IRight<?,?>> getRights() {
        List<IRight<?,?>> rights = new ArrayList<IRight<?,?>>();
        for (LA_RRR laRrr : getRrr())
            if (laRrr instanceof IRight)
                rights.add((IRight<?,?>) laRrr);
        return rights;
    }

    @Transient
    @Override
    public int restrictionsHash() {
        int hash = 0;
        for (IRestriction<?,?> ir : getRestrictions())
            hash += ir.restrictionsHash();
        return hash;
    }

    @Transient
    @Override
    public List<IRestriction<?,?>> getRestrictions() {
        List<IRestriction<?,?>> restrictions = new ArrayList<>();
        for (LA_RRR laRrr : getRrr())
            if (laRrr instanceof IRestriction)
                restrictions.add((IRestriction<?,?>) laRrr);
        return restrictions;
    }

    @Transient
    @Override
    public int responsibilitiesHash() {
        int hash = 0;
        for (IResponsibility<?,?> ir : getResponsibilities())
            hash += ir.responsibilitiesHash();
        return hash;
    }

    @Transient
    @Override
    public List<IResponsibility<?,?>> getResponsibilities() {
        List<IResponsibility<?,?>> responsibilities = new ArrayList<>();
        for (LA_RRR laRrr : getRrr())
            if (laRrr instanceof IResponsibility)
                responsibilities.add((IResponsibility<?,?>) laRrr);
        return responsibilities;
    }
}
