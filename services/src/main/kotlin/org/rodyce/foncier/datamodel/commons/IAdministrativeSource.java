package org.rodyce.foncier.datamodel.commons;

import org.rodyce.foncier.datamodel.ladm.administrative.LA_AdministrativeSourceType;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_AvailabilityStatusType;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_BAUnit;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_RRR;
import org.rodyce.foncier.datamodel.ladm.party.LA_Party;


public interface IAdministrativeSource extends ISource {
    public LA_AvailabilityStatusType getAvailabilityStatus();
    public void setAvailabilityStatus(LA_AvailabilityStatusType value);
    
    public String getText();
    public void setText(String value);

    public LA_AdministrativeSourceType getType();
    public void setType(LA_AdministrativeSourceType value);

    public java.util.Set<LA_BAUnit> getUnits();
    public void setUnits(java.util.Set<LA_BAUnit> value);

    public java.util.Set<LA_RRR> getRrr();
    public void setRrr(java.util.Set<LA_RRR> value);

    public java.util.Set<LA_Party> getConveyor();
    public void setConveyor(java.util.Set<LA_Party> value);
}
