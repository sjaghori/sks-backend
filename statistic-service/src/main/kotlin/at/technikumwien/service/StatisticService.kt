package at.technikumwien.service

import at.technikumwien.entity.Statistic
import at.technikumwien.model.Article
import at.technikumwien.repository.StatisticRepository
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
class StatisticService(
    val statisticRepository: StatisticRepository,
) {
    @StreamListener(Sink.INPUT)
    fun process(topicData: Article) {
        try {
            // create an entry
            val statisticSaved = Statistic(topicData.sight.id, topicData.sight.name)
            statisticRepository.save(statisticSaved)

        } catch (e: Exception) {
            println(e.message)
        }
    }
}