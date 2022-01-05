package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="HND_LegalPerson", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="ExtPartyID")
public class HND_LegalPerson extends HND_Person implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

}
