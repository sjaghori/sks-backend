package at.technikumwien.entity

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_article")
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var title: String,

    var description: String,

    var image: String,

    @Lob
    var content: String,

    @ManyToOne(targetEntity = Sight::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "sightid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var sight: Sight,

    @ManyToOne(targetEntity = Author::class, cascade = [CascadeType.ALL])
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var author: Author,
) {

    @Column(insertable = true, updatable = false)
    lateinit var publicationDate: LocalDateTime

    //@Column
    //lateinit var modified: LocalDateTime

    @PrePersist
    fun onCreate() {
        this.publicationDate = LocalDateTime.now()
        //this.modified = LocalDateTime.now()
    }

    //@PreUpdate
    //fun onUpdate() {
    //    this.modified = LocalDateTime.now()
    //}

    constructor(
        title: String,
        description: String,
        image: String,
        content: String,
        sight: Sight,
        author: Author,
    ) : this(
        null,
        title = title,
        description = description,
        image = image,
        content = content,
        sight = sight,
        author = author
    )
}