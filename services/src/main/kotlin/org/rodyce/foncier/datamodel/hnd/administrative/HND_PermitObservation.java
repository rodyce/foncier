package org.rodyce.foncier.datamodel.hnd.administrative;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_SpatialZone;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_PermitObservation", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_PermitObservation {
    private UUID id;
    private String spatialRuleName;
    private String spatialRuleDescription;
    private String spatialRuleDetails;
    private String analystObservation;
    private HND_RuleActionType action;
    
    private HND_SpatialZone targetSpatialZone;
    private HND_Permit permit;
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    
    
    @Column(name="SpatialRuleName", nullable=true)
    public String getSpatialRuleName() {
        return spatialRuleName;
    }
    public void setSpatialRuleName(String spatialRuleName) {
        this.spatialRuleName = spatialRuleName;
    }
    
    @Column(name="SpatialRuleDescription", nullable=true)
    public String getSpatialRuleDescription() {
        return spatialRuleDescription;
    }
    public void setSpatialRuleDescription(String spatialRuleDescription) {
        this.spatialRuleDescription = spatialRuleDescription;
    }
    
    @Column(name="SpatialRuleDetails", nullable=true)
    public String getSpatialRuleDetails() {
        return spatialRuleDetails;
    }
    public void setSpatialRuleDetails(String spatialRuleDetails) {
        this.spatialRuleDetails = spatialRuleDetails;
    }
    
    @Column(name="AnalystObservation", nullable=true)
    public String getAnalystObservation() {
        return analystObservation;
    }
    public void setAnalystObservation(String analystObservation) {
        this.analystObservation = analystObservation;
    }

    @Column(name="Action", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_RuleActionType getAction() {
        return action;
    }
    public void setAction(HND_RuleActionType action) {
        this.action = action;
    }

    @ManyToOne(targetEntity=HND_SpatialZone.class, fetch=FetchType.LAZY, optional=false)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="LA_SpatialUnitID", referencedColumnName="LA_SpatialUnitID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_SpatialZone getTargetSpatialZone() {
        return targetSpatialZone;
    }
    public void setTargetSpatialZone(HND_SpatialZone targetSpatialZone) {
        this.targetSpatialZone = targetSpatialZone;
    }
    
    @ManyToOne(targetEntity=HND_Permit.class, fetch=FetchType.LAZY, optional=false)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="HND_PermitID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_Permit getPermit() {
        return permit;
    }
    public void setPermit(HND_Permit permit) {
        this.permit = permit;
    }

}
