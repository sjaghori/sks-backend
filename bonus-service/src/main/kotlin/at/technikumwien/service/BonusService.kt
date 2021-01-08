package at.technikumwien.service

import at.technikumwien.model.Article
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
class BonusService {
    @StreamListener(Sink.INPUT)
    fun handleBonus(topicData: Article) {
        println("here comes topicData: $topicData")
    }
}