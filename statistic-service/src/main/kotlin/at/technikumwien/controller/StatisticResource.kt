package at.technikumwien.controller

import at.technikumwien.repository.StatisticRepository
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/resources/statistics", produces = ["application/json"])
class StatisticResource(val statisticRepository: StatisticRepository) {
    @GetMapping
    fun retrieveAllStatistics(): String? {
        return jacksonObjectWriter(statisticRepository.selectMostVisited())
    }

    @GetMapping("/dates")
    fun retrieveAllStatisticsBetweenDates(@RequestParam startDate: String?, @RequestParam endDate: String?): String? {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val startLocalDateTime = LocalDate.parse(startDate, formatter).atStartOfDay()
        val endLocalDateTime = LocalDate.parse(endDate, formatter).plusDays(1).atStartOfDay()
        return jacksonObjectWriter(statisticRepository.selectMostVisitedBetween(startLocalDateTime, endLocalDateTime))
    }

    @GetMapping("/last_month")
    fun getMonthlyStatistic(): String? = jacksonObjectWriter(
        statisticRepository.selectMostVisitedBetween(
            LocalDateTime.now().minusMonths(2),
            LocalDateTime.now().minusMonths(1)
        )
    )

    private fun <T> jacksonObjectWriter(entity: T): String? {
        val mapper = JsonMapper.builder().addModule(KotlinModule()).build()
        val writer = mapper.writer()
        return writer.writeValueAsString(entity)
    }
}