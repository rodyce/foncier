package org.rodyce.foncier.datamodel.commons;

import java.util.List;
import java.util.Set;

public interface IProperty extends IBAUnit, Cloneable {
    public int rightsHash();
    public List<IRight<?,?>> getRights();

    public int restrictionsHash();
    public List<IRestriction<?,?>> getRestrictions();
    
    public int responsibilitiesHash();
    public List<IResponsibility<?,?>> getResponsibilities();
    
    public Set<IParcel> getParcels();
    
    public IRegistration getRegistration();
    public void setRegistration(IRegistration registration);
    
    IProperty clone();
}
