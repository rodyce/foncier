package org.rodyce.foncier.datamodel.commons;

import java.util.Set;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_ActivityType;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_MunicipalTransactionType;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_TransactionSubType;
import org.rodyce.foncier.datamodel.ladm.external.ExtParty;


public interface IMunicipalTransaction extends ITransaction {
    public Long getPresentationNo();
    
    public HND_MunicipalTransactionType getRequestType();
    public void setRequestType(HND_MunicipalTransactionType requestType);
    
    public HND_TransactionSubType getRequestSubType();
    public void setRequestSubType(HND_TransactionSubType requestSubType);

    public HND_ActivityType getCurrentActivity();
    public void setCurrentActivity(HND_ActivityType currentActivity);

    public String getCurrentActorUserName();
    public void setCurrentActorUserName(String currentActorUserName);

    public String getCurrentActorFullName();
    public void setCurrentActorFullName(String currentActorFullName);
    
    public String getCashiersCode();
    public void setCashiersCode(String value);

    public java.math.BigDecimal getPayment();
    public void setPayment(java.math.BigDecimal value);

    public String getAnalysisDictum();
    public void setAnalysisDictum(String analysisDictum);
    
    public String getAdditionalObservations();
    public void setAdditionalObservations(String additionalObservations);

    public String getReceptionistUserName();
    public void setReceptionistUserName(String value);

    public String getReceptionistFullName();
    public void setReceptionistFullName(String value);

    public String getApproverFullName();
    public void setApproverFullName(String approverFullName);

    public String getApproverUserName();
    public void setApproverUserName(String approverUserName);
    
    public ExtParty getExtParty();
    public void setExtParty(ExtParty extParty);
    
    public Set<? extends ISpatialZone> getOriginatedSpatialZones();
    public void setOriginatedSpatialZones(Set<? extends ISpatialZone> originatedSpatialZones);

}
