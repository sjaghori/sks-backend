package at.technikumwien.model

import com.fasterxml.jackson.annotation.JsonCreator

data class Article @JsonCreator constructor(
    val id: Long?,
    val title: String,
    val description: String,
    val image: String,
    val content: String,
    val sight: Sight,
    val author: Author,
)
