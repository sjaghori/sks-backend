package at.technikumwien.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_bonus")
data class Bonus(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "articleid")
    val articleId: Long?,
    @Column(name = "article_name")
    val articleName: String,
    @Column(name = "authorid")
    val authorId: Long?,
    @Column(name = "author_name")
    val authorName: String?,
    @Transient
    var revenue: Long? = null,
) {
    @Column(name = "article_clicked_at", insertable = true, updatable = false)
    var clickTime: LocalDateTime? = null

    @Column(name = "payed_flag")
    var payedFlag: Boolean = false

    @Column(name = "payed_at")
    var payedAt: LocalDateTime? = null

    @PrePersist
    fun onCreate() {
        this.clickTime = LocalDateTime.now()
        this.payedFlag = false
    }

    @PreUpdate
    fun onUpdate() {
        this.payedAt = LocalDateTime.now()
    }

    // no args constructor
    constructor() : this(null, -1L, "", -1L, "")

    constructor(articleId: Long?, articleName: String, authorId: Long?, authorName: String?) :
            this(null,
                articleId = articleId,
                articleName = articleName,
                authorId = authorId,
                authorName = authorName)

    constructor(
        id: Long?,
        articleId: Long?,
        articleName: String,
        authorId: Long?,
        authorName: String?,
        revenue: Long?,
        clickTime: LocalDateTime?,
    ) :
            this(id = id,
                articleId = articleId,
                articleName = articleName,
                authorId = authorId,
                authorName = authorName,
                revenue = revenue) {
        this.clickTime = clickTime
    }
}
