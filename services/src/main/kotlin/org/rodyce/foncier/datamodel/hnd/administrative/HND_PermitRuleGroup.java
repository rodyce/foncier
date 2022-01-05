package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_PermitRuleGroup", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_PermitRuleGroup implements Serializable {
    private static final long serialVersionUID = 5778387687599958453L;

    private UUID id;
    private String name;
    private String description;
    private HND_PermitType permitType;
    
    private Set<HND_SpatialRule> spatialRules = new HashSet<HND_SpatialRule>();
    
    
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
    
    @Column(name="Name", nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="Description", nullable=true)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="PermitType", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_PermitType getPermitType() {
        return permitType;
    }
    public void setPermitType(HND_PermitType permitType) {
        this.permitType = permitType;
    }
    
    @ManyToMany(targetEntity=HND_SpatialRule.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="HND_PermitRuleGroup__HND_SpatialRule", schema="hnd_administrative", joinColumns={ @JoinColumn(name="HND_PermitRuleGroup__HND_SpatialRuleID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set<HND_SpatialRule> getSpatialRules() {
        return spatialRules;
    }
    public void setSpatialRules(Set<HND_SpatialRule> spatialRules) {
        this.spatialRules = spatialRules;
    }
}
