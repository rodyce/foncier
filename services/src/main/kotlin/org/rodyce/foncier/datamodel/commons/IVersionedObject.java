package org.rodyce.foncier.datamodel.commons;

import java.util.Date;
import java.util.UUID;

public interface IVersionedObject {

    Date getBeginLifespanVersion();

    void setBeginLifespanVersion(Date value);

    Date getEndLifespanVersion();

    void setEndLifespanVersion(Date value);

    boolean isAlive();

}
