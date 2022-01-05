package org.rodyce.foncier.datamodel.hnd.administrative;

import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.ladm.external.ExtParty;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_User", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_User implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String userName;
    private String password;
    private boolean active;
    
    private Boolean receptionist;
    private Boolean analyst;
    private Boolean editor;
    private Boolean manager;
    private Boolean approver;
    private Boolean surveyingTechnician;
    private Boolean externalQuerier;
    private Boolean internalQuerier;
    private Boolean systemAdministrator;
    
    private ExtParty party;
    
    
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
    
    
    @Column(name="UserName", nullable=false, unique=true)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String value) {
        this.userName = value;
    }
    

    
    @Column(name="Password", nullable=false, length=255)
    public String getPassword() {
        return password;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    
    @Column(name="Active", nullable=false)
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Column(name="Receptionist", nullable=true)
    public Boolean getReceptionist() {
        if (receptionist == null) return false;
        return receptionist;
    }
    public void setReceptionist(Boolean receptionist) {
        this.receptionist = receptionist;
    }

    @Column(name="Analyst", nullable=true)
    public Boolean getAnalyst() {
        if (analyst == null) return false;
        return analyst;
    }
    public void setAnalyst(Boolean analyst) {
        this.analyst = analyst;
    }

    @Column(name="Editor", nullable=true)
    public Boolean getEditor() {
        if (editor == null) return false;
        return editor;
    }
    public void setEditor(Boolean editor) {
        this.editor = editor;
    }

    @Column(name="Manager", nullable=true)
    public Boolean getManager() {
        if (manager == null) return false;
        return manager;
    }
    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    @Column(name="Approver", nullable=true)
    public Boolean getApprover() {
        if (approver == null) return false;
        return approver;
    }
    public void setApprover(Boolean approver) {
        this.approver = approver;
    }

    @Column(name="SurveyingTechnician", nullable=true)
    public Boolean getSurveyingTechnician() {
        if (surveyingTechnician == null) return false;
        return surveyingTechnician;
    }
    public void setSurveyingTechnician(Boolean surveyingTechnician) {
        this.surveyingTechnician = surveyingTechnician;
    }

    @Column(name="ExternalQuerier", nullable=true)
    public Boolean getExternalQuerier() {
        if (externalQuerier == null) return false;
        return externalQuerier;
    }
    public void setExternalQuerier(Boolean externalQuerier) {
        this.externalQuerier = externalQuerier;
    }

    @Column(name="InternalQuerier", nullable=true)
    public Boolean getInternalQuerier() {
        if (internalQuerier == null) return false;
        return internalQuerier;
    }
    public void setInternalQuerier(Boolean internalQuerier) {
        this.internalQuerier = internalQuerier;
    }

    @Column(name="SystemAdministrator", nullable=true)
    public Boolean getSystemAdministrator() {
        if (systemAdministrator == null) return false;
        return systemAdministrator;
    }
    public void setSystemAdministrator(Boolean systemAdministrator) {
        this.systemAdministrator = systemAdministrator;
    }
    
    
    @OneToOne(targetEntity=ExtParty.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="PartyID") })
    public ExtParty getParty() {
        return party;
    }
    public void setParty(ExtParty value) {
        this.party = value;
    }

    
    public String toString() {
        return String.valueOf(getUserName());
    }
    
    
    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof HND_User))
            return false;
        HND_User HND_User = (HND_User)aObj;
        if ((getUserName() != null && !getUserName().equals(HND_User.getUserName())) || (getUserName() == null && HND_User.getUserName() != null))
            return false;
        return true;
    }
    
    public int hashCode() {
        int hashcode = 0;
        hashcode = hashcode + (getUserName() == null ? 0 : getUserName().hashCode());
        return hashcode;
    }    
}
