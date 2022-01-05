package org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation;

import java.io.Serializable;
import javax.persistence.*;

import org.rodyce.foncier.datamodel.ladm.party.LA_Party;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_SpatialSource", schema="ladm_spatialunit_surveyingandrepresentation")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_SpatialSource")
@PrimaryKeyJoinColumn(name="LA_SourceID", referencedColumnName="ID")
public class LA_SpatialSource extends org.rodyce.foncier.datamodel.ladm.special.LA_Source implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private byte measurements;
    private byte procedure;
    private LA_SpatialSourceType type;
    private java.util.Set<LA_Point> sourcePoint = new java.util.HashSet<LA_Point>();
    private java.util.Set<LA_Party> surveyor = new java.util.HashSet<LA_Party>();
    private java.util.Set<LA_SpatialUnit> units = new java.util.HashSet<LA_SpatialUnit>();
    private java.util.Set<LA_BAUnit> baUnits = new java.util.HashSet<LA_BAUnit>();
    private java.util.Set<LA_BoundaryFace> surfaceBoundaries = new java.util.HashSet<LA_BoundaryFace>();
    private java.util.Set<LA_BoundaryFaceString> boundaries = new java.util.HashSet<LA_BoundaryFaceString>();

    public LA_SpatialSource() {
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
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=LA_Point.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_Point> getSourcePoint() {
        return sourcePoint;
    }
    public void setSourcePoint(java.util.Set<LA_Point> value) {
        this.sourcePoint = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=LA_Party.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_Party> getSurveyor() {
        return surveyor;
    }
    public void setSurveyor(java.util.Set<LA_Party> value) {
        this.surveyor = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=LA_SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_SpatialUnit> getUnits() {
        return units;
    }
    public void setUnits(java.util.Set<LA_SpatialUnit> value) {
        this.units = value;
    }
    
    @ManyToMany(mappedBy="spatialSources", targetEntity=LA_BAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_BAUnit> getBaUnits() {
        return baUnits;
    }
    public void setBaUnits(java.util.Set<LA_BAUnit> value) {
        this.baUnits = value;
    }
    
    @OneToMany(mappedBy="spatialSources", targetEntity=LA_BoundaryFace.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_BoundaryFace> getSurfaceBoundaries() {
        return surfaceBoundaries;
    }
    public void setSurfaceBoundaries(java.util.Set<LA_BoundaryFace> value) {
        this.surfaceBoundaries = value;
    }
    
    @OneToMany(mappedBy="spatialSource", targetEntity=LA_BoundaryFaceString.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_BoundaryFaceString> getBoundaries() {
        return boundaries;
    }
    public void setBoundaries(java.util.Set<LA_BoundaryFaceString> value) {
        this.boundaries = value;
    }
    
    
    public String toString() {
        return super.toString();
    }
    
}
