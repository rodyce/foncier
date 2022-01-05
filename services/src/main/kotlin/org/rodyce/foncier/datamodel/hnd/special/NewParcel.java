package org.rodyce.foncier.datamodel.hnd.special;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Polygon;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="NewParcel", schema="hnd_special")
@Inheritance(strategy=InheritanceType.JOINED)
public class NewParcel {
    private UUID id;
    private String fieldTab;
    private String name;
    private Polygon shape;
    private boolean submitted;
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    
    @Column(name="FieldTab", nullable=true)
    public String getFieldTab() {
        return fieldTab;
    }
    public void setFieldTab(String fieldTab) {
        this.fieldTab = fieldTab;
    }
    
    @Column(name="Name", nullable=true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="Shape", nullable=false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Polygon getShape() {
        return shape;
    }
    public void setShape(Polygon shape) {
        this.shape = shape;
    }
    
    @Column(name="submitted", nullable=false)
    public boolean isSubmitted() {
        return submitted;
    }
    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
