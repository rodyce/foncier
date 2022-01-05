package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

import org.rodyce.foncier.datamodel.ladm.special.Rational;


public interface IRRR<P extends IParty, B extends IBAUnit> extends IVersionedObject {
    UUID getRID();
    
    P getParty();
    void setParty(IParty party);
    
    B getBaunit();
    void setBaunit(IBAUnit baUnit);
    
    String getDescription();
    void setDescription(String description);
    
    Enum<?> getType();
    void setType(Enum<?> type);
    
    Rational getShare();
    void setShare(Rational rational);

}
