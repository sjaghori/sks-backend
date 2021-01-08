package at.technikumwien.controller

import at.technikumwien.repository.SightRepository
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.dao.DataRetrievalFailureException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping(value = ["/resources/sights"], produces = ["application/json"])
class SightResource(
    val sightRepository: SightRepository,
) {
    @GetMapping
    fun retrieveAllSights(): String? {
        return jacksonObjectWriter("sights", sightRepository.findAll())
    }

    @GetMapping(value = ["/{id}"])
    fun getSightByID(@PathVariable id: Long, response: HttpServletResponse): String? {
        try {
            val sight = sightRepository.getOne(id)
            return jacksonObjectWriter("sight", sight)
        } catch (ex: DataRetrievalFailureException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sight Not Found")
        }
    }

    private fun <T> jacksonObjectWriter(rootName: String, entity: T): String? {
        val mapper = JsonMapper.builder().addModule(KotlinModule()).build()
        val writer = mapper.writer().withRootName(rootName)
        return writer.writeValueAsString(entity)
    }
}