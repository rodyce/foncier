package org.rodyce.foncier.datamodel.ladm.spatialunit;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.ILevel;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Level", schema="ladm_spatialunit")
@Inheritance(strategy=InheritanceType.JOINED)
public class LA_Level extends org.rodyce.foncier.datamodel.ladm.special.VersionedObject implements ILevel, Serializable {
    private static final long serialVersionUID = 1L;
    
    private UUID IID;
    private String name;
    private LA_RegisterType registerType;
    private LA_StructureType structure;
    private LA_LevelContentType type;
    private java.util.Set<LA_SpatialUnit> su = new java.util.HashSet<LA_SpatialUnit>();
    
    public LA_Level() {
    }
    
    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getIID() {
        return IID;
    }
    protected void setIID(UUID value) {
        this.IID = value;
    }
    @Transient
    public UUID getORMID() {
        return getIID();
    }
    
    @Column(name="Name", nullable=true, length=255)    
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    
    @Column(name="RegisterType", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_RegisterType getRegisterType() {
        return registerType;
    }
    public void setRegisterType(LA_RegisterType value) {
        this.registerType = value;
    }
    
    @Column(name="Structure", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_StructureType getStructure() {
        return structure;
    }
    public void setStructure(LA_StructureType value) {
        this.structure = value;
    }
    
    @Column(name="Type", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_LevelContentType getType() {
        return type;
    }
    public void setType(LA_LevelContentType value) {
        this.type = value;
    }
    
    @OneToMany(mappedBy="level", targetEntity=LA_SpatialUnit.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_SpatialUnit> getSu() {
        return su;
    }
    public void setSu(java.util.Set<LA_SpatialUnit> value) {
        this.su = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
