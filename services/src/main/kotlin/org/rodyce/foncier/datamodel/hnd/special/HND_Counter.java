package org.rodyce.foncier.datamodel.hnd.special;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_Counter", schema="hnd_special")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_Counter implements Serializable {
    private static final long serialVersionUID = 5017893330366357658L;
    
    private UUID id;
    private HND_CounterType type;
    private long count;
    
    
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
    
    @Column(name="Type", nullable=false)
    @Enumerated(EnumType.STRING)
    public HND_CounterType getType() {
        return type;
    }
    public void setType(HND_CounterType type) {
        this.type = type;
    }
    
    @Column(name="Count", nullable=false)
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    
    
}
