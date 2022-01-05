package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

import org.rodyce.foncier.datamodel.ladm.administrative.LA_RestrictionType;


public interface IRestriction<P extends IParty, B extends IBAUnit> extends IRRR<P, B> {
    public LA_RestrictionType getType();
    public int restrictionsHash();
    public UUID getExtPID();
    
    public boolean getPartyRequired();
}
