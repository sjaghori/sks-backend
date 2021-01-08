package at.technikumwien.repository

import at.technikumwien.entity.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>