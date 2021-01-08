package at.technikumwien.model

import com.fasterxml.jackson.annotation.JsonCreator

data class Location @JsonCreator constructor(
    val id: Long?,
    var latitude: Double,
    var longitude: Double,
)
