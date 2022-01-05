package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_LayerAttribute", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_LayerAttribute implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String dbfFieldName;
    private HND_LayerAttributeType type;
    private Set<HND_SpatialZoneAttrValue> spatialZoneAttrValues;
    
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getId() {
        return id;
    }
    protected void setId(UUID id) {
        this.id = id;
    }
    @Transient
    public UUID getORMID() {
        return getId();
    }
    
    @Column(name="name", nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="dbfFieldName", nullable=false)
    public String getDbfFieldName() {
        return dbfFieldName;
    }
    public void setDbfFieldName(String dbfFieldName) {
        this.dbfFieldName = dbfFieldName;
    }
    
    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_LayerAttributeType getType() {
        return type;
    }
    public void setType(HND_LayerAttributeType type) {
        this.type = type;
    }

    @OneToMany(mappedBy="layerAttribute", targetEntity=HND_SpatialZoneAttrValue.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<HND_SpatialZoneAttrValue> getSpatialZoneAttrValues() {
        return spatialZoneAttrValues;
    }
    public void setSpatialZoneAttrValues(
            Set<HND_SpatialZoneAttrValue> spatialZoneAttrValues) {
        this.spatialZoneAttrValues = spatialZoneAttrValues;
    }
}
