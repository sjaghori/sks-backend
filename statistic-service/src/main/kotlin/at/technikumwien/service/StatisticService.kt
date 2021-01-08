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
            val existingStatistic = statisticRepository.findDistinctTopBySightIdOrderByCounterDesc(topicData.sight.id)

            val statisticSaved = if (existingStatistic?.counter == null) {
                Statistic(topicData.sight.id, topicData.sight.name, 1)
            } else {
                Statistic(existingStatistic.id,
                    existingStatistic.sightId,
                    existingStatistic.sightName,
                    existingStatistic.counter!! + 1)
            }

            statisticRepository.save(statisticSaved)

            println(statisticRepository.selectMostVisited())
        } catch (e: Exception) {
            println(e.message)
        }
    }
}