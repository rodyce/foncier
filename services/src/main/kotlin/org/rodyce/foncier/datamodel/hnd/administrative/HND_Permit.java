package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.rodyce.foncier.datamodel.hnd.cadastre.HND_SpatialZone;
import org.rodyce.foncier.datamodel.ladm.external.ExtParty;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_Permit", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class HND_Permit extends HND_Transaction implements Serializable {
    private static final long serialVersionUID = -1746987211281763176L;
    
    private Long presentationNo;
    private Date validityFrom;
    private Date validityTo;
    private String ruleGroupName;
    private String cashiersCode;
    private BigDecimal payment;
    
    private String fieldVisitAssessment;
    private String environmentalAssessment;
    
    private Boolean approved;

    private String analystOpinion;
    private String approverOpinion;
    private String receptionistUserName;
    private String receptionistFullName;
    private String analystUserName;
    private String analystFullName;
    private String editorUserName;
    private String editorFullName;
    private String approverFullName;
    private String approverUserName;
    
    private ExtParty extParty;
    private HND_PermitRuleGroup ruleGroup;

    private HND_SpatialZone selectedZone;
    
    private Set<HND_PermitObservation> permitObservations = new HashSet<HND_PermitObservation>();

    
    @Transient
    public Date getRequestDate() {
        return super.getStartDate();
    }
    public void setRequestDate(Date requestDate) {
        super.setStartDate(requestDate);
    }
    
    @Transient
    public Date getIssueDate() {
        return super.getCompletionDate();
    }
    public void setIssueDate(Date issueDate) {
        super.setCompletionDate(issueDate);
    }
    
    @Column(name="PresentationNo", nullable=false, insertable=false, updatable=false, columnDefinition="serial")//warning: serial is Postgres specific
    public Long getPresentationNo() {
        return presentationNo;
    }
    protected void setPresentationNo(Long value) {
        this.presentationNo = value;
    }

    @Column(name="ValidityFrom", nullable=true)
    public Date getValidityFrom() {
        return validityFrom;
    }
    public void setValidityFrom(Date validityFrom) {
        this.validityFrom = validityFrom;
    }
    
    @Column(name="ValidityTo", nullable=true)
    public Date getValidityTo() {
        return validityTo;
    }
    public void setValidityTo(Date validityTo) {
        this.validityTo = validityTo;
    }

    @Column(name="Approved", nullable=true)
    public Boolean getApproved() {
        return approved;
    }
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    
    @Transient
    public String getRequestText() {
        return super.getDescription();
    }
    public void setRequestText(String requestText) {
        super.setDescription(requestText);
    }
    
    @Column(name="RuleGroupName", nullable=true)
    public String getRuleGroupName() {
        return ruleGroupName;
    }
    public void setRuleGroupName(String ruleGroupName) {
        this.ruleGroupName = ruleGroupName;
    }

    @Column(name="CashiersCode", nullable=true)
    public String getCashiersCode() {
        return cashiersCode;
    }
    public void setCashiersCode(String cashiersCode) {
        this.cashiersCode = cashiersCode;
    }
    
    @Column(name="Payment", nullable=true, precision=19, scale=4)
    public BigDecimal getPayment() {
        return payment;
    }
    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }
    
    @Column(name="FieldVisitAssessment", nullable=true)
    public String getFieldVisitAssessment() {
        return fieldVisitAssessment;
    }
    public void setFieldVisitAssessment(String fieldVisitAssessment) {
        this.fieldVisitAssessment = fieldVisitAssessment;
    }
    
    @Column(name="EnvironmentalAssessment", nullable=true)
    public String getEnvironmentalAssessment() {
        return environmentalAssessment;
    }
    public void setEnvironmentalAssessment(String environmentalAssessment) {
        this.environmentalAssessment = environmentalAssessment;
    }

    @Column(name="AnalystOpinion", nullable=true)
    public String getAnalystOpinion() {
        return analystOpinion;
    }
    public void setAnalystOpinion(String analystOpinion) {
        this.analystOpinion = analystOpinion;
    }
    
    @Column(name="ApproverOpinion", nullable=true)
    public String getApproverOpinion() {
        return approverOpinion;
    }
    public void setApproverOpinion(String approverOpinion) {
        this.approverOpinion = approverOpinion;
    }
    
    @Column(name="ReceptionistUserName", nullable=true)
    public String getReceptionistUserName() {
        return receptionistUserName;
    }
    public void setReceptionistUserName(String receptionistUserName) {
        this.receptionistUserName = receptionistUserName;
    }
    
    @Column(name="ReceptionistFullName", nullable=true)
    public String getReceptionistFullName() {
        return receptionistFullName;
    }
    public void setReceptionistFullName(String receptionistFullName) {
        this.receptionistFullName = receptionistFullName;
    }
    
    @Column(name="AnalystUserName", nullable=true)
    public String getAnalystUserName() {
        return analystUserName;
    }
    public void setAnalystUserName(String analystUserName) {
        this.analystUserName = analystUserName;
    }
    
    @Column(name="AnalystFullName", nullable=true)
    public String getAnalystFullName() {
        return analystFullName;
    }
    public void setAnalystFullName(String analystFullName) {
        this.analystFullName = analystFullName;
    }
    
    @Column(name="EditorUserName", nullable=true)
    public String getEditorUserName() {
        return editorUserName;
    }
    public void setEditorUserName(String editorUserName) {
        this.editorUserName = editorUserName;
    }
    
    @Column(name="EditorFullName", nullable=true)
    public String getEditorFullName() {
        return editorFullName;
    }
    public void setEditorFullName(String editorFullName) {
        this.editorFullName = editorFullName;
    }
    
    @Column(name="ApproverUserName", nullable=true)
    public String getApproverUserName() {
        return approverUserName;
    }
    public void setApproverUserName(String approverUserName) {
        this.approverUserName = approverUserName;
    }
    
    @Column(name="ApproverFullName", nullable=true)
    public String getApproverFullName() {
        return approverFullName;
    }
    public void setApproverFullName(String approverFullName) {
        this.approverFullName = approverFullName;
    }

    @ManyToOne(targetEntity=ExtParty.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})    
    @JoinColumns({ @JoinColumn(name="ExtPartyID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)    
    public ExtParty getExtParty() {
        return extParty;
    }
    public void setExtParty(ExtParty extParty) {
        this.extParty = extParty;
    }
    
    @ManyToOne(targetEntity=HND_SpatialZone.class, optional=false, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="SelectedZoneID", referencedColumnName="LA_SpatialUnitID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_SpatialZone getSelectedZone() {
        return selectedZone;
    }
    public void setSelectedZone(HND_SpatialZone selectedZone) {
        this.selectedZone = selectedZone;
    }
    
    @ManyToOne(targetEntity=HND_PermitRuleGroup.class, fetch=FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name="HND_PermitRuleGroupID", referencedColumnName="ID") })    
    public HND_PermitRuleGroup getRuleGroup() {
        return ruleGroup;
    }
    public void setRuleGroup(HND_PermitRuleGroup ruleGroup) {
        this.ruleGroup = ruleGroup;
    }


    @OneToMany(targetEntity=HND_PermitObservation.class, fetch=FetchType.LAZY)
    @JoinTable(name="HND_Permit__HND_PermitObservation", schema="hnd_administrative")
    public Set<HND_PermitObservation> getPermitObservations() {
        return permitObservations;
    }
    public void setPermitObservations(Set<HND_PermitObservation> permitObservations) {
        this.permitObservations = permitObservations;
    }
}
