package org.rodyce.foncier.datamodel.hnd.administrative;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_Layer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name="HND_TopographicTransaction", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("HND_TopographicTransaction")
@PrimaryKeyJoinColumn(name="TransactionID", referencedColumnName="ID")
public class HND_TopographicTransaction extends HND_Transaction {
    private static final long serialVersionUID = 1L;

    private Long presentationNo;
    private HND_TopographicTransactionStateType state;
    private Geometry extents;
    private HND_Layer workingLayer;
    
    
    @Column(name="PresentationNo", nullable=false, insertable=false, updatable=false, columnDefinition="serial")//warning: serial is Postgres specific
    public Long getPresentationNo() {
        return presentationNo;
    }
    protected void setPresentationNo(Long value) {
        this.presentationNo = value;
    }

    @Column(name="State", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_TopographicTransactionStateType getState() {
        return state;
    }
    public void setState(HND_TopographicTransactionStateType state) {
        this.state = state;
    }
    
    @Column(name="Extents", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Geometry getExtents() {
        return extents;
    }
    public void setExtents(Geometry extents) {
        this.extents = extents;
    }
    
    
    @ManyToOne(targetEntity=HND_Layer.class, optional=false, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="WorkingLayerID", referencedColumnName="LA_LevelID") })
    public HND_Layer getWorkingLayer() {
        return workingLayer;
    }
    public void setWorkingLayer(HND_Layer workingLayer) {
        this.workingLayer = workingLayer;
    }
}
