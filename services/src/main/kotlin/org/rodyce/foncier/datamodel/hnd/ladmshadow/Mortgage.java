package org.rodyce.foncier.datamodel.hnd.ladmshadow;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.*;

import org.rodyce.foncier.datamodel.ladm.administrative.LA_MortgageType;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Mortgage", schema="ladmshadow")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Mortgage")
public class Mortgage extends Restriction implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private java.math.BigDecimal amount;
    private float interestRate;
    private int ranking;
    private LA_MortgageType mortgageType;
    private java.util.Set<Right> rights = new HashSet<Right>();
    private java.util.Set<Party> moneyProvider = new HashSet<Party>();

    
    public Mortgage() {
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
    
    @ManyToMany(targetEntity=Right.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Right_Mortgage", schema="ladmshadow", joinColumns={ @JoinColumn(name="MortgageRRRID") }, inverseJoinColumns={ @JoinColumn(name="RightRRRID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<Right> getRights() {
        return rights;
    }
    public void setRights(java.util.Set<Right> value) {
        this.rights = value;
    }
    
    @ManyToMany(targetEntity=Party.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Party_Mortgage", schema="ladmshadow", joinColumns={ @JoinColumn(name="MortgageRRRID") }, inverseJoinColumns={ @JoinColumn(name="PartyID") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public java.util.Set<Party> getMoneyProvider() {
        return moneyProvider;
    }
    public void setMoneyProvider(java.util.Set<Party> value) {
        this.moneyProvider = value;
    }
    
    @Override
    public Mortgage clone() {
        Mortgage clonedMortgage = (Mortgage) super.clone();
        
        clonedMortgage.setAmount(amount);
        clonedMortgage.setInterestRate(interestRate);
        clonedMortgage.setRanking(ranking);
        clonedMortgage.setMortgageType(mortgageType);
        clonedMortgage.setRights(new HashSet<Right>(rights));
        clonedMortgage.setMoneyProvider(new HashSet<Party>(moneyProvider));
        
        return clonedMortgage;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
