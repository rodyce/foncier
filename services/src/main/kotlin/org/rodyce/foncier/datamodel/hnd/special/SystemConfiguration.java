package org.rodyce.foncier.datamodel.hnd.special;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_PermitRuleGroup;

import com.vividsolutions.jts.geom.Geometry;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Table;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="SystemConfiguration", schema="hnd_special")
@Inheritance(strategy=InheritanceType.JOINED)
public class SystemConfiguration implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String municipalityName;
    private Integer srid;
    private String workingNamespace;
    private String logoURL;
    private String webSiteURL;
    private String userGuideURL;
    private String supportURL;
    private HND_PermitRuleGroup buildingPermitRuleGroup;
    private HND_PermitRuleGroup operationPermitRuleGroup;
    private Geometry jurisdictionShape;
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getId() {
        return id;
    }
    @SuppressWarnings("unused")
    private void setId(UUID id) {
        this.id = id;
    }

    @Column(name="MunicipalityName", nullable=true)
    public String getMunicipalityName() {
        return municipalityName;
    }
    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    @Column(name="srid", nullable=false)
    public Integer getSrid() {
        return srid;
    }
    public void setSrid(Integer srid) {
        this.srid = srid;
    }
    
    @Column(name="WorkingNamespace", nullable=false)
    public String getWorkingNamespace() {
        return workingNamespace;
    }
    public void setWorkingNamespace(String workingNamespace) {
        this.workingNamespace = workingNamespace;
    }
    
    @Column(name="LogoURL", nullable=true)
    public String getLogoURL() {
        return logoURL;
    }
    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }
    
    @Column(name="WebSiteURL", nullable=true)
    public String getWebSiteURL() {
        return webSiteURL;
    }
    public void setWebSiteURL(String webSiteURL) {
        this.webSiteURL = webSiteURL;
    }

    @Column(name="UserGuideURL", nullable=true)
    public String getUserGuideURL() {
        return userGuideURL;
    }
    public void setUserGuideURL(String userGuideURL) {
        this.userGuideURL = userGuideURL;
    }

    @Column(name="SupportURL", nullable=true)
    public String getSupportURL() {
        return supportURL;
    }
    public void setSupportURL(String supportURL) {
        this.supportURL = supportURL;
    }
    
    
    @ManyToOne(targetEntity=HND_PermitRuleGroup.class, optional=true, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="BuildingPermitRuleGroupID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_PermitRuleGroup getBuildingPermitRuleGroup() {
        return buildingPermitRuleGroup;
    }
    public void setBuildingPermitRuleGroup(
            HND_PermitRuleGroup buildingPermitRuleGroup) {
        this.buildingPermitRuleGroup = buildingPermitRuleGroup;
    }

    @ManyToOne(targetEntity=HND_PermitRuleGroup.class, optional=true, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="OperationPermitRuleGroupID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_PermitRuleGroup getOperationPermitRuleGroup() {
        return operationPermitRuleGroup;
    }
    public void setOperationPermitRuleGroup(
            HND_PermitRuleGroup operationPermitRuleGroup) {
        this.operationPermitRuleGroup = operationPermitRuleGroup;
    }

    @Column(name="JurisdictionShape", nullable=true)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Geometry getJurisdictionShape() {
        return jurisdictionShape;
    }
    public void setJurisdictionShape(Geometry jurisdictionShape) {
        this.jurisdictionShape = jurisdictionShape;
    }
}
