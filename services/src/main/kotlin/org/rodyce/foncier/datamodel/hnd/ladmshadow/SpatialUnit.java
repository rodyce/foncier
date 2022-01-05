package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.ILevel;
import org.rodyce.foncier.datamodel.commons.ISpatialUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_DimensionType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_Level;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_LevelType;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="SpatialUnit", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("SpatialUnit")
public class SpatialUnit extends AssociationInfo implements ISpatialUnit, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID suID;
    private LAPoint pointOfReference;
    private LA_Level level;
    private SpatialUnit set;
    private AreaValue area;
    private LA_DimensionType dimension;
    private UUID extAddressID;
    private String label;
    private Point referencePoint;
    private LA_LevelType surfaceRelation;
    private VolumeValue volume;
    private java.util.Set<BAUnit> baunits = new java.util.HashSet<BAUnit>();
    private java.util.Set<SpatialUnit> element = new java.util.HashSet<SpatialUnit>();
    private java.util.Set<SpatialUnitGroup> whole = new java.util.HashSet<SpatialUnitGroup>();
    private java.util.Set<SpatialSource> spatialSources = new java.util.HashSet<SpatialSource>();
    private java.util.Set<RequiredRelationshipSpatialUnit> relSpatialUnits2requiredrelationshipspatialunits = new java.util.HashSet<RequiredRelationshipSpatialUnit>();
    private java.util.Set<BoundaryFaceString> bfsMinus = new java.util.HashSet<BoundaryFaceString>();
    private java.util.Set<BoundaryFaceString> bfsPlus = new java.util.HashSet<BoundaryFaceString>();
    private java.util.Set<RequiredRelationshipSpatialUnit> relSpatialUnits1requiredrelationshipspatialunits = new java.util.HashSet<RequiredRelationshipSpatialUnit>();
    private java.util.Set<BoundaryFace> bfMinus = new java.util.HashSet<BoundaryFace>();
    private java.util.Set<BoundaryFace> bfPlus = new java.util.HashSet<BoundaryFace>();
    
    public SpatialUnit() {
    }
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getSuID() {
        return suID;
    }
    public void setSuID(UUID value) {
        this.suID = value;
    }
    @Transient
    public UUID getORMID() {
        return getSuID();
    }
    
    /*
    @org.hibernate.annotations.Type(type="AreaValueUserType")    
    @Columns(columns = {
            @Column(name = "areaValue_areaType"),
            @Column(name = "areaValue_areaSize")
    })
    TODO: Eliminar transient
    */
    @Transient
    public AreaValue getArea() {
        return area;
    }
    public void setArea(AreaValue value) {
        this.area = value;
    }
    
    
    @Column(name="Dimension", nullable=true)    
    @Enumerated(EnumType.STRING)
    public LA_DimensionType getDimension() {
        return dimension;
    }
    public void setDimension(LA_DimensionType value) {
        this.dimension = value;
    }
    
    @Column(name="ExtAddressID", nullable=false)    
    public UUID getExtAddressID() {
        return extAddressID;
    }
    public void setExtAddressID(UUID value) {
        this.extAddressID = value;
    }
    
    @Column(name="Label", nullable=true, length=255)    
    public String getLabel() {
        return label;
    }
    public void setLabel(String value) {
        this.label = value;
    }
    
    @Column(name="ReferencePoint", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Point getReferencePoint() {
        return referencePoint;
    }
    public void setReferencePoint(Point value) {
        this.referencePoint = value;
    }
    
    @Column(name="SurfaceRelation", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_LevelType getSurfaceRelation() {
        return surfaceRelation;
    }
    public void setSurfaceRelation(LA_LevelType value) {
        this.surfaceRelation = value;
    }
    
    /*
     * TODO: CORREGIR
    @org.hibernate.annotations.Type(type="VolumeValueUserType")
    @Columns(columns = {
            @Column(name = "volumeValue_volumeType"),
            @Column(name = "volumeValue_volumeSize")
    })
    */
    @Transient
    public VolumeValue getVolume() {
        return volume;
    }
    public void setVolume(VolumeValue value) {
        this.volume = value;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @ManyToMany(mappedBy="spatialUnits", targetEntity=BAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<BAUnit> getBaunits() {
        return baunits;
    }
    public void setBaunits(java.util.Set<BAUnit> value) {
        this.baunits = value;
    }
    
    @OneToMany(mappedBy="set", targetEntity=SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<SpatialUnit> getElement() {
        return element;
    }
    public void setElement(java.util.Set<SpatialUnit> value) {
        this.element = value;
    }
    
    @ManyToMany(targetEntity=SpatialUnitGroup.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="SpatialUnitGroup_SpatialUnit", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="SpatialUnitGroupID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<SpatialUnitGroup> getWhole() {
        return whole;
    }
    public void setWhole(java.util.Set<SpatialUnitGroup> value) {
        this.whole = value;
    }
    
    @ManyToMany(targetEntity=SpatialSource.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="SpatialSource_SpatialUnit", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="SpatialSourceSourceID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(java.util.Set<SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @OneToMany(mappedBy="relSpatialUnits1spatialunit", targetEntity=RequiredRelationshipSpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<RequiredRelationshipSpatialUnit> getRelSpatialUnits2requiredrelationshipspatialunits() {
        return relSpatialUnits2requiredrelationshipspatialunits;
    }
    public void setRelSpatialUnits2requiredrelationshipspatialunits(java.util.Set<RequiredRelationshipSpatialUnit> value) {
        this.relSpatialUnits2requiredrelationshipspatialunits = value;
    }
    
    @ManyToOne(targetEntity=LA_Level.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LevelID", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_Level getLevel() {
        return level;
    }
    public void setLevel(ILevel value) {
        this.level = (LA_Level) value;
    }
    
    @ManyToMany(targetEntity=BoundaryFaceString.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="BoundaryFaceString_SpatialUnit", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="BoundaryFaceStringID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<BoundaryFaceString> getBfsMinus() {
        return bfsMinus;
    }
    public void setBfsMinus(java.util.Set<BoundaryFaceString> value) {
        this.bfsMinus = value;
    }
    
    @ManyToMany(targetEntity=BoundaryFaceString.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="BoundaryFaceString_SpatialUnit2", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="BoundaryFaceStringID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<BoundaryFaceString> getBfsPlus() {
        return bfsPlus;
    }
    public void setBfsPlus(java.util.Set<BoundaryFaceString> value) {
        this.bfsPlus = value;
    }
    
    @OneToOne(targetEntity=LAPoint.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="PointID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LAPoint getPointOfReference() {
        return pointOfReference;
    }
    public void setPointOfReference(LAPoint value) {
        this.pointOfReference = value;
    }
    
    
    @ManyToOne(targetEntity=SpatialUnit.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="SpatialUnitID", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public SpatialUnit getSet() {
        return set;
    }
    public void setSet(SpatialUnit value) {
        this.set = value;
    }
    
    @OneToMany(mappedBy="relSpatialUnits2spatialunit", targetEntity=RequiredRelationshipSpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<RequiredRelationshipSpatialUnit> getRelSpatialUnits1requiredrelationshipspatialunits() {
        return relSpatialUnits1requiredrelationshipspatialunits;
    }
    public void setRelSpatialUnits1requiredrelationshipspatialunits(java.util.Set<RequiredRelationshipSpatialUnit> value) {
        this.relSpatialUnits1requiredrelationshipspatialunits = value;
    }
    
    @ManyToMany(targetEntity=BoundaryFace.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="SpatialUnit_BoundaryFace", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="BoundaryFaceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<BoundaryFace> getBfMinus() {
        return bfMinus;
    }
    public void setBfMinus(java.util.Set<BoundaryFace> value) {
        this.bfMinus = value;
    }
    
    @ManyToMany(targetEntity=BoundaryFace.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="SpatialUnit_BoundaryFace2", schema="ladmshadow", joinColumns={ @JoinColumn(name="SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="BoundaryFaceID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<BoundaryFace> getBfPlus() {
        return bfPlus;
    }
    public void setBfPlus(java.util.Set<BoundaryFace> value) {
        this.bfPlus = value;
    }
    
    
    @Transient
    public boolean areaClosed() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }
    
    @Transient
    public boolean isVolumeClosed() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }
    
    @Transient
    public double computeArea() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }
    
    @Transient
    public double computeVolume() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }
    
    @Transient
    public byte createArea() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }
    
    @Transient
    public byte createVolume() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }
    
    public String toString() {
        return super.toString();
    }
    
}
