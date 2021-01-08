package at.technikumwien.entity

import javax.persistence.*

@Entity
@Table(name = "t_location")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    var latitude: Double,

    var longitude: Double,

    //@OneToOne(mappedBy = "location")
    //var sight: Sight,
) {
    constructor(latitude: Double, longitude: Double, /*sight: Sight*/) : this(null,
        latitude = latitude,
        longitude = longitude,
        /*sight = sight*/)
}