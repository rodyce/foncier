package org.rodyce.foncier.datamodel.hnd.administrative;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_BuildingUnit;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_BuildingPermit", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_BuildingPermit extends HND_Permit implements Serializable {
    private static final long serialVersionUID = -2848708138378243186L;
    
    private HND_BuildingPermitType type;
    private HND_BuildingUnit buildingUnit;

    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_BuildingPermitType getType() {
        return type;
    }
    public void setType(HND_BuildingPermitType type) {
        this.type = type;
    }

    @OneToOne(targetEntity=HND_BuildingUnit.class, fetch=FetchType.LAZY, optional=false)
    @JoinColumns({ @JoinColumn(name="BuildingUnitID") })
    public HND_BuildingUnit getBuildingUnit() {
        if (buildingUnit == null)
            buildingUnit = new HND_BuildingUnit();
        return buildingUnit;
    }
    public void setBuildingUnit(HND_BuildingUnit buildingUnit) {
        this.buildingUnit = buildingUnit;
    }
}
