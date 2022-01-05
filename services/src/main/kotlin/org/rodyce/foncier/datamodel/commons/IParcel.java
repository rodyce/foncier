package org.rodyce.foncier.datamodel.commons;

import java.math.BigDecimal;
import java.util.List;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_AvailableServices;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_TaxationStatusType;

import com.vividsolutions.jts.geom.Polygon;


public interface IParcel extends ISpatialZone, Cloneable {
    Polygon getShape();
    
    String getFieldTab();
    void setFieldTab(String value);
    
    String getCadastralKey();
    void setCadastralKey(String value);
    
    String getMunicipalKey();
    void setMunicipalKey(String value);
    
    BigDecimal getDocumentedBuiltArea();
    void setDocumentedBuiltArea(BigDecimal value);
    
    BigDecimal getGroundBuiltArea();
    void setGroundBuiltArea(BigDecimal value);
    
    String getNeighborhood();
    void setNeighborhood(String value);
    
    String getAccessWay1();
    void setAccessWay1(String value);
    
    String getAccessWay2();
    void setAccessWay2(String value);
    
    String getHouseNumber();
    void setHouseNumber(String value);
    
    BigDecimal getCommercialAppraisal();
    void setCommercialAppraisal(BigDecimal value);
    
    BigDecimal getFiscalAppraisal();
    void setFiscalAppraisal(BigDecimal value);
    
    BigDecimal getTaxationBalanceDue();
    void setTaxationBalanceDue(BigDecimal value);
    
    HND_TaxationStatusType getTaxationStatus();
    void setTaxationStatus(HND_TaxationStatusType taxationStatus);
    
    boolean isAlive();

    HND_AvailableServices getAvailableServices();
    void setAvailableServices(HND_AvailableServices availableServices);

    <E extends IEasement> List<E> getEasements();
    void setEasements(List<? extends IEasement> easements);

    <I extends IImprovement> List<I> getImprovements();
    void setImprovements(List<? extends IImprovement> improvements);
    
    IParcel clone();
}
