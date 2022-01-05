package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class HND_SpatialZoneAttrValuePK implements Serializable {
    private static final long serialVersionUID = 1799032670854769448L;

    private HND_LayerAttribute layerAttribute;
    private HND_SpatialZone spatialZone;
    
    
    @ManyToOne(targetEntity=HND_LayerAttribute.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="LayerAttributeId", referencedColumnName="ID") })    
    public HND_LayerAttribute getLayerAttribute() {
        return layerAttribute;
    }
    public void setLayerAttribute(HND_LayerAttribute layerAttribute) {
        this.layerAttribute = layerAttribute;
    }
    
    @ManyToOne(targetEntity=HND_SpatialZone.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="SpatialZoneId", referencedColumnName="LA_SpatialUnitID") })
    public HND_SpatialZone getSpatialZone() {
        return spatialZone;
    }
    public void setSpatialZone(HND_SpatialZone spatialZone) {
        this.spatialZone = spatialZone;
    }
    

    @Override
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof HND_SpatialZoneAttrValuePK))
            return false;
        HND_SpatialZoneAttrValuePK hnd_spatialzoneattrvaluepk = (HND_SpatialZoneAttrValuePK)aObj;
        if (getLayerAttribute() == null) {
            if (hnd_spatialzoneattrvaluepk.getLayerAttribute() != null)
                return false;
        }
        else if (!getLayerAttribute().equals(hnd_spatialzoneattrvaluepk.getLayerAttribute()))
            return false;
        if (getSpatialZone() == null) {
            if (hnd_spatialzoneattrvaluepk.getSpatialZone() != null)
                return false;
        }
        else if (!getSpatialZone().equals(hnd_spatialzoneattrvaluepk.getSpatialZone()))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashcode = 0;
        if (getLayerAttribute() != null) {
            hashcode = (int) (hashcode + getLayerAttribute().getORMID().hashCode());
        }
        if (getSpatialZone() != null) {
            hashcode = hashcode + (int) getSpatialZone().getORMID().hashCode();
        }
        return hashcode;
    }
}
