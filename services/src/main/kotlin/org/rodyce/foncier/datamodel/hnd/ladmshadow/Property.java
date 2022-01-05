package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.IParcel;
import org.rodyce.foncier.datamodel.commons.IProperty;
import org.rodyce.foncier.datamodel.commons.IRegistration;
import org.rodyce.foncier.datamodel.commons.IResponsibility;
import org.rodyce.foncier.datamodel.commons.IRestriction;
import org.rodyce.foncier.datamodel.commons.IRight;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_Registration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.InheritanceType;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Property", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="BAUnitID", referencedColumnName="ID")
public class Property extends BAUnit implements Serializable, Cloneable, IProperty {
    private static final long serialVersionUID = 1L;
    
    private HND_Registration registration = new HND_Registration();
    

    public static Property newProperty(UUID ladmId, long presentationNo, boolean isReadOnly, boolean isSnapshot) {
        Property property = new Property();
        
        property.setLadmId(ladmId);
        property.setPresentationNo(presentationNo);
        property.setReadOnly(isReadOnly);
        property.setSnapshot(isSnapshot);

        return property;
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


    @Transient
    public Set<IParcel> getParcels() {
        Set<SpatialUnit> suSet = super.getSpatialUnits();
        Set<IParcel> parcelSet = new HashSet<IParcel>();
        
        for (SpatialUnit su : suSet)
            if (su instanceof IParcel)
                parcelSet.add((IParcel)su);
        
        return parcelSet;
    }
    
    /*
     * TODO: ver que hacer con esto
    @Transient
    public MultiPolygon getParcelsAsMultiPolygon() {
        Set<Parcel> parcels = getParcels();
        
        if (parcels != null && parcels.size() > 0) {
            Polygon[] polygons = new Polygon[parcels.size()];
            int i = 0;
            for (Parcel hndP : parcels)
                polygons[i++] = hndP.getShape();
            
            
            return GeometryOperations.geomFactory.createMultiPolygon(polygons);
        }
        
        return null;
    }
    */

    @Transient
    public String toString() {
        return super.toString();
    }
    
    @Override
    public Property clone() {
        Property clonedProperty;
        try {
            clonedProperty = (Property)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        
        //this is in order to mark the object as unsaved
        clonedProperty.setuID(null);
        
        Set<SpatialSource> spatialSources = new HashSet<SpatialSource>(getSpatialSources());
        
        Set<RRR> rrrSet = new HashSet<RRR>();
        RRR clonedRRR;
        for (RRR rrr : getRrr()) {
            clonedRRR = rrr.clone();
            clonedRRR.setBaunit(clonedProperty);
            rrrSet.add(clonedRRR);
        }
        
        Set<RequiredRelationshipBAUnit> baunits1requiredrelationshipbaunits = new HashSet<RequiredRelationshipBAUnit>(getBaunits1requiredrelationshipbaunits());
        Set<RequiredRelationshipBAUnit> baunits2requiredrelationshipbaunits = new HashSet<RequiredRelationshipBAUnit>(getBaunits2requiredrelationshipbaunits());
        Set<SpatialUnit> spatialUnits = new HashSet<SpatialUnit>(getSpatialUnits());
        Set<AdministrativeSource> adminSources = new HashSet<AdministrativeSource>(getAdminSources());
        
        clonedProperty.setSpatialSources(spatialSources);
        clonedProperty.setRrr(rrrSet);
        clonedProperty.setBaunits1requiredrelationshipbaunits(baunits1requiredrelationshipbaunits);
        clonedProperty.setBaunits2requiredrelationshipbaunits(baunits2requiredrelationshipbaunits);
        clonedProperty.setSpatialUnits(spatialUnits);
        clonedProperty.setAdminSources(adminSources);
        
        return clonedProperty;
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
        for (RRR rrr : getRrr())
            if (rrr instanceof IRight)
                rights.add((IRight<?,?>) rrr);
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
        List<IRestriction<?,?>> restrictions = new ArrayList<IRestriction<?,?>>();
        for (RRR rrr : getRrr())
            if (rrr instanceof IRestriction)
                restrictions.add((IRestriction<?,?>) rrr);
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
        List<IResponsibility<?,?>> responsibilities = new ArrayList<IResponsibility<?,?>>();
        for (RRR rrr : getRrr())
            if (rrr instanceof IResponsibility)
                responsibilities.add((IResponsibility<?,?>) rrr);
        return responsibilities;
    }
}
