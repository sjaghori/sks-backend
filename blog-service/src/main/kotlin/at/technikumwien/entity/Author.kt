package at.technikumwien.entity

import javax.persistence.*

@Entity
@Table(name = "t_author")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "first_name")
    var firstName: String?,

    @Column(name = "last_name")
    var lastName: String?,
) {
    constructor(firstName: String?, lastName: String?) : this(null,
        firstName = firstName,
        lastName = lastName)
}