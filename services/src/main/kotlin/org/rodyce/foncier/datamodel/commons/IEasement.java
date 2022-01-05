package org.rodyce.foncier.datamodel.commons;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_DocumentType;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_EasementType;

public interface IEasement {

    HND_EasementType getType();

    void setType(HND_EasementType type);

    HND_DocumentType getDocumentType();

    void setDocumentType(HND_DocumentType documentType);

    Integer getBeneficiaryNumber();

    void setBeneficiaryNumber(Integer beneficiaryNumber);

    IRegistration getRegistration();
    void setRegistration(IRegistration registration);
}
