package org.rodyce.foncier.datamodel.commons;

import java.util.Set;
import java.util.UUID;

public interface ISpatialUnit extends IVersionedObject {
    UUID getSuID();
    void setSuID(UUID value);
    
    ILevel getLevel();
    void setLevel(ILevel value);

    <BU extends IBAUnit> Set<BU> getBaunits();
}
