package org.rodyce.foncier.datamodel.commons;

import java.math.BigDecimal;
import java.util.UUID;

public interface IImprovement {
    UUID getId();
    void setId(UUID id);

    String getUse();
    void setUse(String use);

    String getEasementClass();

    void setEasementClass(String easementClass);

    Integer getPercentageGood();
    void setPercentageGood(Integer percentageGood);

    Integer getYearBuilt();
    void setYearBuilt(Integer yearBuilt);

    Byte getNumberOfFloors();
    void setNumberOfFloors(Byte numberOfFloors);

    BigDecimal getFront();
    void setFront(BigDecimal front);

    BigDecimal getDepth();
    void setDepth(BigDecimal depth);

    BigDecimal getArea();
    void setArea(BigDecimal area);

    String getObservation();
    void setObservation(String observation);

    IRegistration getRegistration();
    void setRegistration(IRegistration registration);
}
