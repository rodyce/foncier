package org.rodyce.foncier.datamodel.ladm.special;

import java.io.Serializable;

public class Rational implements Serializable, Comparable<Rational> {
    private static final long serialVersionUID = 1L;
    
    private final int numerator;
    private final int denominator;
    
    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    public Rational(int nominator, int denominator) {
        this.numerator = nominator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    public double getValue() {
        return (double)numerator / denominator;
    }
    
    @Override
    public int hashCode() {
        return new Double(getValue()).hashCode();
    }

    @Override
    public int compareTo(Rational o) {
        return getValue() > o.getValue() ? 1 : getValue() < o.getValue() ? -1 : 0;
    }
    
    public boolean equals(Rational o) {
        return this.compareTo(o) == 0;
    }
    
    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

}
