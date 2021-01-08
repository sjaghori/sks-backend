package at.technikumwien.repository

import at.technikumwien.entity.Bonus
import org.springframework.data.repository.CrudRepository

interface BonusRepository : CrudRepository<Bonus, Long>