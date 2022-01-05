package org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Polygon;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_BoundaryFace", schema="ladm_spatialunit_surveyingandrepresentation")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_BoundaryFace")
public class LA_BoundaryFace extends org.rodyce.foncier.datamodel.ladm.special.VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID bfID;
    private LA_SpatialSource spatialSources;
    private Polygon geometry;
    private String locationByText;
    private java.util.Set<LA_Point> relatedPoints = new java.util.HashSet<LA_Point>();
    private java.util.Set<LA_SpatialUnit> suMinus = new java.util.HashSet<LA_SpatialUnit>();
    private java.util.Set<LA_SpatialUnit> suPlus = new java.util.HashSet<LA_SpatialUnit>();
    
    public LA_BoundaryFace() {
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
    
    @ManyToOne(targetEntity=LA_SpatialSource.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_SpatialSourceLA_SourceID", referencedColumnName="LA_SourceID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_SpatialSource getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(LA_SpatialSource value) {
        this.spatialSources = value;
    }
    
    @ManyToMany(mappedBy="surfaceBoundaries", targetEntity=LA_Point.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_Point> getRelatedPoints() {
        return relatedPoints;
    }
    public void setRelatedPoints(java.util.Set<LA_Point> value) {
        this.relatedPoints = value;
    }
    
    @ManyToMany(mappedBy="bfMinus", targetEntity=LA_SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_SpatialUnit> getSuMinus() {
        return suMinus;
    }
    public void setSuMinus(java.util.Set<LA_SpatialUnit> value) {
        this.suMinus = value;
    }
    
    @ManyToMany(mappedBy="bfPlus", targetEntity=LA_SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_SpatialUnit> getSuPlus() {
        return suPlus;
    }
    public void setSuPlus(java.util.Set<LA_SpatialUnit> value) {
        this.suPlus = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
