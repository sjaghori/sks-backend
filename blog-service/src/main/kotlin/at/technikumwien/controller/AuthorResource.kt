package at.technikumwien.controller

import at.technikumwien.repository.AuthorRepository
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
@RequestMapping(value = ["/resources/authors"], produces = ["application/json"])
class AuthorResource(
    val authorRepository: AuthorRepository
) {
    @GetMapping
    fun retrieveAllAuthors(): String? {
        return jacksonObjectWriter(authorRepository.findAll())
    }

    @GetMapping(value = ["/{id}"])
    fun getAuthorByID(@PathVariable id: Long, response: HttpServletResponse): String? {
        try {
            val author = authorRepository.getOne(id)
            return jacksonObjectWriter(author)
        } catch (ex: DataRetrievalFailureException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Author Not Found")
        }
    }

    private fun <T> jacksonObjectWriter(entity: T): String? {
        val mapper = JsonMapper.builder().addModule(KotlinModule()).build()
        val writer = mapper.writer()
        return writer.writeValueAsString(entity)
    }
}