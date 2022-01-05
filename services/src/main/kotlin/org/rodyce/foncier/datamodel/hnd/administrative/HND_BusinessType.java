package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HND_BusinessType", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_BusinessType implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String description;
    
    
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
    
    @Column(name="Name", nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="Description", nullable=true)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
