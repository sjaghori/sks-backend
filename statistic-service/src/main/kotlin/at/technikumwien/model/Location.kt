package at.technikumwien.model

import com.fasterxml.jackson.annotation.JsonCreator

data class Location @JsonCreator constructor(
    val id: Long,
    val latitude: Double,
    val longitude: Double,
)
