package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.MultiLineString;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="BoundaryFaceString", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
public class BoundaryFaceString extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID bfsID;
    private SpatialSource spatialSource;
    private MultiLineString geometry;
    private String locationByText;
    private java.util.Set<LAPoint> relatedPoints = new java.util.HashSet<LAPoint>();
    private java.util.Set<SpatialUnit> suMinus = new java.util.HashSet<SpatialUnit>();
    private java.util.Set<SpatialUnit> suPlus = new java.util.HashSet<SpatialUnit>();

    public BoundaryFaceString() {
    }
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getBfsID() {
        return bfsID;
    }
    protected void setBfsID(UUID value) {
        this.bfsID = value;
    }
    @Transient
    public UUID getORMID() {
        return getBfsID();
    }
    
    @Column(name="Geometry", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public MultiLineString getGeometry() {
        return geometry;
    }
    public void setGeometry(MultiLineString value) {
        this.geometry = value;
    }
    
    @Column(name="LocationByText", nullable=true, length=255)
    public String getLocationByText() {
        return locationByText;
    }
    public void setLocationByText(String value) {
        this.locationByText = value;
    }
    
    @ManyToMany(mappedBy="boundaries", targetEntity=LAPoint.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LAPoint> getRelatedPoints() {
        return relatedPoints;
    }
    public void setRelatedPoints(java.util.Set<LAPoint> value) {
        this.relatedPoints = value;
    }
    
    @ManyToOne(targetEntity=SpatialSource.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="SpatialSourceSourceID", referencedColumnName="SourceID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public SpatialSource getSpatialSource() {
        return spatialSource;
    }
    public void setSpatialSource(SpatialSource value) {
        this.spatialSource = value;
    }
    
    @ManyToMany(mappedBy="bfsMinus", targetEntity=SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialUnit> getSuMinus() {
        return suMinus;
    }
    public void setSuMinus(java.util.Set<SpatialUnit> value) {
        this.suMinus = value;
    }
    
    @ManyToMany(mappedBy="bfsPlus", targetEntity=SpatialUnit.class)    
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
