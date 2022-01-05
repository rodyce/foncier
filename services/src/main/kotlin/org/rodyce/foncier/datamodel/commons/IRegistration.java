package org.rodyce.foncier.datamodel.commons;


public interface IRegistration {
    String getCode();
    void setCode(String code);
    
    Integer getTome();
    void setTome(Integer tome);
    
    Integer getFolio();
    void setFolio(Integer folio);

    Integer getAnnotationNumber();
    void setAnnotationNumber(Integer annotationNumber);
}
