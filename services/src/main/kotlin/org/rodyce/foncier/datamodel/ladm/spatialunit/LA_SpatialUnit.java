package org.rodyce.foncier.datamodel.ladm.spatialunit;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.rodyce.foncier.datamodel.commons.ILevel;
import org.rodyce.foncier.datamodel.commons.ISpatialUnit;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_BoundaryFace;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_BoundaryFaceString;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_Point;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_SpatialSource;
import org.rodyce.foncier.datamodel.ladm.special.VersionedObject;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_SpatialUnit", schema="ladm_spatialunit")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_SpatialUnit")
public class LA_SpatialUnit extends VersionedObject implements ISpatialUnit, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID suID;
    private LA_Point pointOfReference;
    private LA_Level level;
    private LA_SpatialUnit set;
    private LA_AreaValue area;
    private LA_DimensionType dimension;
    private UUID extAddressID;
    private String label;
    private Point referencePoint;
    private LA_LevelType surfaceRelation;
    private LA_VolumeValue volume;
    private java.util.Set<LA_BAUnit> baunits = new java.util.HashSet<LA_BAUnit>();
    private java.util.Set<LA_SpatialUnit> element = new java.util.HashSet<LA_SpatialUnit>();
    private java.util.Set<LA_SpatialUnitGroup> whole = new java.util.HashSet<LA_SpatialUnitGroup>();
    private java.util.Set<LA_SpatialSource> spatialSources = new java.util.HashSet<LA_SpatialSource>();
    private java.util.Set<LA_BoundaryFaceString> bfsMinus = new java.util.HashSet<LA_BoundaryFaceString>();
    private java.util.Set<LA_BoundaryFaceString> bfsPlus = new java.util.HashSet<LA_BoundaryFaceString>();
    private java.util.Set<LA_BoundaryFace> bfMinus = new java.util.HashSet<LA_BoundaryFace>();
    private java.util.Set<LA_BoundaryFace> bfPlus = new java.util.HashSet<LA_BoundaryFace>();
    private java.util.Set<LA_RequiredRelationshipSpatialUnit> requiredRelationshipSpatialUnits1 = new java.util.HashSet<LA_RequiredRelationshipSpatialUnit>();
    private java.util.Set<LA_RequiredRelationshipSpatialUnit> requiredRelationshipSpatialUnits2 = new java.util.HashSet<LA_RequiredRelationshipSpatialUnit>();

    
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
     * TODO: componer esto!
    @org.hibernate.annotations.Type(type="LA_AreaValueUserType")    
    @Columns(columns = {
            @Column(name = "areaValue_areaType"),
            @Column(name = "areaValue_areaSize")
    })
    */
    @Transient
    public LA_AreaValue getArea() {
        return area;
    }
    public void setArea(LA_AreaValue value) {
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
    
    @Column(name="ExtAddressID", nullable=true)    
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
    
    @Column(name="ReferencePoint", nullable=true)
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
    @org.hibernate.annotations.Type(type="LA_VolumeValueUserType")
    @Columns(columns = {
            @Column(name = "volumeValue_volumeType"),
            @Column(name = "volumeValue_volumeSize")
    })
    */
    @Transient
    public LA_VolumeValue getVolume() {
        return volume;
    }
    public void setVolume(LA_VolumeValue value) {
        this.volume = value;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @ManyToMany(mappedBy="spatialUnits", targetEntity=LA_BAUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public Set<LA_BAUnit> getBaunits() {
        return baunits;
    }
    public void setBaunits(Set<LA_BAUnit> value) {
        this.baunits = value;
    }
    
    @OneToMany(mappedBy="set", targetEntity=LA_SpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_SpatialUnit> getElement() {
        return element;
    }
    public void setElement(java.util.Set<LA_SpatialUnit> value) {
        this.element = value;
    }
    
    @ManyToMany(targetEntity=LA_SpatialUnitGroup.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_SpatialUnitGroup_LA_SpatialUnit", schema="ladm_spatialunit", joinColumns={ @JoinColumn(name="LA_SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_SpatialUnitGroupID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_SpatialUnitGroup> getWhole() {
        return whole;
    }
    public void setWhole(java.util.Set<LA_SpatialUnitGroup> value) {
        this.whole = value;
    }
    
    @ManyToMany(targetEntity=LA_SpatialSource.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_SpatialSource_LA_SpatialUnit", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_SpatialSourceLA_SourceID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_SpatialSource> getSpatialSources() {
        return spatialSources;
    }
    public void setSpatialSources(java.util.Set<LA_SpatialSource> value) {
        this.spatialSources = value;
    }
    
    @ManyToOne(targetEntity=LA_Level.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_LevelID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public LA_Level getLevel() {
        return level;
    }
    public void setLevel(LA_Level value) {
        this.level = value;
    }
    public void setLevel(ILevel value) {
        this.level = (LA_Level) value;
    }
    
    @ManyToMany(targetEntity=LA_BoundaryFaceString.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_BoundaryFaceString_LA_SpatialUnit", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_BoundaryFaceStringID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_BoundaryFaceString> getBfsMinus() {
        return bfsMinus;
    }
    public void setBfsMinus(java.util.Set<LA_BoundaryFaceString> value) {
        this.bfsMinus = value;
    }
    
    @ManyToMany(targetEntity=LA_BoundaryFaceString.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="LA_BoundaryFaceString_LA_SpatialUnit2", schema="ladm_spatialunit_surveyingandrepresentation", joinColumns={ @JoinColumn(name="LA_SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_BoundaryFaceStringID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_BoundaryFaceString> getBfsPlus() {
        return bfsPlus;
    }
    public void setBfsPlus(java.util.Set<LA_BoundaryFaceString> value) {
        this.bfsPlus = value;
    }
    
    @OneToOne(targetEntity=LA_Point.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_PointID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_Point getPointOfReference() {
        return pointOfReference;
    }
    public void setPointOfReference(LA_Point value) {
        this.pointOfReference = value;
    }
    
    
    @ManyToOne(targetEntity=LA_SpatialUnit.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_SpatialUnitID", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_SpatialUnit getSet() {
        return set;
    }
    public void setSet(LA_SpatialUnit value) {
        this.set = value;
    }
    
    
    @ManyToMany(targetEntity=LA_BoundaryFace.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @JoinTable(name="LA_SpatialUnit_LA_BoundaryFace", schema="ladm_spatialunit", joinColumns={ @JoinColumn(name="LA_SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_BoundaryFaceID") })    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_BoundaryFace> getBfMinus() {
        return bfMinus;
    }
    public void setBfMinus(java.util.Set<LA_BoundaryFace> value) {
        this.bfMinus = value;
    }
    
    @ManyToMany(targetEntity=LA_BoundaryFace.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_SpatialUnit_LA_BoundaryFace2", schema="ladm_spatialunit", joinColumns={ @JoinColumn(name="LA_SpatialUnitID") }, inverseJoinColumns={ @JoinColumn(name="LA_BoundaryFaceID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_BoundaryFace> getBfPlus() {
        return bfPlus;
    }
    public void setBfPlus(java.util.Set<LA_BoundaryFace> value) {
        this.bfPlus = value;
    }
    
    
    @OneToMany(mappedBy="spatialUnit1", targetEntity=LA_RequiredRelationshipSpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_RequiredRelationshipSpatialUnit> getRequiredRelationshipSpatialUnits1() {
        return requiredRelationshipSpatialUnits1;
    }
    public void setRequiredRelationshipSpatialUnits1(java.util.Set<LA_RequiredRelationshipSpatialUnit> value) {
        this.requiredRelationshipSpatialUnits1 = value;
    }
    
    @OneToMany(mappedBy="spatialUnit2", targetEntity=LA_RequiredRelationshipSpatialUnit.class)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})    
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)    
    public java.util.Set<LA_RequiredRelationshipSpatialUnit> getRequiredRelationshipSpatialUnits2() {
        return requiredRelationshipSpatialUnits2;
    }
    public void setRequiredRelationshipSpatialUnits2(java.util.Set<LA_RequiredRelationshipSpatialUnit> value) {
        this.requiredRelationshipSpatialUnits2 = value;
    }

    
    @Transient
    public boolean isAreaClosed() {
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
