package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.IEasement;
import org.rodyce.foncier.datamodel.commons.IImprovement;
import org.rodyce.foncier.datamodel.commons.IParcel;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_AvailableServices;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_DevelopmentStatusType;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_LandUse;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_TaxationStatusType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
import javax.persistence.Transient;

import com.vividsolutions.jts.geom.Polygon;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Parcel", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="SpatialZoneID", referencedColumnName="SpatialUnitID")
public class Parcel extends SpatialZone implements Serializable, Cloneable, IParcel {
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
    private HND_DevelopmentStatusType developmentStatus;

    private HND_AvailableServices availableServices = new HND_AvailableServices();
    private List<Easement> easements = new ArrayList<Easement>();
    private List<Improvement> improvements = new ArrayList<Improvement>();

    
    protected Parcel() {
    }
    
    public static Parcel newParcel(UUID ladmId, long presentationNo, boolean isReadOnly, boolean isSnapshot) {
        Parcel parcel = new Parcel();
        
        parcel.setLadmId(ladmId);
        parcel.setPresentationNo(presentationNo);
        parcel.setReadOnly(isReadOnly);
        parcel.setSnapshot(isSnapshot);
        
        return parcel;
    }
    
    public static Parcel newDummyParcel() {
        return new Parcel();
    }
    
    
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
    
    @Column(name="CommercialAppraisal", nullable=true, precision=24, scale=8)
    public BigDecimal getCommercialAppraisal() {
        return commercialAppraisal;
    }
    public void setCommercialAppraisal(BigDecimal commercialAppraisal) {
        this.commercialAppraisal = commercialAppraisal;
    }
    
    @Column(name="FiscalAppraisal", nullable=true, precision=24, scale=8)
    public BigDecimal getFiscalAppraisal() {
        return fiscalAppraisal;
    }
    public void setFiscalAppraisal(BigDecimal fiscalAppraisal) {
        this.fiscalAppraisal = fiscalAppraisal;
    }
    
    @Column(name="TaxationBalanceDue", nullable=true, precision=24, scale=8)
    public BigDecimal getTaxationBalanceDue() {
        return taxationBalanceDue;
    }
    public void setTaxationBalanceDue(BigDecimal taxationBalanceDue) {
        this.taxationBalanceDue = taxationBalanceDue;
    }
    
    @Transient
    public HND_TaxationStatusType getTaxationStatus() {
        if ( getTaxationBalanceDue() == null ) return HND_TaxationStatusType.UNKNOWN;
        
        return getTaxationBalanceDue().compareTo(BigDecimal.ZERO) == 0 ? HND_TaxationStatusType.SOLVENT : HND_TaxationStatusType.INSOLVENT;
    }
    public void setTaxationStatus(HND_TaxationStatusType taxationStatus) {
    }

    @Column(name="DevelopmentStatus", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_DevelopmentStatusType getDevelopmentStatus() {
        return developmentStatus;
    }
    public void setDevelopmentStatus(HND_DevelopmentStatusType developmentStatus) {
        this.developmentStatus = developmentStatus;
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
    @OneToMany(targetEntity=Easement.class, fetch=FetchType.LAZY)
    @JoinTable(name="Parcel__Easement", schema="ladmshadow")
    public List<Easement> getEasements() {
        return easements;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void setEasements(List<? extends IEasement> easements) {
        this.easements = (List<Easement>) easements;
    }

    @Override
    @SuppressWarnings("unchecked")
    @OneToMany(targetEntity=Improvement.class, fetch=FetchType.LAZY)
    @JoinTable(name="Parcel__Improvement", schema="ladmshadow")
    public List<Improvement> getImprovements() {
        return improvements;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void setImprovements(List<? extends IImprovement> improvements) {
        this.improvements = (List<Improvement>) improvements;
    }


    @Override
    public Parcel clone() {
        try {
            Parcel clonedParcel = (Parcel) super.clone();
            
            //this is in order to mark the object as unsaved
            clonedParcel.setSuID(null);
            clonedParcel.setOriginal(false);
            
            Set<BAUnit> baunits = new HashSet<BAUnit>(getBaunits());
            Set<SpatialUnit> element = new HashSet<SpatialUnit>(getElement());
            Set<SpatialUnitGroup> whole = new HashSet<SpatialUnitGroup>(getWhole());
            Set<SpatialSource> spatialSources = new HashSet<SpatialSource>(getSpatialSources());
            Set<RequiredRelationshipSpatialUnit> relSpatialUnits1requiredrelationshipspatialunits = new HashSet<RequiredRelationshipSpatialUnit>(getRelSpatialUnits1requiredrelationshipspatialunits());
            Set<RequiredRelationshipSpatialUnit> relSpatialUnits2requiredrelationshipspatialunits = new HashSet<RequiredRelationshipSpatialUnit>(getRelSpatialUnits2requiredrelationshipspatialunits());
            Set<BoundaryFaceString> bfsMinus = new HashSet<BoundaryFaceString>(getBfsMinus());
            Set<BoundaryFaceString> bfsPlus = new HashSet<BoundaryFaceString>(getBfsPlus());
            Set<BoundaryFace> bfMinus = new HashSet<BoundaryFace>(getBfMinus());
            Set<BoundaryFace> bfPlus = new HashSet<BoundaryFace>(getBfPlus());
            List<HND_LandUse> otherLandUses = new ArrayList<HND_LandUse>(getOtherLandUses());
            
            //Parcel attributes
            List<Easement> easements = new ArrayList<Easement>(getEasements());
            List<Improvement> improvements = new ArrayList<Improvement>(getImprovements());
            
            //special
            clonedParcel.setLevel(getLevel());

            clonedParcel.setBaunits(baunits);
            clonedParcel.setElement(element);
            clonedParcel.setWhole(whole);
            clonedParcel.setSpatialSources(spatialSources);
            clonedParcel.setRelSpatialUnits1requiredrelationshipspatialunits(relSpatialUnits1requiredrelationshipspatialunits);
            clonedParcel.setRelSpatialUnits2requiredrelationshipspatialunits(relSpatialUnits2requiredrelationshipspatialunits);
            clonedParcel.setBfsMinus(bfsMinus);
            clonedParcel.setBfsPlus(bfsPlus);
            clonedParcel.setBfMinus(bfMinus);
            clonedParcel.setBfPlus(bfPlus);
            clonedParcel.setLandUse(getLandUse());
            clonedParcel.setProposedLandUse(getProposedLandUse());
            clonedParcel.setOtherLandUses(otherLandUses);
            
            //Parcel attributes
            clonedParcel.setEasements(easements);
            clonedParcel.setImprovements(improvements);
            clonedParcel.setShape((Polygon) getShape().clone());

            return clonedParcel;
        }
        catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
        }
        return this;
    }
}
