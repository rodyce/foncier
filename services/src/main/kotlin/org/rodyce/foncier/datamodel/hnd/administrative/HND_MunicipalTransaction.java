package org.rodyce.foncier.datamodel.hnd.administrative;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.rodyce.foncier.datamodel.commons.IMunicipalTransaction;
import org.rodyce.foncier.datamodel.ladm.external.ExtParty;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_MunicipalTransaction", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("HND_MunicipalTransaction")
@PrimaryKeyJoinColumn(name="TransactionID", referencedColumnName="ID")
public class HND_MunicipalTransaction extends HND_Transaction implements IMunicipalTransaction {
    private static final long serialVersionUID = 1L;
    
    private Long presentationNo;
    private HND_MunicipalTransactionType requestType;
    private HND_TransactionSubType requestSubType;
    private HND_TransactionDocumentType recordedDocumentType;
    private Date protocolDate;
    private Integer protocolNumber;
    private String cashiersCode;
    private BigDecimal payment;
    private String analysisDictum;
    private String additionalObservations;
    private String receptionistUserName;
    private String receptionistFullName;
    private String analystUserName;
    private String analystFullName;
    private String approverUserName;
    private String approverFullName;
    private HND_ActivityType currentActivity;
    private String currentActorUserName;
    private String currentActorFullName;
    private String responseData;
    private Boolean approved;
    private ExtParty extParty;
    private ExtParty favoredParty;
    

    @Column(name="PresentationNo", nullable=false, insertable=false, updatable=false, columnDefinition="serial")//warning: serial is Postgres specific
    public Long getPresentationNo() {
        return presentationNo;
    }
    protected void setPresentationNo(Long value) {
        this.presentationNo = value;
    }

    @Column(name="RequestType", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_MunicipalTransactionType getRequestType() {
        return requestType;
    }
    public void setRequestType(HND_MunicipalTransactionType requestType) {
        this.requestType = requestType;
    }
    
    @Column(name="RequestSubType", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_TransactionSubType getRequestSubType() {
        return requestSubType;
    }
    public void setRequestSubType(HND_TransactionSubType requestSubType) {
        this.requestSubType = requestSubType;
    }
    
    @Column(name="RecordedDocumentType", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_TransactionDocumentType getRecordedDocumentType() {
        return recordedDocumentType;
    }
    public void setRecordedDocumentType(
            HND_TransactionDocumentType recordedDocumentType) {
        this.recordedDocumentType = recordedDocumentType;
    }
    
    @Column(name="ProtocolDate", nullable=true)
    public Date getProtocolDate() {
        return protocolDate;
    }
    public void setProtocolDate(Date protocolDate) {
        this.protocolDate = protocolDate;
    }
    
    @Column(name="ProtocolNumber", nullable=true)
    public Integer getProtocolNumber() {
        return protocolNumber;
    }
    public void setProtocolNumber(Integer protocolNumber) {
        this.protocolNumber = protocolNumber;
    }
    
    @Column(name="CurrentActivity", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_ActivityType getCurrentActivity() {
        return currentActivity;
    }
    public void setCurrentActivity(HND_ActivityType currentActivity) {
        this.currentActivity = currentActivity;
    }
    
    @Column(name="CurrentActorUserName", nullable=true)
    public String getCurrentActorUserName() {
        return currentActorUserName;
    }
    public void setCurrentActorUserName(String currentActorUserName) {
        this.currentActorUserName = currentActorUserName;
    }
    
    @Column(name="CurrentActorFullName", nullable=true)
    public String getCurrentActorFullName() {
        return currentActorFullName;
    }
    public void setCurrentActorFullName(String currentActorFullName) {
        this.currentActorFullName = currentActorFullName;
    }
    
    @Column(name="CashiersCode", nullable=true, length=255)
    public String getCashiersCode() {
        return cashiersCode;
    }
    public void setCashiersCode(String value) {
        this.cashiersCode = value;
    }
    
    @Column(name="Payment", nullable=true, precision=14, scale=2)
    public java.math.BigDecimal getPayment() {
        return payment;
    }
    public void setPayment(java.math.BigDecimal value) {
        this.payment = value;
    }

    @Column(name="AnalysisDictum", nullable=true, length=255)
    public String getAnalysisDictum() {
        return analysisDictum;
    }
    public void setAnalysisDictum(String analysisDictum) {
        this.analysisDictum = analysisDictum;
    }
    
    @Column(name="AdditionalObservations", nullable=true, length=255)
    public String getAdditionalObservations() {
        return additionalObservations;
    }
    public void setAdditionalObservations(String additionalObservations) {
        this.additionalObservations = additionalObservations;
    }

    @Column(name="ReceptionistUserName", nullable=true, length=255)
    public String getReceptionistUserName() {
        return receptionistUserName;
    }
    public void setReceptionistUserName(String value) {
        this.receptionistUserName = value;
    }
    
    @Column(name="ReceptionistFullName", nullable=true, length=255)
    public String getReceptionistFullName() {
        return receptionistFullName;
    }
    public void setReceptionistFullName(String value) {
        this.receptionistFullName = value;
    }
    
    @Column(name="AnalystUserName", nullable=true, length=255)
    public String getAnalystUserName() {
        return analystUserName;
    }
    public void setAnalystUserName(String analystUserName) {
        this.analystUserName = analystUserName;
    }
    
    @Column(name="AnalystFullName", nullable=true, length=255)
    public String getAnalystFullName() {
        return analystFullName;
    }
    public void setAnalystFullName(String analystFullName) {
        this.analystFullName = analystFullName;
    }
    
    @Column(name="ApproverFullName", nullable=true, length=255)
    public String getApproverFullName() {
        return approverFullName;
    }
    public void setApproverFullName(String approverFullName) {
        this.approverFullName = approverFullName;
    }

    @Column(name="ApproverUserName", nullable=true, length=255)
    public String getApproverUserName() {
        return approverUserName;
    }
    public void setApproverUserName(String approverUserName) {
        this.approverUserName = approverUserName;
    }
    
    @Lob @Basic(fetch=FetchType.LAZY)
    @Column(name="ResponseData", nullable=true)
    public String getResponseData() {
        return responseData;
    }
    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    @Column(name="Approved", nullable=true)
    public Boolean getApproved() {
        return approved;
    }
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    
    
    @ManyToOne(targetEntity=ExtParty.class, optional=false, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="ExtPartyID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public ExtParty getExtParty() {
        return extParty;
    }
    public void setExtParty(ExtParty extParty) {
        this.extParty = extParty;
    }

    
    @ManyToOne(targetEntity=ExtParty.class, optional=true, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="FavoredPartyID", referencedColumnName="ID") })
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public ExtParty getFavoredParty() {
        return favoredParty;
    }
    public void setFavoredParty(ExtParty favoredParty) {
        this.favoredParty = favoredParty;
    }

    
    @Transient
    public boolean isCompleted() {
        return currentActivity == HND_ActivityType.END;
    }
    
    @Transient
    public Date getPresentationDate() {
        return getStartDate();
    }
    public void setPresentationDate(Date startDate) {
        setStartDate(startDate);
    }
}
