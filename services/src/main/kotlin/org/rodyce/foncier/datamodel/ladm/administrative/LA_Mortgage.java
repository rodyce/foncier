package org.rodyce.foncier.datamodel.ladm.administrative;

import java.io.Serializable;
import javax.persistence.*;

import org.rodyce.foncier.datamodel.ladm.party.LA_Party;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="LA_Mortgage", schema="ladm_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("LA_Mortgage")
public class LA_Mortgage extends LA_Restriction implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private java.math.BigDecimal amount;
    private float interestRate;
    private int ranking;
    private LA_MortgageType mortgageType;
    private java.util.Set<LA_Right> rights = new java.util.HashSet<LA_Right>();
    private java.util.Set<LA_Party> moneyProvider = new java.util.HashSet<LA_Party>();

    
    public LA_Mortgage() {
    }
    
    
    @Column(name="Amount", nullable=true, precision=19, scale=0)
    public java.math.BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(java.math.BigDecimal value) {
        this.amount = value;
    }
    
    @Column(name="InterestRate", nullable=false)
    public float getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(float value) {
        this.interestRate = value;
    }
    
    @Column(name="Ranking", nullable=false)
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int value) {
        this.ranking = value;
    }
    
    @Column(name="MortgageType", nullable=true)
    @Enumerated(EnumType.STRING)
    public LA_MortgageType getMortgageType() {
        return mortgageType;
    }
    public void setMortgageType(LA_MortgageType value) {
        this.mortgageType = value;
    }
    
    @ManyToMany(targetEntity=LA_Right.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_Right_LA_Mortgage", schema="ladm_administrative", joinColumns={ @JoinColumn(name="LA_MortgageLA_RRRID") }, inverseJoinColumns={ @JoinColumn(name="LA_RightLA_RRRID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_Right> getRights() {
        return rights;
    }
    public void setRights(java.util.Set<LA_Right> value) {
        this.rights = value;
    }
    
    @ManyToMany(targetEntity=LA_Party.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="LA_Party_LA_Mortgage", schema="ladm_party", joinColumns={ @JoinColumn(name="LA_MortgageLA_RRRID") }, inverseJoinColumns={ @JoinColumn(name="LA_PartyID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<LA_Party> getMoneyProvider() {
        return moneyProvider;
    }
    public void setMoneyProvider(java.util.Set<LA_Party> value) {
        this.moneyProvider = value;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
