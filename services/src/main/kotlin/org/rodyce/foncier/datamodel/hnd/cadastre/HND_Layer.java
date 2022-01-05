package org.rodyce.foncier.datamodel.hnd.cadastre;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.rodyce.foncier.datamodel.ladm.spatialunit.LA_Level;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_Layer", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("HND_Layer")
@PrimaryKeyJoinColumn(name="LA_LevelID", referencedColumnName="ID")
public class HND_Layer extends LA_Level {
    private static final long serialVersionUID = 6962237615594594501L;

    private String wmsNamespace;
    private String wmsLayerName;
    private boolean overlapsAllowed;
    private boolean transactionRequired;
    private boolean historyControl;
    private HND_GeometryType geometryType;
    private HND_LayerType layerType;
    
    
    @Column(name="WmsNamespace", nullable=false, length=255)
    public String getWmsNamespace() {
        return wmsNamespace;
    }
    public void setWmsNamespace(String wmsNamespace) {
        this.wmsNamespace = wmsNamespace;
    }
    
    @Column(name="WmsLayerName", nullable=false, length=255)
    public String getWmsLayerName() {
        return wmsLayerName;
    }
    public void setWmsLayerName(String wmsLayerName) {
        this.wmsLayerName = wmsLayerName;
    }
    
    @Column(name="OverlapsAllowed", nullable=false)
    public boolean isOverlapsAllowed() {
        return overlapsAllowed;
    }
    public void setOverlapsAllowed(boolean overlapsAllowed) {
        this.overlapsAllowed = overlapsAllowed;
    }
    
    @Column(name="TransactionRequired", nullable=false)
    public boolean isTransactionRequired() {
        return transactionRequired;
    }
    public void setTransactionRequired(boolean transactionRequired) {
        this.transactionRequired = transactionRequired;
    }
    
    @Column(name="HistoryControl", nullable=false)
    public boolean isHistoryControl() {
        return historyControl;
    }
    public void setHistoryControl(boolean historyControl) {
        this.historyControl = historyControl;
    }
    
    @Column(name="GeometryType", nullable=false)
    @Enumerated(value=EnumType.STRING)
    public HND_GeometryType getGeometryType() {
        return geometryType;
    }
    public void setGeometryType(HND_GeometryType geometryType) {
        this.geometryType = geometryType;
    }
    
    @Column(name="LayerType", nullable=false)
    @Enumerated(value=EnumType.STRING)
    public HND_LayerType getLayerType() {
        return layerType;
    }
    public void setLayerType(HND_LayerType layerType) {
        this.layerType = layerType;
    }
}
