package org.rodyce.foncier.datamodel.hnd.administrative;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.rodyce.foncier.datamodel.hnd.administrative.HND_UserRoleType;
import org.hibernate.annotations.GenericGenerator;
import org.rodyce.foncier.datamodel.hnd.administrative.HND_User;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="HND_UserRole", schema="hnd_administrative")
@Inheritance(strategy=InheritanceType.JOINED)
public class HND_UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    public HND_UserRole() {
    }
    
    private UUID userroleID;
    public HND_User user;
    private HND_UserRoleType role;
    

    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    public UUID getUserroleID() {
        return userroleID;
    }
    public void setUserroleID(UUID value) {
        this.userroleID = value;
    }
    
    @Column(name="Role", nullable=true)
    @Enumerated(EnumType.STRING)
    public HND_UserRoleType getRole() {
        return role;
    }
    public void setRole(HND_UserRoleType value) {
        this.role = value;
    }
    
    
    public String toString() {
        return String.valueOf(getUserroleID());
    }
    
}
