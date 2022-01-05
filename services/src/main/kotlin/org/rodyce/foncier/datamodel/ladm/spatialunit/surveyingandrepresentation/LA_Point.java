package org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Point", schema="ladm_spatialunit_surveyingandrepresentation")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Point")
public class LA_Point extends org.rodyce.foncier.datamodel.ladm.special.VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID pID;
    private double estimatedAccuracy;
    private LA_InterpolationType interpolationRole;
    private LA_MonumentationType monumentation;
    private Point originalLocation;
    private LA_PointType pointType;
    private byte productionMethod;
    private LA_Transformation transAndResult;
    private java.util.Set<LA_SpatialSource> spatialSources = new java.util.HashSet<LA_SpatialSource>();
    private java.util.Set<LA_BoundaryFace> surfaceBoundaries = new java.util.HashSet<LA_BoundaryFace>();
    private java.util.Set<LA_BoundaryFaceString> boundaries = new java.util.HashSet<LA_BoundaryFaceString>();
    private org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit spatialUnit;
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getpID() {
        return pID;
    }
    protected void setpID(UUID value) {
        this.pID = value;
    }
    
    @Transient
    public UUID getORMID() {
        return getpID();
    }
    
    @Column(name="EstimatedAccuracy", nullable=false)
    public double getEstimatedAccuracy() {
        return estimatedAccuracy;
    }
    public void setEstimatedAccuracy(double value) {
        this.estimatedAccuracy = value;
    }
    
    @Column(name="InterpolationRole", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_InterpolationType getInterpolationRole() {
        return interpolationRole;
    }
    public void setInterpolationRole(LA_InterpolationType value) {
        this.interpolationRole = value;
    }
    
    @Column(name="Monumentation", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_MonumentationType getMonumentation() {
        return monumentation;
    }
    public void setMonumentation(LA_MonumentationType value) {
        this.monumentation = value;
    }
    
    @Column(name="OriginalLocation", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Point getOriginalLocation() {
        return originalLocation;
    }
    public void setOriginalLocation(Point value) {
        this.originalLocation = value;
    }
    
    @Column(name="PointType", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_PointType getPointType() {
        return pointType;
    }
    public void setPointType(LA_PointType value) {
        this.pointType = value;
    }
    
    @Column(name="ProductionMethod", nullable=false)
    public byte getProductionMethod() {
        return productionMethod;
    }
    public void setProductionMethod(byte value) {
        this.productionMethod = value;
    }
    
    @Transient
    public LA_Transformation getTransAndResult() {
        return transAndResult;
    }
    public void setTransAndResult(LA_Transformation value) {
        this.transAndResult = value;
    }
    
    @ManyToMany(targetEntity=LA_SpatialSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="LA_SpatialSource_LA_Point", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_PointID") }, inverseJoinColumns={ @JoinColumn(name="LA_SpatialSourceLA_SourceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(java.util.Set<LA_SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @ManyToMany(targetEntity=LA_BoundaryFace.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_Point_LA_BoundaryFace", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_PointID") }, inverseJoinColumns={ @JoinColumn(name="LA_BoundaryFaceID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_BoundaryFace> getSurfaceBoundaries() {
        return surfaceBoundaries;
    }
    public void setSurfaceBoundaries(java.util.Set<LA_BoundaryFace> value) {
        this.surfaceBoundaries = value;
    }
    
    @ManyToMany(targetEntity=LA_BoundaryFaceString.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_Point_LA_BoundaryFaceString", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_PointID") }, inverseJoinColumns={ @JoinColumn(name="LA_BoundaryFaceStringID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_BoundaryFaceString> getBoundaries() {
        return boundaries;
    }
    public void setBoundaries(java.util.Set<LA_BoundaryFaceString> value) {
        this.boundaries = value;
    }
    
    @OneToOne(mappedBy="pointOfReference", targetEntity=org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit getSpatialUnit() {
        return spatialUnit;
    }
    public void setSpatialUnit(org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit value) {
        this.spatialUnit = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
