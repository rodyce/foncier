package org.rodyce.foncier.datamodel.hnd.administrative;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_LandUse;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_OperationPermit", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_OperationPermit extends HND_Permit implements Serializable {
    private static final long serialVersionUID = 6169384546161378943L;
    
    private HND_OperationPermitType type;
    private HND_BusinessType businessType;
    
    private HND_LandUse landUse;
    private List<HND_LandUse> otherLandUses = new ArrayList<HND_LandUse>();

    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_OperationPermitType getType() {
        return type;
    }
    public void setType(HND_OperationPermitType type) {
        this.type = type;
    }


    @ManyToOne(targetEntity=HND_BusinessType.class, optional=true, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="BusinessTypeID", referencedColumnName="id") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_BusinessType getBusinessType() {
        return businessType;
    }
    public void setBusinessType(HND_BusinessType businessType) {
        this.businessType = businessType;
    }


    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="LandUseID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_LandUse getLandUse() {
        return landUse;
    }
    public void setLandUse(HND_LandUse landUse) {
        this.landUse = landUse;
    }

    @ManyToMany(targetEntity=HND_LandUse.class)
    @JoinTable(name="HND_BuildingUnit__HND_LandUse", schema="hnd_cadastre", joinColumns={ @JoinColumn(name="HND_BuildingUnit__HND_LandUseID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public List<HND_LandUse> getOtherLandUses() {
        return otherLandUses;
    }
    public void setOtherLandUses(List<HND_LandUse> otherLandUses) {
        this.otherLandUses = otherLandUses;
    }
}
