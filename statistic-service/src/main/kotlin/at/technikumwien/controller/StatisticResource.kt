package at.technikumwien.controller

import at.technikumwien.repository.StatisticRepository
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/resources/statistics", produces = ["application/json"])
class StatisticResource(val statisticRepository: StatisticRepository) {
    @GetMapping
    fun retrieveAllStatistics(): String? {
        return jacksonObjectWriter("statistics", statisticRepository.findAll())
    }

    @GetMapping("/popular")
    fun getMostPopular(): String? {
        return jacksonObjectWriter("statistics", statisticRepository.selectMostVisited())
    }

    /*@GetMapping("/count")
    fun getSumOfCounter(): Long? = statisticRepository.countStatistic()*/

    private fun <T> jacksonObjectWriter(rootName: String, entity: T): String? {
        val mapper = JsonMapper.builder().addModule(KotlinModule()).build()
        val writer = mapper.writer().withRootName(rootName)
        return writer.writeValueAsString(entity)
    }
}