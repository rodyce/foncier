package org.rodyce.foncier.datamodel.ladm.spatialunit;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_SpatialUnitGroup", schema="ladm_spatialunit")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_SpatialUnitGroup")
public class LA_SpatialUnitGroup extends org.rodyce.foncier.datamodel.ladm.special.VersionedObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID sugID;
    private LA_SpatialUnitGroup set;
    private int hierarchyLevel;
    private String label;
    private String name;
    private Point referencePoint;
    private java.util.Set<LA_SpatialUnit> part = new java.util.HashSet<LA_SpatialUnit>();
    private java.util.Set<LA_SpatialUnitGroup> element = new java.util.HashSet<LA_SpatialUnitGroup>();

    public LA_SpatialUnitGroup() {
    }
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getSugID() {
        return sugID;
    }
    protected void setSugID(UUID value) {
        this.sugID = value;
    }
    @Transient
    public UUID getORMID() {
        return getSugID();
    }
    
    @Column(name="HierarchyLevel", nullable=false)
    public int getHierarchyLevel() {
        return hierarchyLevel;
    }
    public void setHierarchyLevel(int value) {
        this.hierarchyLevel = value;
    }
    
    @Column(name="Label", nullable=true, length=255)
    public String getLabel() {
        return label;
    }
    public void setLabel(String value) {
        this.label = value;
    }
    
    @Column(name="Name", nullable=true, length=255)
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    
    @Column(name="ReferencePoint", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Point getReferencePoint() {
        return referencePoint;
    }
    public void setReferencePoint(Point value) {
        this.referencePoint = value;
    }
    
    @ManyToOne(targetEntity=LA_SpatialUnitGroup.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_SpatialUnitGroupID", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_SpatialUnitGroup getSet() {
        return set;
    }
    public void setSet(LA_SpatialUnitGroup value) {
        this.set = value;
    }
    
    @ManyToMany(mappedBy="whole", targetEntity=LA_SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_SpatialUnit> getPart() {
        return part;
    }
    public void setPart(java.util.Set<LA_SpatialUnit> value) {
        this.part = value;
    }
    
    @OneToMany(mappedBy="set", targetEntity=LA_SpatialUnitGroup.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_SpatialUnitGroup> getElement() {
        return element;
    }
    public void setElement(java.util.Set<LA_SpatialUnitGroup> value) {
        this.element = value;
    }
    
    
    public String toString() {
        return super.toString();
    }
    
}
