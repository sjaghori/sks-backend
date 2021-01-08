package at.technikumwien.repository

import at.technikumwien.entity.Sight
import org.springframework.data.jpa.repository.JpaRepository

interface SightRepository : JpaRepository<Sight, Long>