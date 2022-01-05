package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="SpatialUnitGroup", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("SpatialUnitGroup")
public class SpatialUnitGroup extends AssociationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID sugID;
    private SpatialUnitGroup set;
    private int hierarchyLevel;
    private String label;
    private String name;
    private Point referencePoint;
    private java.util.Set<SpatialUnit> part = new java.util.HashSet<SpatialUnit>();
    private java.util.Set<SpatialUnitGroup> element = new java.util.HashSet<SpatialUnitGroup>();

    public SpatialUnitGroup() {
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
    
    @ManyToOne(targetEntity=SpatialUnitGroup.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="SpatialUnitGroupID", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public SpatialUnitGroup getSet() {
        return set;
    }
    public void setSet(SpatialUnitGroup value) {
        this.set = value;
    }
    
    @ManyToMany(mappedBy="whole", targetEntity=SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<SpatialUnit> getPart() {
        return part;
    }
    public void setPart(java.util.Set<SpatialUnit> value) {
        this.part = value;
    }
    
    @OneToMany(mappedBy="set", targetEntity=SpatialUnitGroup.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<SpatialUnitGroup> getElement() {
        return element;
    }
    public void setElement(java.util.Set<SpatialUnitGroup> value) {
        this.element = value;
    }
    
    
    public String toString() {
        return super.toString();
    }
    
}
