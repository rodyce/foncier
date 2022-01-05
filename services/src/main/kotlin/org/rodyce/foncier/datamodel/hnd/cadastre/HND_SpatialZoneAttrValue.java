package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_SpatialZoneAttrValue", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(HND_SpatialZoneAttrValuePK.class)
public class HND_SpatialZoneAttrValue implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID layerAttributeId;
    private UUID spatialZoneId;
    private HND_LayerAttribute layerAttribute;
    private HND_SpatialZone spatialZone;
    
    private Integer intValue;
    private Double decimalValue;
    private String stringValue;
    private Date dateValue;

    @Id
    @Column(name="LayerAttributeId", nullable=false, insertable=false, updatable=false)    
    public UUID getLayerAttributeId() {
        return layerAttributeId;
    }
    public void setLayerAttributeId(UUID layerAttributeId) {
        this.layerAttributeId = layerAttributeId;
    }
    
    @Id
    @Column(name="SpatialZoneId", nullable=false, insertable=false, updatable=false)    
    public UUID getSpatialZoneId() {
        return spatialZoneId;
    }
    public void setSpatialZoneId(UUID spatialZoneId) {
        this.spatialZoneId = spatialZoneId;
    }

    
    @PrimaryKeyJoinColumn
    public HND_LayerAttribute getLayerAttribute() {
        return layerAttribute;
    }
    public void setLayerAttribute(HND_LayerAttribute layerAttribute) {
        this.layerAttribute = layerAttribute;
    }
    
    @PrimaryKeyJoinColumn
    public HND_SpatialZone getSpatialZone() {
        return spatialZone;
    }
    public void setSpatialZone(HND_SpatialZone spatialZone) {
        this.spatialZone = spatialZone;
    }
    
    
    @Column(name="IntValue", nullable=true)
    public Integer getIntValue() {
        return intValue;
    }
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
    
    @Column(name="DecimalValue", nullable=true)
    public Double getDecimalValue() {
        return decimalValue;
    }
    public void setDecimalValue(Double decimalValue) {
        this.decimalValue = decimalValue;
    }
    
    @Column(name="StringValue", nullable=true)
    public String getStringValue() {
        return stringValue;
    }
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    
    @Column(name="DateValue", nullable=true)
    public Date getDateValue() {
        return dateValue;
    }
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
}
