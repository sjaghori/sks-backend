package at.technikumwien.controller

import at.technikumwien.entity.Article
import at.technikumwien.repository.ArticleRepository
import at.technikumwien.repository.AuthorRepository
import at.technikumwien.repository.SightRepository
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.cloud.stream.messaging.Source
import org.springframework.dao.DataRetrievalFailureException
import org.springframework.http.HttpStatus
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.interceptor.TransactionInterceptor
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/resources/blogs"], produces = ["application/json"])
class BlogResource(
    val articleRepository: ArticleRepository,
    val authorRepository: AuthorRepository,
    val sightRepository: SightRepository,
    val source: Source,
) {
    @GetMapping
    fun retrieveAllArticles(): String? {
        return jacksonObjectWriter(articleRepository.findAll())
    }

    @GetMapping(value = ["/{id}"])
    fun getArticleByID(@PathVariable id: Long, response: HttpServletResponse): String? {
        try {
            val article = articleRepository.getOne(id)

            source.output().send(message(article))

            return jacksonObjectWriter(article)
        } catch (ex: DataRetrievalFailureException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Article Not Found")
        }
    }

    @Transactional
    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun createArticle(@RequestBody @Valid article: Article, response: HttpServletResponse): Article {
        try {
            val author = article.author.id?.let { authorRepository.findById(it) }
            article.author = author?.get() ?: article.author

            val sight = article.sight.id?.let { sightRepository.findById(it) }
            article.sight = sight?.get() ?: article.sight

            return articleRepository.save(article)
        } catch (ex: Exception) {
            TransactionInterceptor.currentTransactionStatus().setRollbackOnly()
            throw ResponseStatusException(HttpStatus.MULTI_STATUS, "Could not create article")
        }
    }

    private fun <T> message(payload: T): Message<T> {
        return MessageBuilder.withPayload(payload).build()
    }

    private fun <T> jacksonObjectWriter(entity: T): String? {
        val mapper = JsonMapper.builder().addModule(KotlinModule()).build()
        val writer = mapper.writer()
        return writer.writeValueAsString(entity)
    }
}