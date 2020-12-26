package at.technikumwien

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogServiceApplication

fun main(args: Array<String>) {
    runApplication<BlogServiceApplication>(*args)
}
