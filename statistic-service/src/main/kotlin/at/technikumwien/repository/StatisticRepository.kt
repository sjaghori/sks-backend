package at.technikumwien.repository

import at.technikumwien.entity.Statistic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StatisticRepository : JpaRepository<Statistic, Long> {

    fun findDistinctTopBySightIdOrderByCounterDesc(id: Long?): Statistic?

    @Query(
        value = "SELECT * FROM t_statistic ORDER BY counter DESC LIMIT 1",
        nativeQuery = true)
    fun selectMostVisited(): Statistic?

    //fun countStatistic(): Long
}