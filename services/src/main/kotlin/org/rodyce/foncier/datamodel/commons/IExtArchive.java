package org.rodyce.foncier.datamodel.commons;

import java.util.UUID;

public interface IExtArchive {
    public UUID getsID();
    
    public String getName();
    public void setName(String name);

    public String getDescription();
    public void setDescription(String description);

    public java.util.Date getAcceptance();
    public void setAcceptance(java.util.Date value);
    
    public byte[] getData();
    public void setData(byte[] value);

    public java.util.Date getRecordation();
    public void setRecordation(java.util.Date value);

    public java.util.Date getSubmission();
    public void setSubmission(java.util.Date value);

    public Boolean isExternal();
    public void setExternal(Boolean external);
}
