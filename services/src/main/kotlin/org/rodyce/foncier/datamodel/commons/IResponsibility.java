package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

import org.rodyce.foncier.datamodel.ladm.administrative.LA_ResponsibilityType;


public interface IResponsibility<P extends IParty, B extends IBAUnit> extends IRRR<P, B> {
    public LA_ResponsibilityType getType();
    public int responsibilitiesHash();
    public UUID getExtPID();
}
