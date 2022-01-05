package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.rodyce.foncier.datamodel.commons.ISpatialZone;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_Permit;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_PermitType;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_Property;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_SpatialZoneInTransaction;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_TopographicTransaction;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_Transaction;
import org.rodyce.foncier.datamodel.hnd.special.HND_Lock;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_SpatialZone", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="LA_SpatialUnitID", referencedColumnName="ID")
public class HND_SpatialZone extends LA_SpatialUnit implements Serializable, Cloneable, ISpatialZone {
    private static final long serialVersionUID = 1L;

    private Geometry shape;
    private String zoneName;
    private String locationInCountry;
    private BigDecimal geometryPerimeter;
    private BigDecimal measuredPerimeter;
    private BigDecimal documentedPerimeter;
    private BigDecimal geometryArea;
    private BigDecimal measuredArea;
    private BigDecimal documentedArea;
    private HND_PermitType pendingPermitType;

    private HND_LandUse landUse;
    private HND_LandUse proposedLandUse;
    private List<HND_LandUse> otherLandUses = new ArrayList<HND_LandUse>();

    private HND_Transaction originatingTransaction;
    private Set<HND_SpatialZoneInTransaction> spatialZoneInTransactions = new HashSet<HND_SpatialZoneInTransaction>();
    private Set<HND_SpatialZoneAttrValue> spatialZoneAttrValues = new HashSet<HND_SpatialZoneAttrValue>();
    private List<HND_TopographicTransaction> maintenanceSessions = new ArrayList<HND_TopographicTransaction>();

    private transient HND_PermitNorm permitNorm;
    private Set<HND_Permit> permits = new HashSet<HND_Permit>();
    
    private Integer maxNumberOfFloors;
    private BigDecimal maxBuiltArea;
    private List<HND_BuildingMaterial> forbiddenBuildingMaterials = new ArrayList<HND_BuildingMaterial>();

    private String endLifespanReason;
    private HND_Lock lock = new HND_Lock();

    
    @Column(name="Shape", nullable=true)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Geometry getShape() {
        return shape;
    }
    public void setShape(Geometry value) {
        if (this.shape == null || !this.shape.equalsExact(value)) {
            this.shape = value;
            
            if (value != null) {
                Point newRefPoint = value.getCentroid();
                newRefPoint.setSRID(value.getSRID());
                this.setReferencePoint(newRefPoint);
            }
        }
    }
    
    @Column(name="ZoneName", nullable=true)
    public String getZoneName() {
        return zoneName;
    }
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    
    @Column(name="LocationInCountry", nullable=true)
    public String getLocationInCountry() {
        return locationInCountry;
    }
    public void setLocationInCountry(String locationInCountry) {
        this.locationInCountry = locationInCountry;
    }

    @Transient
    public BigDecimal getGeometryPerimeter() {
        if (geometryPerimeter == null) {
            Geometry s = getShape();
            if (s != null) {
                geometryPerimeter = new BigDecimal(s.getLength(), new MathContext(24));
                geometryPerimeter = geometryPerimeter.setScale(8, RoundingMode.HALF_UP);
            }
        }
        return geometryPerimeter;
    }
    public void setGeometryPerimeter(BigDecimal geometryPerimeter) {
        //do nothing
    }
    
    @Column(name="MeasuredPerimeter", nullable=true, precision=24, scale=8)
    public BigDecimal getMeasuredPerimeter() {
        return measuredPerimeter;
    }
    public void setMeasuredPerimeter(BigDecimal measuredPerimeter) {
        this.measuredPerimeter = measuredPerimeter;
    }
    
    @Column(name="DocumentedPerimeter", nullable=true, precision=24, scale=8)
    public BigDecimal getDocumentedPerimeter() {
        return documentedPerimeter;
    }
    public void setDocumentedPerimeter(BigDecimal documentedPerimeter) {
        this.documentedPerimeter = documentedPerimeter;
    }
    
    @Transient
    public BigDecimal getGeometryArea() {
        if (geometryArea == null) {
            Geometry s = getShape();
            if (s != null) {
                geometryArea = new BigDecimal(s.getArea(), new MathContext(24));
                geometryArea = geometryArea.setScale(8, RoundingMode.HALF_UP);
            }
        }
        return geometryArea;
    }
    public void setGeometryArea(BigDecimal geometryArea) {
        //do nothing
    }
    
    @Column(name="DocumentedArea", nullable=true, precision=24, scale=8)
    public BigDecimal getDocumentedArea() {
        return documentedArea;
    }
    public void setDocumentedArea(BigDecimal documentedArea) {
        this.documentedArea = documentedArea;
    }
    
    @Column(name="MeasuredArea", nullable=true, precision=24, scale=8)
    public BigDecimal getMeasuredArea() {
        return measuredArea;
    }
    public void setMeasuredArea(BigDecimal measuredArea) {
        this.measuredArea = measuredArea;
    }
    
    @Column(name="PendingPermitType", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_PermitType getPendingPermitType() {
        return pendingPermitType;
    }
    public void setPendingPermitType(HND_PermitType pendingPermitType) {
        this.pendingPermitType = pendingPermitType;
    }
    
    @ManyToOne(targetEntity=HND_Transaction.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="OriginatingTransactionID", referencedColumnName="ID") })    
    public HND_Transaction getOriginatingTransaction() {
        return originatingTransaction;
    }
    public void setOriginatingTransaction(HND_Transaction originatingTransaction) {
        this.originatingTransaction = originatingTransaction;
    }

    @OneToMany(mappedBy="spatialZone", targetEntity=HND_SpatialZoneInTransaction.class)    
    public Set<HND_SpatialZoneInTransaction> getSpatialZoneInTransactions() {
        return spatialZoneInTransactions;
    }
    public void setSpatialZoneInTransactions(Set<HND_SpatialZoneInTransaction> spatialZoneInTransactions) {
        this.spatialZoneInTransactions = spatialZoneInTransactions;
    }

    
    @Override
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="LandUseID") })
    public HND_LandUse getLandUse() {
        return landUse;
    }
    @Override
    public void setLandUse(HND_LandUse landUse) {
        this.landUse = landUse;
    }
    
    @Override
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="ProposedLandUseID") })
    public HND_LandUse getProposedLandUse() {
        return proposedLandUse;
    }
    @Override
    public void setProposedLandUse(HND_LandUse proposedLandUse) {
        this.proposedLandUse = proposedLandUse;
    }

    @Override
    @ManyToMany(targetEntity=HND_LandUse.class)
    @JoinTable(name="HND_SpatialZone__HND_LandUse", schema="hnd_cadastre", joinColumns={ @JoinColumn(name="HND_SpatialZone__HND_LandUseID") })
    public List<HND_LandUse> getOtherLandUses() {
        return otherLandUses;
    }
    @Override
    public void setOtherLandUses(List<HND_LandUse> otherLandUses) {
        this.otherLandUses = otherLandUses;
    }
    
    
    @OneToMany(mappedBy="spatialZone", targetEntity=HND_SpatialZoneAttrValue.class)
    public Set<HND_SpatialZoneAttrValue> getSpatialZoneAttrValues() {
        return spatialZoneAttrValues;
    }
    public void setSpatialZoneAttrValues(
            Set<HND_SpatialZoneAttrValue> spatialZoneAttrValues) {
        this.spatialZoneAttrValues = spatialZoneAttrValues;
    }

    //TODO filter maintenance transactions from spatialZoneInTransaction
    @Transient
    public List<HND_TopographicTransaction> getMaintenanceSessions() {
        return maintenanceSessions;
    }
    public void setMaintenanceSessions(
            List<HND_TopographicTransaction> maintenanceSessions) {
        this.maintenanceSessions = maintenanceSessions;
    }

    @Transient
    public HND_PermitNorm getPermitNorm() {
        if (permitNorm == null)
            permitNorm = new HND_PermitNorm(this);
        return permitNorm;
    }
    public void setPermitNorm(HND_PermitNorm permitNorm) {
        this.permitNorm = permitNorm;
    }

    @OneToMany(mappedBy="selectedZone", targetEntity=HND_Permit.class)
    public Set<HND_Permit> getPermits() {
        return permits;
    }
    public void setPermits(Set<HND_Permit> permits) {
        this.permits = permits;
    }
    
    
    @Column(name="MaxNumberOfFloors", nullable=true)
    public Integer getMaxNumberOfFloors() {
        return maxNumberOfFloors;
    }
    public void setMaxNumberOfFloors(Integer maxNumberOfFloors) {
        this.maxNumberOfFloors = maxNumberOfFloors;
    }
    
    @Column(name="MaxBuiltArea", nullable=true, precision=24, scale=8)
    public BigDecimal getMaxBuiltArea() {
        return maxBuiltArea;
    }
    public void setMaxBuiltArea(BigDecimal maxBuiltArea) {
        this.maxBuiltArea = maxBuiltArea;
    }
    
    @ManyToMany(targetEntity=HND_BuildingMaterial.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    @JoinTable(name="HND_SpatialZoneForbiddenBuildingMaterials", schema="hnd_administrative",
            joinColumns={ @JoinColumn(name="HND_SpatialZoneID") }, inverseJoinColumns={ @JoinColumn(name="HND_BuildingMaterialID") },
            uniqueConstraints={ @UniqueConstraint(columnNames={"HND_SpatialZoneID", "HND_BuildingMaterialID"}) })
    public List<HND_BuildingMaterial> getForbiddenBuildingMaterials() {
        return forbiddenBuildingMaterials;
    }
    public void setForbiddenBuildingMaterials(
            List<HND_BuildingMaterial> forbiddenBuildingMaterials) {
        this.forbiddenBuildingMaterials = forbiddenBuildingMaterials;
    }

    
    @Column(name="EndLifespanReason", nullable=true)
    public String getEndLifespanReason() {
        return endLifespanReason;
    }
    public void setEndLifespanReason(String endLifespanReason) {
        this.endLifespanReason = endLifespanReason;
    }
    
    
    @Embedded
    public HND_Lock getLock() {
        return lock;
    }
    public void setLock(HND_Lock lock) {
        this.lock = lock;
    }
    
    
    @Transient
    public HND_Property getProperty() {
        HND_Property hndProp = null;
        
        Set<LA_BAUnit> baUnitSet = super.getBaunits();
        if (baUnitSet.size() > 0) {
            for (LA_BAUnit baUnit : baUnitSet) {
                if (baUnit instanceof HND_Property) {
                    hndProp = (HND_Property) baUnit;
                    break;
                }
            }
        }
        else {
            hndProp = new HND_Property();
            baUnitSet.add(hndProp);
            hndProp.getSpatialUnits().add(this);
        }
        
        return hndProp;
    }
    
    @Transient
    public boolean hasPendingPermit() {
        return pendingPermitType != null;
    }
}
