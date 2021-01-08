package at.technikumwien.repository

import at.technikumwien.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long>