package at.technikumwien.repository

import at.technikumwien.entity.Bonus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BonusRepository : JpaRepository<Bonus, Long> {
    @Query(value =
    "SELECT new Bonus(b.id, b.articleId, b.articleName, b.authorId, b.authorName, count(all b), b.clickTime) FROM Bonus b WHERE" +
            " b.payedFlag = false GROUP BY b.articleId ORDER BY COUNT(all b) DESC"
    )
    fun selectArticleRevenue(): List<Bonus>
}