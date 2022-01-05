package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.commons.ISpatialZone;
import org.rodyce.foncier.datamodel.commons.ITransaction;
import org.rodyce.foncier.datamodel.hnd.cadastre.HND_SpatialZone;
import org.rodyce.foncier.datamodel.ladm.administrative.LA_AdministrativeSource;

@Entity
@Table(name="HND_Transaction", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class HND_Transaction implements Serializable, ITransaction {
    private static final long serialVersionUID = 1L;
    
    private UUID id;
    private Date startDate;
    private Date completionDate;
    private String description;
    private String editorUserName;
    private String editorFullName;

    private Set<LA_AdministrativeSource> sources = new HashSet<LA_AdministrativeSource>();
    private Set<HND_SpatialZone> originatedSpatialZones = new HashSet<HND_SpatialZone>();
    private Set<HND_SpatialZoneInTransaction> spatialZoneInTransaction = new HashSet<HND_SpatialZoneInTransaction>();
    
    
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
    @Transient
    public UUID getORMID() {
        return getId();
    }
    

    @Column(name="StartDate", nullable=false)
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    
    
    @Column(name="CompletionDate", nullable=true)
    public Date getCompletionDate() {
        return completionDate;
    }
    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    @Column(name="Description", nullable=true, length=255)
    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }
    
    
    @Column(name="EditorUserName", nullable=true, length=255)
    public String getEditorUserName() {
        return editorUserName;
    }
    public void setEditorUserName(String editorUserName) {
        this.editorUserName = editorUserName;
    }
    
    @Column(name="EditorFullName", nullable=true, length=255)
    public String getEditorFullName() {
        return editorFullName;
    }
    public void setEditorFullName(String editorFullName) {
        this.editorFullName = editorFullName;
    }
    
    @OneToMany(targetEntity=LA_AdministrativeSource.class, fetch=FetchType.LAZY)
    @JoinTable(name="HND_Transaction__LA_AdministrativeSource", schema="hnd_administrative")
    public Set<LA_AdministrativeSource> getSources() {
        return sources;
    }
    public void setSources(java.util.Set<LA_AdministrativeSource> sources) {
        this.sources = sources;
    }
    
    @OneToMany(mappedBy="originatingTransaction", targetEntity=HND_SpatialZone.class, fetch=FetchType.LAZY)
    public Set<HND_SpatialZone> getOriginatedSpatialZones() {
        return originatedSpatialZones;
    }
    @SuppressWarnings("unchecked")
    public void setOriginatedSpatialZones(Set<? extends ISpatialZone> originatedSpatialZones) {
        this.originatedSpatialZones = (Set<HND_SpatialZone>) originatedSpatialZones;
    }

    @Override
    @OneToMany(mappedBy="transaction", targetEntity=HND_SpatialZoneInTransaction.class, fetch=FetchType.LAZY)
    public Set<HND_SpatialZoneInTransaction> getSpatialZoneInTransactions() {
        return spatialZoneInTransaction;
    }
    public void setSpatialZoneInTransactions(
            java.util.Set<HND_SpatialZoneInTransaction> spatialZoneInTransaction) {
        this.spatialZoneInTransaction = spatialZoneInTransaction;
    }
    
    @Override
    @Transient
    public boolean isCompleted() {
        return getCompletionDate() != null;
    }


    public String toString() {
        return String.valueOf(getId());
    }
}
