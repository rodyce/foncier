package org.rodyce.foncier.datamodel.commons;

import java.util.Set;
import java.util.UUID;

public interface IBAUnit extends IVersionedObject {
    UUID getuID();
    
    Set<? extends IRRR<?,?>> getRrr();
    
    <SU extends ISpatialUnit> Set<SU> getSpatialUnits();
}
