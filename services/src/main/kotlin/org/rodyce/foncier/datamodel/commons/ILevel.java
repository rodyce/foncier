package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_LevelContentType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_RegisterType;
import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_StructureType;


public interface ILevel {
    UUID getIID();
    
    String getName();
    void setName(String value);
    
    LA_RegisterType getRegisterType();
    void setRegisterType(LA_RegisterType value);
    
    LA_StructureType getStructure();
    void setStructure(LA_StructureType value);
    
    LA_LevelContentType getType();
    void setType(LA_LevelContentType value);

}
