package org.rodyce.foncier.datamodel.ladm.administrative

import org.hibernate.annotations.*
import org.hibernate.annotations.CascadeType
import org.rodyce.foncier.datamodel.ladm.special.LA_Source
import java.util.HashSet
import org.rodyce.foncier.datamodel.ladm.party.LA_Party
import java.io.Serializable
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Proxy(lazy = false)
@Table(name = "LA_AdministrativeSource", schema = "ladm_administrative")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("LA_AdministrativeSource")
@PrimaryKeyJoinColumn(name = "LA_SourceID", referencedColumnName = "ID")
class LA_AdministrativeSource : LA_Source(), Serializable {
    @Column(name = "AvailabilityStatus", nullable = true)
    @Enumerated(EnumType.STRING)
    var availabilityStatus: LA_AvailabilityStatusType? = null

    @Column(name = "Text", nullable = true)
    var text: String? = null

    @Column(name = "Type", nullable = true)
    @Enumerated(EnumType.STRING)
    var type: LA_AdministrativeSourceType? = null

    @ManyToMany(targetEntity = LA_BAUnit::class)
    @Cascade(CascadeType.SAVE_UPDATE, CascadeType.LOCK)
    @JoinTable(
        name = "LA_BAUnit_LA_AdministrativeSource",
        schema = "ladm_administrative",
        joinColumns = [JoinColumn(name = "LA_AdministrativeSourceLA_SourceID")],
        inverseJoinColumns = [JoinColumn(name = "LA_BAUnitID")]
    )
    @LazyCollection(
        LazyCollectionOption.TRUE
    )
    var units: Set<LA_BAUnit> = HashSet()

    @ManyToMany(targetEntity = LA_RRR::class)
    @Cascade(CascadeType.SAVE_UPDATE, CascadeType.LOCK)
    @JoinTable(
        name = "LA_RRR_LA_AdministrativeSource",
        schema = "ladm_administrative",
        joinColumns = [JoinColumn(name = "LA_AdministrativeSourceLA_SourceID")],
        inverseJoinColumns = [JoinColumn(name = "LA_RRRID")]
    )
    @LazyCollection(
        LazyCollectionOption.TRUE
    )
    var rrr: Set<LA_RRR> = HashSet()

    @ManyToMany(targetEntity = LA_Party::class)
    @Cascade(CascadeType.SAVE_UPDATE, CascadeType.LOCK)
    @JoinTable(
        name = "LA_Party_LA_AdministrativeSource",
        schema = "ladm_party",
        joinColumns = [JoinColumn(name = "LA_AdministrativeSourceLA_SourceID")],
        inverseJoinColumns = [JoinColumn(name = "LA_PartyID")]
    )
    @LazyCollection(
        LazyCollectionOption.TRUE
    )
    var conveyor: Set<LA_Party> = HashSet()


    override fun toString(): String {
        return super.toString()
    }
}