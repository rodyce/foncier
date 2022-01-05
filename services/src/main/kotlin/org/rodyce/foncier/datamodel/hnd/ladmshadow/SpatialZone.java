package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.ISpatialZone;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_LandUse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="SpatialZone", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="SpatialUnitID", referencedColumnName="ID")
public class SpatialZone extends SpatialUnit implements Serializable, Cloneable, ISpatialZone {
    private static final long serialVersionUID = 1L;

    private Geometry shape;
    private String zoneName;
    private String locationInCountry;
    private BigDecimal geometryPerimeter;
    private BigDecimal measuredPerimeter;
    private BigDecimal documentedPerimeter;
    private BigDecimal geometryArea;
    private BigDecimal measuredArea;
    private BigDecimal documentedArea;

    private HND_LandUse landUse;
    private HND_LandUse proposedLandUse;
    private List<HND_LandUse> otherLandUses = new ArrayList<HND_LandUse>();


    @Column(name="Shape", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Geometry getShape() {
        return shape;
    }
    public void setShape(Geometry value) {
        if (this.shape == null || !this.shape.equalsExact(value)) {
            this.shape = value;
            
            Point newRefPoint = value.getCentroid();
            newRefPoint.setSRID(value.getSRID());
            this.setReferencePoint(newRefPoint);
        }
    }
    
    @Column(name="ZoneName", nullable=true)
    public String getZoneName() {
        return zoneName;
    }
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    
    @Column(name="LocationInCountry", nullable=true)
    public String getLocationInCountry() {
        return locationInCountry;
    }
    public void setLocationInCountry(String locationInCountry) {
        this.locationInCountry = locationInCountry;
    }
    
    @Transient
    public BigDecimal getGeometryPerimeter() {
        if (geometryPerimeter == null) {
            Geometry s = getShape();
            if (s != null) {
                geometryPerimeter = new BigDecimal(s.getLength(), new MathContext(24));
                geometryPerimeter = geometryPerimeter.setScale(8, RoundingMode.HALF_UP);
            }
        }
        return geometryPerimeter;
    }
    public void setGeometryPerimeter(BigDecimal geometryPerimeter) {
        //do nothing
    }
    
    @Column(name="MeasuredPerimeter", nullable=true, precision=24, scale=8)
    public BigDecimal getMeasuredPerimeter() {
        return measuredPerimeter;
    }
    public void setMeasuredPerimeter(BigDecimal measuredPerimeter) {
        this.measuredPerimeter = measuredPerimeter;
    }
    
    @Column(name="DocumentedPerimeter", nullable=true, precision=24, scale=8)
    public BigDecimal getDocumentedPerimeter() {
        return documentedPerimeter;
    }
    public void setDocumentedPerimeter(BigDecimal documentedPerimeter) {
        this.documentedPerimeter = documentedPerimeter;
    }
    
    @Transient
    public BigDecimal getGeometryArea() {
        if (geometryArea == null) {
            Geometry s = getShape();
            if (s != null) {
                geometryArea = new BigDecimal(s.getArea(), new MathContext(24));
                geometryArea = geometryArea.setScale(8, RoundingMode.HALF_UP);
            }
        }
        return geometryArea;
    }
    public void setGeometryArea(BigDecimal geometryArea) {
        //do nothing
    }
    
    @Column(name="DocumentedArea", nullable=true, precision=24, scale=8)
    public BigDecimal getDocumentedArea() {
        return documentedArea;
    }
    public void setDocumentedArea(BigDecimal documentedArea) {
        this.documentedArea = documentedArea;
    }
    
    @Column(name="MeasuredArea", nullable=true, precision=24, scale=8)
    public BigDecimal getMeasuredArea() {
        return measuredArea;
    }
    public void setMeasuredArea(BigDecimal measuredArea) {
        this.measuredArea = measuredArea;
    }
    
    @Override
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LandUseID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_LandUse getLandUse() {
        return landUse;
    }
    @Override
    public void setLandUse(HND_LandUse landUse) {
        this.landUse = landUse;
    }
    
    @Override
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="ProposedLandUseID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_LandUse getProposedLandUse() {
        return proposedLandUse;
    }
    @Override
    public void setProposedLandUse(HND_LandUse proposedLandUse) {
        this.proposedLandUse = proposedLandUse;
    }
    
    @Override
    @ManyToMany(targetEntity=HND_LandUse.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="SpatialZone__HND_LandUse", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialZone__HND_LandUseID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public List<HND_LandUse> getOtherLandUses() {
        return otherLandUses;
    }
    @Override
    public void setOtherLandUses(List<HND_LandUse> otherLandUses) {
        this.otherLandUses = otherLandUses;
    }

    
    @Transient
    public Property getProperty() {
        Property prop = null;
        Set<BAUnit> baUnitSet = super.getBaunits();
        for (BAUnit baUnit : baUnitSet) {
            if (baUnit instanceof Property) {
                prop = (Property)baUnit;
                break;
            }
        }
        return prop;
    }

}
