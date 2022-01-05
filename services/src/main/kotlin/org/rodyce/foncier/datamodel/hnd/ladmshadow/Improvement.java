package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import org.rodyce.foncier.datamodel.commons.IImprovement;
import org.rodyce.foncier.datamodel.commons.IRegistration;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_Registration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Improvement", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
public class Improvement implements IImprovement, Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String use;
    private String easementClass;
    private Integer percentageGood;
    private Integer yearBuilt;
    private Byte numberOfFloors;
    private BigDecimal front;
    private BigDecimal depth;
    private BigDecimal area;
    private String observation;
    private HND_Registration registration = new HND_Registration();
    
    
    @Override
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getId() {
        return id;
    }
    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    @Column(name="Use", nullable=true)
    public String getUse() {
        return use;
    }
    @Override
    public void setUse(String use) {
        this.use = use;
    }

    @Override
    @Column(name="EasementClass", nullable=true)
    public String getEasementClass() {
        return easementClass;
    }
    @Override
    public void setEasementClass(String easementClass) {
        this.easementClass = easementClass;
    }

    @Override
    @Column(name="PercentageGood", nullable=true)
    public Integer getPercentageGood() {
        return percentageGood;
    }
    @Override
    public void setPercentageGood(Integer percentageGood) {
        this.percentageGood = percentageGood;
    }

    @Override
    @Column(name="YearBuilt", nullable=true)
    public Integer getYearBuilt() {
        return yearBuilt;
    }
    @Override
    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    @Override
    @Column(name="NumberOfFloors", nullable=true)
    public Byte getNumberOfFloors() {
        return numberOfFloors;
    }
    @Override
    public void setNumberOfFloors(Byte numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    @Column(name="Front", nullable=true, precision=24, scale=8)
    public BigDecimal getFront() {
        return front;
    }
    @Override
    public void setFront(BigDecimal front) {
        this.front = front;
    }

    @Override
    @Column(name="Depth", nullable=true, precision=24, scale=8)
    public BigDecimal getDepth() {
        return depth;
    }
    @Override
    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    @Override
    @Column(name="Area", nullable=true, precision=24, scale=8)
    public BigDecimal getArea() {
        return area;
    }
    @Override
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Override
    @Column(name="Observation", nullable=true)
    public String getObservation() {
        return observation;
    }
    @Override
    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    @Override
    @Embedded
    public HND_Registration getRegistration() {
        return registration;
    }
    @Override
    public void setRegistration(IRegistration registration) {
        this.registration = (HND_Registration) registration;
    }
}
