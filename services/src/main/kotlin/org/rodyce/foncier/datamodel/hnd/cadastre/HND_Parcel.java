package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.rodyce.foncier.datamodel.commons.IEasement;
import org.rodyce.foncier.datamodel.commons.IImprovement;
import org.rodyce.foncier.datamodel.commons.IParcel;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_RequiredRelationshipSpatialUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnit;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_SpatialUnitGroup;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_BoundaryFace;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_BoundaryFaceString;
import org.rodyce.foncier.datamodel.ladm.spatialunit.surveyingandrepresentation.LA_SpatialSource;

import com.vividsolutions.jts.geom.Polygon;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_Parcel", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="HND_SpatialZoneID", referencedColumnName="LA_SpatialUnitID")
public class HND_Parcel extends HND_SpatialZone implements Serializable, Cloneable, IParcel {
    private static final long serialVersionUID = 1L;

    private String fieldTab;
    private String cadastralKey;
    private String municipalKey;
    
    private BigDecimal documentedBuiltArea;
    private BigDecimal groundBuiltArea;
    private String neighborhood;
    private String accessWay1;
    private String accessWay2;
    private String houseNumber;
    
    private BigDecimal commercialAppraisal;
    private BigDecimal fiscalAppraisal;
    private BigDecimal taxationBalanceDue;
    private Date taxationInfoLastUpdate;
    private String taxationInfoSource;
    private HND_DevelopmentStatusType developmentStatus; 
    
    private HND_AvailableServices availableServices = new HND_AvailableServices();
    private List<HND_Easement> easements = new ArrayList<HND_Easement>();
    private List<HND_Improvement> improvements = new ArrayList<HND_Improvement>();
    
    
    
    @Transient
    @Override
    public Polygon getShape() {
        return (Polygon) super.getShape();
    }
    public void setShape(Polygon shape) {
        super.setShape(shape);
    }

    @Column(name="FieldTab", nullable=true)
    public String getFieldTab() {
        return fieldTab;
    }
    public void setFieldTab(String fieldTab) {
        this.fieldTab = fieldTab;
    }
    
    @Column(name="CadastralKey", nullable=true)
    public String getCadastralKey() {
        return cadastralKey;
    }
    public void setCadastralKey(String cadastralKey) {
        this.cadastralKey = cadastralKey;
    }
    
    @Column(name="MunicipalKey", nullable=true)
    public String getMunicipalKey() {
        return municipalKey;
    }
    public void setMunicipalKey(String municipalKey) {
        this.municipalKey = municipalKey;
    }
    
    
    @Column(name="DocumentedBuiltArea", nullable=true, precision=24, scale=8)
    public BigDecimal getDocumentedBuiltArea() {
        return documentedBuiltArea;
    }
    public void setDocumentedBuiltArea(BigDecimal documentedBuiltArea) {
        this.documentedBuiltArea = documentedBuiltArea;
    }
    
    @Column(name="GroundBuiltArea", nullable=true, precision=24, scale=8)
    public BigDecimal getGroundBuiltArea() {
        return groundBuiltArea;
    }
    public void setGroundBuiltArea(BigDecimal groundBuiltArea) {
        this.groundBuiltArea = groundBuiltArea;
    }
    
    @Column(name="Neighborhood", nullable=true)
    public String getNeighborhood() {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    
    @Column(name="AccessWay1", nullable=true)
    public String getAccessWay1() {
        return accessWay1;
    }
    public void setAccessWay1(String accessWay1) {
        this.accessWay1 = accessWay1;
    }
    
    @Column(name="AccessWay2", nullable=true)
    public String getAccessWay2() {
        return accessWay2;
    }
    public void setAccessWay2(String accessWay2) {
        this.accessWay2 = accessWay2;
    }
    
    @Column(name="HouseNumber", nullable=true)
    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    @Column(name="CommercialAppraisal", nullable=true, precision=19, scale=4)
    public BigDecimal getCommercialAppraisal() {
        return commercialAppraisal;
    }
    public void setCommercialAppraisal(BigDecimal commercialAppraisal) {
        if (getSuID() == null && commercialAppraisal != null || this.commercialAppraisal != commercialAppraisal)
            setTaxationInfoLastUpdate(new Date());
        this.commercialAppraisal = commercialAppraisal;
    }
    
    @Column(name="FiscalAppraisal", nullable=true, precision=19, scale=4)
    public BigDecimal getFiscalAppraisal() {
        return fiscalAppraisal;
    }
    public void setFiscalAppraisal(BigDecimal fiscalAppraisal) {
        if (getSuID() == null &&  fiscalAppraisal != null || this.fiscalAppraisal != fiscalAppraisal)
            setTaxationInfoLastUpdate(new Date());
        this.fiscalAppraisal = fiscalAppraisal;
    }
    
    @Column(name="TaxationBalanceDue", nullable=true, precision=19, scale=4)
    public BigDecimal getTaxationBalanceDue() {
        return taxationBalanceDue;
    }
    public void setTaxationBalanceDue(BigDecimal taxationBalanceDue) {
        if (getSuID() == null && taxationBalanceDue != null || this.taxationBalanceDue != taxationBalanceDue)
            setTaxationInfoLastUpdate(new Date());
        this.taxationBalanceDue = taxationBalanceDue;
    }
    
    @Column(name="TaxationInfoSource", nullable=true)
    public String getTaxationInfoSource() {
        return taxationInfoSource;
    }
    public void setTaxationInfoSource(String taxationInfoSource) {
        this.taxationInfoSource = taxationInfoSource;
    }
    
    @Column(name="DevelopmentStatus", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_DevelopmentStatusType getDevelopmentStatus() {
        return developmentStatus;
    }
    public void setDevelopmentStatus(HND_DevelopmentStatusType developmentStatus) {
        this.developmentStatus = developmentStatus;
    }

    @Column(name="TaxationInfoLastUpdate", nullable=true)
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getTaxationInfoLastUpdate() {
        return taxationInfoLastUpdate;
    }
    protected void setTaxationInfoLastUpdate(Date taxationInfoLastUpdate) {
        this.taxationInfoLastUpdate = taxationInfoLastUpdate;
    }
    

    @Transient
    public HND_TaxationStatusType getTaxationStatus() {
        if ( getTaxationBalanceDue() == null ) return HND_TaxationStatusType.UNKNOWN;
        
        return getTaxationBalanceDue().compareTo(BigDecimal.ZERO) == 0 ? HND_TaxationStatusType.SOLVENT : HND_TaxationStatusType.INSOLVENT;
    }
    public void setTaxationStatus(HND_TaxationStatusType taxationStatus) {
    }
    
    @Override
    @Embedded
    public HND_AvailableServices getAvailableServices() {
        return availableServices;
    }
    @Override
    public void setAvailableServices(HND_AvailableServices availableServices) {
        this.availableServices = availableServices;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @OneToMany(targetEntity=HND_Easement.class, fetch=FetchType.LAZY)
    @JoinTable(name="HND_Parcel__HND_Easement", schema="hnd_cadastre")
    public List<HND_Easement> getEasements() {
        return easements;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void setEasements(List<? extends IEasement> easements) {
        this.easements = (List<HND_Easement>) easements;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @OneToMany(targetEntity=HND_Improvement.class, fetch=FetchType.LAZY)
    @JoinTable(name="HND_Parcel__HND_Improvement", schema="hnd_cadastre")
    public List<HND_Improvement> getImprovements() {
        return improvements;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void setImprovements(List<? extends IImprovement> improvements) {
        this.improvements = (List<HND_Improvement>) improvements;
    }


    @Override
    public HND_Parcel clone() {
        try {
            HND_Parcel clonedHndParcel = (HND_Parcel) super.clone();
            
            //this is in order to mark the object as unsaved
            clonedHndParcel.setSuID(null);
            
            Set<LA_BAUnit> baunits = new HashSet<LA_BAUnit>(getBaunits());
            Set<LA_SpatialUnit> element = new HashSet<LA_SpatialUnit>(getElement());
            Set<LA_SpatialUnitGroup> whole = new HashSet<LA_SpatialUnitGroup>(getWhole());
            Set<LA_SpatialSource> spatialSources = new HashSet<LA_SpatialSource>(getSpatialSources());
            Set<LA_RequiredRelationshipSpatialUnit> requiredRelationshipSpatialUnits1 = new HashSet<LA_RequiredRelationshipSpatialUnit>(getRequiredRelationshipSpatialUnits1());
            Set<LA_RequiredRelationshipSpatialUnit> requiredRelationshipSpatialUnits2 = new HashSet<LA_RequiredRelationshipSpatialUnit>(getRequiredRelationshipSpatialUnits2());
            Set<LA_BoundaryFaceString> bfsMinus = new HashSet<LA_BoundaryFaceString>(getBfsMinus());
            Set<LA_BoundaryFaceString> bfsPlus = new HashSet<LA_BoundaryFaceString>(getBfsPlus());
            Set<LA_BoundaryFace> bfMinus = new HashSet<LA_BoundaryFace>(getBfMinus());
            Set<LA_BoundaryFace> bfPlus = new HashSet<LA_BoundaryFace>(getBfPlus());
            List<HND_LandUse> otherLandUses = new ArrayList<HND_LandUse>(getOtherLandUses());
            
            //Parcel attributes
            List<HND_Easement> easements = new ArrayList<HND_Easement>(getEasements());
            List<HND_Improvement> improvements = new ArrayList<HND_Improvement>(getImprovements());
            
            //special
            clonedHndParcel.setLevel(getLevel());
            
            clonedHndParcel.setBaunits(baunits);
            clonedHndParcel.setElement(element);
            clonedHndParcel.setWhole(whole);
            clonedHndParcel.setSpatialSources(spatialSources);
            clonedHndParcel.setRequiredRelationshipSpatialUnits1(requiredRelationshipSpatialUnits1);
            clonedHndParcel.setRequiredRelationshipSpatialUnits2(requiredRelationshipSpatialUnits2);
            clonedHndParcel.setBfsMinus(bfsMinus);
            clonedHndParcel.setBfsPlus(bfsPlus);
            clonedHndParcel.setBfMinus(bfMinus);
            clonedHndParcel.setBfPlus(bfPlus);
            clonedHndParcel.setLandUse(getLandUse());
            clonedHndParcel.setProposedLandUse(getProposedLandUse());
            clonedHndParcel.setOtherLandUses(otherLandUses);
            
            //Parcel attributes
            clonedHndParcel.setEasements(easements);
            clonedHndParcel.setImprovements(improvements);
            clonedHndParcel.setShape((Polygon) getShape().clone());
    
            return clonedHndParcel;
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        return this;
    }
}
