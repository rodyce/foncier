package org.rodyce.foncier.datamodel.commons;

import java.util.Date;
import java.util.Set;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_SpatialZoneInTransaction;

public interface ITransaction {
    public Long getPresentationNo();

    public Date getStartDate();
    public void setStartDate(Date startDate);

    public Date getCompletionDate();
    public void setCompletionDate(Date completionDate);

    public String getDescription();
    public void setDescription(String value);
    
    public String getEditorUserName();
    public void setEditorUserName(String editorUserName);

    public String getEditorFullName();
    public void setEditorFullName(String editorFullName);

    public Set<HND_SpatialZoneInTransaction> getSpatialZoneInTransactions();

    public boolean isCompleted();
}
