package org.rodyce.foncier.datamodel.hnd.special;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HND_StyleInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String fillColor;
    private Float fillOpacity;
    private String strokeColor;
    private Float strokeWidth;
    
    @Column(name="FillColor", nullable=true)
    public String getFillColor() {
        return fillColor;
    }
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
    
    @Column(name="FillOpacity", nullable=false)
    public Float getFillOpacity() {
        return fillOpacity;
    }
    public void setFillOpacity(Float fillOpacity) {
        this.fillOpacity = fillOpacity;
    }
    
    
    @Column(name="StrokeColor", nullable=true)
    public String getStrokeColor() {
        return strokeColor;
    }
    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }
    
    @Column(name="StrokeWidth", nullable=false)
    public Float getStrokeWidth() {
        return strokeWidth;
    }
    public void setStrokeWidth(Float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
