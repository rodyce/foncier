package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

public interface ISource {
    public UUID getsID();
    
    public java.util.Date getAcceptance();
    public void setAcceptance(java.util.Date value);

    public IExtArchive getArchive();
    public void setArchive(IExtArchive value);

    public java.util.Date getLifeSpanStamp();
    public void setLifeSpanStamp(java.util.Date value);
    
    public java.util.Date getRecordation();
    public void setRecordation(java.util.Date value);

    public java.util.Date getSubmission();
    public void setSubmission(java.util.Date value);
}
