package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_LandUse;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_Level;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_SpatialRule", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_SpatialRule implements Serializable {
    private static final long serialVersionUID = -8417305500113625718L;
    
    private UUID id;
    private String code;
    private String description;
    
    private LA_Level levelOperand1;
    private HND_LandUse landUseOperand1;
    
    private LA_Level levelOperand2;
    private HND_LandUse landUseOperand2;
    
    private HND_RuleOperatorType ruleOperator;
    private HND_ComparisonOperatorType comparisonOperator;
    private Double comparisonParameterValue;
    private HND_RuleActionType action;
    
    
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
    
    @Column(name="Code", nullable=false)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name="Description", nullable=true)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    @ManyToOne(targetEntity=LA_Level.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_LevelID1", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_Level getLevelOperand1() {
        return levelOperand1;
    }
    public void setLevelOperand1(LA_Level levelOperand1) {
        this.levelOperand1 = levelOperand1;
    }
    
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="HND_LandUseID1", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public HND_LandUse getLandUseOperand1() {
        return landUseOperand1;
    }
    public void setLandUseOperand1(HND_LandUse landUseOperand1) {
        this.landUseOperand1 = landUseOperand1;
    }
    
    @ManyToOne(targetEntity=LA_Level.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LA_LevelID2", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public LA_Level getLevelOperand2() {
        return levelOperand2;
    }
    public void setLevelOperand2(LA_Level levelOperand2) {
        this.levelOperand2 = levelOperand2;
    }
    
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)    
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="HND_LandUseID2", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public HND_LandUse getLandUseOperand2() {
        return landUseOperand2;
    }
    public void setLandUseOperand2(HND_LandUse landUseOperand2) {
        this.landUseOperand2 = landUseOperand2;
    }
    
    
    @Column(name="RuleOperator", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_RuleOperatorType getRuleOperator() {
        return ruleOperator;
    }
    public void setRuleOperator(HND_RuleOperatorType ruleOperator) {
        this.ruleOperator = ruleOperator;
    }
    
    @Column(name="ComparisonOperator", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_ComparisonOperatorType getComparisonOperator() {
        return comparisonOperator;
    }
    public void setComparisonOperator(HND_ComparisonOperatorType comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }
    
    @Column(name="ComparisonParameterValue", nullable=true)
    public Double getComparisonParameterValue() {
        return comparisonParameterValue;
    }
    public void setComparisonParameterValue(Double comparisonParameterValue) {
        this.comparisonParameterValue = comparisonParameterValue;
    }
    
    @Column(name="Action", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_RuleActionType getAction() {
        return action;
    }
    public void setAction(HND_RuleActionType action) {
        this.action = action;
    }
    
    
    @Transient
    public boolean isDistanceRule() {
        return ruleOperator == HND_RuleOperatorType.DISTANCE;
    }
}
