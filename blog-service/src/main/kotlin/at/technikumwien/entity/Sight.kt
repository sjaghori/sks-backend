package at.technikumwien.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "t_sight")
data class Sight(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var name: String?,

    var address: String?,

    @OneToOne(targetEntity = Location::class, cascade = [CascadeType.ALL])
    var location: Location?,

    /*@OneToMany(targetEntity = Article::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "articleid")
    var article: Collection<Article>*/

) {
    constructor(name: String?, address: String?, location: Location?, /*article: Collection<Article>*/) : this(
        null,
        name = name,
        address = address,
        location = location,
        //article = article
    )
}
