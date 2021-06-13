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
    @Transient
    var counter: Long? = null,
) {
    @Column(name = "visited_at", insertable = true, updatable = false)
    var visitedAt: LocalDateTime? = null

    @PrePersist
    fun onCreate() {
        this.visitedAt = LocalDateTime.now()
    }

    // No args constructor
    constructor() : this(null, -1L, "")

    constructor(sightId: Long, sightName: String) : this(null,
        sightId = sightId,
        sightName = sightName
    )

    constructor(sightId: Long, sightName: String, visitedAt: LocalDateTime?) :
            this(sightId, sightName) {
        this.visitedAt = visitedAt
    }

    constructor(id: Long?, sightId: Long, sightName: String, counter: Long?, visitedAt: LocalDateTime?) :
            this(id, sightId, sightName, counter) {
        this.visitedAt = visitedAt
    }
}
