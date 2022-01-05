package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_InterpolationType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_MonumentationType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_PointType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_Transformation;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Point", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Point")
public class LAPoint extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID pID;
    private double estimatedAccuracy;
    private LA_InterpolationType interpolationRole;
    private LA_MonumentationType monumentation;
    private Point originalLocation;
    private LA_PointType pointType;
    private byte productionMethod;
    private LA_Transformation transAndResult;
    private java.util.Set<SpatialSource> spatialSources = new java.util.HashSet<SpatialSource>();
    private java.util.Set<BoundaryFace> surfaceBoundaries = new java.util.HashSet<BoundaryFace>();
    private java.util.Set<BoundaryFaceString> boundaries = new java.util.HashSet<BoundaryFaceString>();
    private SpatialUnit spatialUnit;
    
    protected LAPoint() {
    }
    
    public static LAPoint newLAPoint(UUID ladmId, long presentationNo, boolean isReadOnly, boolean isSnapshot) {
        LAPoint laPoint = new LAPoint();
        
        laPoint.setLadmId(ladmId);
        laPoint.setPresentationNo(presentationNo);
        laPoint.setReadOnly(isReadOnly);
        laPoint.setSnapshot(isSnapshot);
        
        return laPoint;
    }
    
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
    
    @ManyToMany(targetEntity=SpatialSource.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="SpatialSource_Point", schema="ladmshadow", joinColumns={ @JoinColumn(name="PointID") }, inverseJoinColumns={ @JoinColumn(name="SpatialSourceSourceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(java.util.Set<SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @ManyToMany(targetEntity=BoundaryFace.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Point_BoundaryFace", schema="ladmshadow", joinColumns={ @JoinColumn(name="PointID") }, inverseJoinColumns={ @JoinColumn(name="BoundaryFaceID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<BoundaryFace> getSurfaceBoundaries() {
        return surfaceBoundaries;
    }
    public void setSurfaceBoundaries(java.util.Set<BoundaryFace> value) {
        this.surfaceBoundaries = value;
    }
    
    @ManyToMany(targetEntity=BoundaryFaceString.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Point_BoundaryFaceString", schema="ladmshadow", joinColumns={ @JoinColumn(name="PointID") }, inverseJoinColumns={ @JoinColumn(name="BoundaryFaceStringID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<BoundaryFaceString> getBoundaries() {
        return boundaries;
    }
    public void setBoundaries(java.util.Set<BoundaryFaceString> value) {
        this.boundaries = value;
    }
    
    @OneToOne(mappedBy="pointOfReference", targetEntity=SpatialUnit.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public SpatialUnit getSpatialUnit() {
        return spatialUnit;
    }
    public void setSpatialUnit(SpatialUnit value) {
        this.spatialUnit = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
