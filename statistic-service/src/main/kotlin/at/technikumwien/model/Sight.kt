package at.technikumwien.model

import com.fasterxml.jackson.annotation.JsonCreator

data class Sight @JsonCreator constructor(
    val id: Long,
    val name: String,
    val address: String,
    val location: Location,
)
