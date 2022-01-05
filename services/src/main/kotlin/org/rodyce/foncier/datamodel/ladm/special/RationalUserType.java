package org.rodyce.foncier.datamodel.ladm.special;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

public class RationalUserType implements CompositeUserType {

    @Override
    public String[] getPropertyNames() {
        return new String[] {"nominator", "denominator"};
    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[] {StandardBasicTypes.INTEGER, StandardBasicTypes.INTEGER};
    }

    @Override
    public Object getPropertyValue(Object component, int property)
            throws HibernateException {
        Rational rational = (Rational)component;
        if (property == 0)
            return rational.getNumerator();
        else
            return rational.getDenominator();
    }

    @Override
    public void setPropertyValue(Object component, int property, Object value)
            throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class<?> returnedClass() {
        return Rational.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) return true;
        if (x == null || y == null) return false;
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names,
            SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        int numerator = rs.getInt(names[0]);
        if (rs.wasNull()) return null;
        
        int denominator = rs.getInt(names[1]);
        if (rs.wasNull()) return null;


        return new Rational(numerator, denominator);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
            SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, StandardBasicTypes.INTEGER.sqlType());
            st.setNull(index+1, StandardBasicTypes.INTEGER.sqlType());
        }
        else {
            Rational rational = (Rational)value;
            st.setInt(index, rational.getNumerator());
            st.setInt(index+1, rational.getDenominator());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value, SessionImplementor session)
            throws HibernateException {
        return (Serializable)value;
    }

    @Override
    public Object assemble(Serializable cached, SessionImplementor session,
            Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target,
            SessionImplementor session, Object owner) throws HibernateException {
        return original;
    }

}
