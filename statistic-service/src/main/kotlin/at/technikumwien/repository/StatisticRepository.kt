package at.technikumwien.repository

import at.technikumwien.entity.Statistic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime

interface StatisticRepository : JpaRepository<Statistic, Long> {
    @Query(value =
    "SELECT new Statistic(s.id, s.sightId, s.sightName, count(all s), s.visitedAt) FROM Statistic s" +
            " GROUP BY s.sightId ORDER BY COUNT(all s) DESC"
    )
    fun selectMostVisited(): List<Statistic>

    @Query(value =
    "SELECT new Statistic(s.id, s.sightId, s.sightName, count(all s), s.visitedAt) FROM Statistic s" +
            " where s.visitedAt BETWEEN ?1 AND ?2 GROUP BY s.sightId ORDER BY COUNT(all s) DESC"
    )
    fun selectMostVisitedBetween(startDate: LocalDateTime, endDate: LocalDateTime): List<Statistic>
}