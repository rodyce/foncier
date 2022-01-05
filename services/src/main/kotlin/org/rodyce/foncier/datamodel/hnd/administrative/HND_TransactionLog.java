package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_TransactionLog", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_TransactionLog implements Serializable {
    private static final long serialVersionUID = 1648444850358012746L;
    
    private UUID id;
    private Date dateActivity;
    private Date dateClaimed;
    private Date dateFinished;
    private HND_ActivityType activity;
    private String transitionMessage;
    private HND_TransactionType transactionType;
    private HND_User claimingUser;
    private HND_Transaction transaction;
    
    
    
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
    
    @Column(name="DateActivity", nullable=false)
    public Date getDateActivity() {
        return dateActivity;
    }
    public void setDateActivity(Date dateActivity) {
        this.dateActivity = dateActivity;
    }
    
    @Column(name="DateClaimed", nullable=true)
    public Date getDateClaimed() {
        return dateClaimed;
    }
    public void setDateClaimed(Date dateClaimed) {
        this.dateClaimed = dateClaimed;
    }
    
    @Column(name="DateFinished", nullable=true)
    public Date getDateFinished() {
        return dateFinished;
    }
    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }
    
    @Column(name="Activity", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_ActivityType getActivity() {
        return activity;
    }
    public void setActivity(HND_ActivityType activity) {
        this.activity = activity;
    }
    
    @Column(name="TransitionMessage", nullable=true)
    public String getTransitionMessage() {
        return transitionMessage;
    }
    public void setTransitionMessage(String transitionMessage) {
        this.transitionMessage = transitionMessage;
    }
    
    @Column(name="TransactionType", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_TransactionType getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(HND_TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
    @ManyToOne(targetEntity=HND_User.class, fetch=FetchType.LAZY, optional=true)
    @JoinColumns({ @JoinColumn(name="HND_UserID", referencedColumnName="ID") })    
    public HND_User getClaimingUser() {
        return claimingUser;
    }
    public void setClaimingUser(HND_User claimingUser) {
        this.claimingUser = claimingUser;
    }
    
    @ManyToOne(targetEntity=HND_Transaction.class, fetch=FetchType.LAZY, optional=false)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({ @JoinColumn(name="HND_TransactionID", referencedColumnName="ID") })    
    @org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public HND_Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(HND_Transaction transaction) {
        this.transaction = transaction;
    }
}
