package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Polygon;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="BoundaryFace", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("BoundaryFace")
public class BoundaryFace extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID bfID;
    private SpatialSource spatialSources;
    private Polygon geometry;
    private String locationByText;
    private java.util.Set<LAPoint> relatedPoints = new java.util.HashSet<LAPoint>();
    private java.util.Set<SpatialUnit> suMinus = new java.util.HashSet<SpatialUnit>();
    private java.util.Set<SpatialUnit> suPlus = new java.util.HashSet<SpatialUnit>();
    
    public BoundaryFace() {
    }

    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getBfID() {
        return bfID;
    }
    protected void setBfID(UUID value) {
        this.bfID = value;
    }
    @Transient
    public UUID getORMID() {
        return getBfID();
    }
    
    @Column(name="Geometry", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Polygon getGeometry() {
        return geometry;
    }
    public void setGeometry(Polygon value) {
        this.geometry = value;
    }
    
    @Column(name="LocationByText", nullable=true, length=255)
    public String getLocationByText() {
        return locationByText;
    }
    public void setLocationByText(String value) {
        this.locationByText = value;
    }
    
    @ManyToOne(targetEntity=SpatialSource.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="SpatialSourceSourceID", referencedColumnName="SourceID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public SpatialSource getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(SpatialSource value) {
        this.spatialSources = value;
    }
    
    @ManyToMany(mappedBy="surfaceBoundaries", targetEntity=LAPoint.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LAPoint> getRelatedPoints() {
        return relatedPoints;
    }
    public void setRelatedPoints(java.util.Set<LAPoint> value) {
        this.relatedPoints = value;
    }
    
    @ManyToMany(mappedBy="bfMinus", targetEntity=SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialUnit> getSuMinus() {
        return suMinus;
    }
    public void setSuMinus(java.util.Set<SpatialUnit> value) {
        this.suMinus = value;
    }
    
    @ManyToMany(mappedBy="bfPlus", targetEntity=SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialUnit> getSuPlus() {
        return suPlus;
    }
    public void setSuPlus(java.util.Set<SpatialUnit> value) {
        this.suPlus = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
