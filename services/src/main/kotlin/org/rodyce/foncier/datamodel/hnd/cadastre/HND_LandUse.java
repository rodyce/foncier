package org.rodyce.foncier.datamodel.hnd.cadastre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.hnd.special.HND_StyleInfo;

@Entity
@Table(name="HND_LandUse", schema="hnd_cadastre")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_LandUse implements Serializable {
    private static final long serialVersionUID = -25359761903060860L;

    private UUID id;
    private String code;
    private String subCode;
    private String completeCode;
    private String name;
    private int level;
    private boolean leaf;
    private HND_StyleInfo styleInfo = new HND_StyleInfo();
    
    private HND_LandUse parent;
    private Set<HND_LandUse> childs = new HashSet<HND_LandUse>();
    private List<HND_LandUse> compatibleLandUses = new ArrayList<HND_LandUse>();
    private HND_LandUseDomain domain;


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
    
    
    @Column(name="code", nullable=false)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name="subCode", nullable=true)
    public String getSubCode() {
        return subCode;
    }
    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }
    
    
    @Column(name="completeCode", nullable=false)
    public String getCompleteCode() {
        return completeCode;
    }
    public void setCompleteCode(String completeCode) {
        this.completeCode = completeCode;
    }
    
    
    @Column(name="name", nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    @Column(name="level", nullable=false)
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    
    
    @Column(name="leaf", nullable=false)
    public boolean isLeaf() {
        return leaf;
    }
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
    
    @Embedded
    public HND_StyleInfo getStyleInfo() {
        return styleInfo;
    }
    public void setStyleInfo(HND_StyleInfo styleInfo) {
        this.styleInfo = styleInfo;
    }
    
    @ManyToOne(targetEntity=HND_LandUse.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="ParentLandUseID", referencedColumnName="ID") })    
    public HND_LandUse getParent() {
        return parent;
    }
    public void setParent(HND_LandUse parent) {
        this.parent = parent;
    }
    
    @OneToMany(mappedBy="parent", targetEntity=HND_LandUse.class)
    public java.util.Set<HND_LandUse> getChilds() {
        return childs;
    }
    public void setChilds(java.util.Set<HND_LandUse> childs) {
        this.childs = childs;
    }
    
    @ManyToMany(targetEntity=HND_LandUse.class)
    @JoinTable(name="HND_LandUseCompatibility", schema="hnd_cadastre", joinColumns={ @JoinColumn(name="HND_LandUse1") }, inverseJoinColumns={ @JoinColumn(name="HND_LandUse2") })    
    public List<HND_LandUse> getCompatibleLandUses() {
        return compatibleLandUses;
    }
    public void setCompatibleLandUses(List<HND_LandUse> compatibleLandUses) {
        this.compatibleLandUses = compatibleLandUses;
    }
    
    @ManyToOne(targetEntity=HND_LandUseDomain.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="LandUseDomainID", referencedColumnName="ID") })
    public HND_LandUseDomain getDomain() {
        return domain;
    }
    public void setDomain(HND_LandUseDomain domain) {
        this.domain = domain;
    }
    
    
    @Transient
    public String getFullName() {
        return String.format("%s - %s", getCompleteCode(), getName());
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HND_LandUse other = (HND_LandUse) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
