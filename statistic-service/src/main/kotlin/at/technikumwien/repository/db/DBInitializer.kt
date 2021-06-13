package at.technikumwien.repository.db

import at.technikumwien.entity.Statistic
import at.technikumwien.repository.StatisticRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import java.time.LocalDateTime

@Configuration
class DBInitializer(private val statisticRepository: StatisticRepository) {
    @EventListener(ApplicationReadyEvent::class)
    fun populateDatabase() {
        if (statisticRepository.count() == 0L) {
            /*statisticRepository.saveAll(
                listOf(
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 11, 15, 13, 37)
                    ),
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 10, 13, 15, 37)
                    ),
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 11, 13, 11, 37)
                    ),
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 11, 11, 14, 37)
                    ),
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 11, 12, 15, 37)
                    ),
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 11, 14, 12, 37)
                    ),
                    Statistic(
                        1,
                        "Schönbrunn Palace",
                        LocalDateTime.of(2020, 11, 18, 10, 37)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 11, 17, 10, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 11, 16, 22, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 11, 15, 23, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 11, 12, 6, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 11, 12, 15, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 10, 26, 11, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2020, 12, 3, 13, 44)
                    ),
                    Statistic(
                        3,
                        "Melk Benedictine Abbey",
                        LocalDateTime.of(2021, 1, 2, 10, 44)
                    ),
                )
            )*/
        }
    }
}
