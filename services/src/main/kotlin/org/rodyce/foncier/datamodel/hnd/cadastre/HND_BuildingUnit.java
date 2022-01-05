package org.rodyce.foncier.datamodel.hnd.cadastre;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_BuildingPermit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_BuildingUnitType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_LegalSpaceBuildingUnit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_BuildingUnit", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="HND_BuildingUnitID", referencedColumnName="LA_SpatialUnitID")
public class HND_BuildingUnit extends HND_SpatialZone implements LA_LegalSpaceBuildingUnit, Serializable {
    private static final long serialVersionUID = 1L;

    private LA_BuildingUnitType type;

    private Integer numberOfFloors = 1;
    private BigDecimal builtArea;
    private BigDecimal value;
    
    private HND_BuildingType buildingType;
    private List<HND_BuildingMaterial> buildingMaterials = new ArrayList<HND_BuildingMaterial>();
    
    private HND_BuildingPermit buildingPermit;

    
    @Column(name="NumberOfFloors", nullable=false)
    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    
    @Column(name="BuiltArea", nullable=true, precision=24, scale=8)
    public BigDecimal getBuiltArea() {
        return builtArea;
    }
    public void setBuiltArea(BigDecimal builtArea) {
        this.builtArea = builtArea;
    }
    
    @Column(name="Value", nullable=true, precision=19, scale=4)
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    
    @ManyToOne(targetEntity=HND_BuildingType.class, optional=true, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="BuildingTypeID", referencedColumnName="id") })
    public HND_BuildingType getBuildingType() {
        return buildingType;
    }
    public void setBuildingType(HND_BuildingType buildingType) {
        this.buildingType = buildingType;
    }
    
    
    @ManyToMany(targetEntity=HND_BuildingMaterial.class, fetch=FetchType.LAZY)
    @JoinTable(name="HND_BuildingUnit__HND_BuildingMaterial", schema="hnd_cadastre", joinColumns={ @JoinColumn(name="HND_BuildingUnit__HND_BuildingMaterialID") })
    public List<HND_BuildingMaterial> getBuildingMaterials() {
        return buildingMaterials;
    }
    public void setBuildingMaterials(List<HND_BuildingMaterial> buildingMaterials) {
        this.buildingMaterials = buildingMaterials;
    }
    
    
    @OneToOne(targetEntity=HND_BuildingPermit.class, fetch=FetchType.LAZY, optional=true, mappedBy="buildingUnit")
    @JoinColumns({ @JoinColumn(name="BuildingPermitID") })
    public HND_BuildingPermit getBuildingPermit() {
        return buildingPermit;
    }
    public void setBuildingPermit(HND_BuildingPermit buildingPermit) {
        this.buildingPermit = buildingPermit;
    }
    
    
    @Override
    @Transient
    public UUID getBuildingUnitID() {
        return super.getSuID();
    }
    
    @Override
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_BuildingUnitType getType() {
        return type;
    }
    @Override
    public void setType(LA_BuildingUnitType value) {
        this.type = value;
    }
    
}
