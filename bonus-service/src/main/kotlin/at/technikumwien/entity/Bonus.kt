package at.technikumwien.entity

import javax.persistence.*

@Entity
@Table(name = "t_bonus")
data class Bonus(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,


)
