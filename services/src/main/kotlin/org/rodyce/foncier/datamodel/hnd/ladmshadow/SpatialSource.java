package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import javax.persistence.*;

import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_SpatialSourceType;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="SpatialSource", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("SpatialSource")
@PrimaryKeyJoinColumn(name="SourceID", referencedColumnName="ID")
public class SpatialSource extends Source implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private byte measurements;
    private byte procedure;
    private LA_SpatialSourceType type;
    private java.util.Set<LAPoint> sourcePoint = new java.util.HashSet<LAPoint>();
    private java.util.Set<Party> surveyor = new java.util.HashSet<Party>();
    private java.util.Set<SpatialUnit> units = new java.util.HashSet<SpatialUnit>();
    private java.util.Set<BAUnit> baUnits = new java.util.HashSet<BAUnit>();
    private java.util.Set<BoundaryFace> surfaceBoundaries = new java.util.HashSet<BoundaryFace>();
    private java.util.Set<BoundaryFaceString> boundaries = new java.util.HashSet<BoundaryFaceString>();

    public SpatialSource() {
    }
    
    @Column(name="Measurements", nullable=false)    
    public byte getMeasurements() {
        return measurements;
    }
    public void setMeasurements(byte value) {
        this.measurements = value;
    }
    
    @Column(name="`Procedure`", nullable=false)    
    public byte getProcedure() {
        return procedure;
    }
    public void setProcedure(byte value) {
        this.procedure = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_SpatialSourceType getType() {
        return type;
    }
    public void setType(LA_SpatialSourceType value) {
        this.type = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=LAPoint.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LAPoint> getSourcePoint() {
        return sourcePoint;
    }
    public void setSourcePoint(java.util.Set<LAPoint> value) {
        this.sourcePoint = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=Party.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<Party> getSurveyor() {
        return surveyor;
    }
    public void setSurveyor(java.util.Set<Party> value) {
        this.surveyor = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialUnit> getUnits() {
        return units;
    }
    public void setUnits(java.util.Set<SpatialUnit> value) {
        this.units = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=BAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<BAUnit> getBaUnits() {
        return baUnits;
    }
    public void setBaUnits(java.util.Set<BAUnit> value) {
        this.baUnits = value;
    }
    
    @OneToMany(mappedBy="spatialSources", targetEntity=BoundaryFace.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<BoundaryFace> getSurfaceBoundaries() {
        return surfaceBoundaries;
    }
    public void setSurfaceBoundaries(java.util.Set<BoundaryFace> value) {
        this.surfaceBoundaries = value;
    }
    
    @OneToMany(mappedBy="spatialSource", targetEntity=BoundaryFaceString.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<BoundaryFaceString> getBoundaries() {
        return boundaries;
    }
    public void setBoundaries(java.util.Set<BoundaryFaceString> value) {
        this.boundaries = value;
    }
    
    
    public String toString() {
        return super.toString();
    }
    
}
