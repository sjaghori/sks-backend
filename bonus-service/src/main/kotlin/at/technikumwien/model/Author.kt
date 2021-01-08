package at.technikumwien.model

import com.fasterxml.jackson.annotation.JsonCreator

data class Author @JsonCreator constructor(
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
)