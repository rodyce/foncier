package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

import org.rodyce.foncier.datamodel.ladm.administrative.LA_RightType;


public interface IRight<P extends IParty, B extends IBAUnit> extends IRRR<P, B> {
    public LA_RightType getType();
    public int rightHash();
    public UUID getExtPID();
}
