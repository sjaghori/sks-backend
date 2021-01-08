package at.technikumwien.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_statistic")
data class Statistic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "sightid")
    val sightId: Long,
    @Column(name = "sight_name")
    val sightName: String,

    @GeneratedValue(strategy = GenerationType.AUTO)
    var counter: Long?,
) {

    @Column(name = "first_visit", insertable = true, updatable = false)
    lateinit var firstVisit: LocalDateTime

    @Column(name = "last_visit")
    lateinit var lastVisit: LocalDateTime

    @PrePersist
    fun onCreate() {
        this.firstVisit = LocalDateTime.now()
        this.lastVisit = LocalDateTime.now()
    }

    @PreUpdate
    fun onUpdate() {
        this.lastVisit = LocalDateTime.now()
    }

    constructor(sightId: Long, sightName: String, counter: Long?) : this(null,
        sightId = sightId,
        sightName = sightName,
        counter = counter)

    constructor(sightId: Long, sightName: String) : this(null,
        sightId = sightId,
        sightName = sightName,
        counter = null)

    // No args constructor
    constructor() : this(null, -1L, "", null)
}
