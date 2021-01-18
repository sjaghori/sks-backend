package at.technikumwien.service

import at.technikumwien.entity.Bonus
import at.technikumwien.model.Article
import at.technikumwien.repository.BonusRepository
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@EnableScheduling
class BonusService(
    val bonusRepository: BonusRepository,
) {
    @StreamListener(Sink.INPUT)
    @Transactional
    fun handleBonus(topicData: Article) {
        try {
            // create an entry in the database
            val savedBonus = Bonus(topicData.id, topicData.title, topicData.author.id, topicData.author.lastName)
            bonusRepository.save(savedBonus)
        } catch (e: Exception) {
            println(e.message)
        }
    }

    // cron job to be executed 5th day of every month at 05:00 AM
    /*@Scheduled(cron = "0 00 05 5 * ?", zone = "Europe/Paris")*/
    // cron job to be executed every 1 minutes
    @Scheduled(cron = "0 */1 * ? * *", zone = "Europe/Paris")
    fun run() {
        try {
            processEntriesPayment()
            flagAllEntries()
        } catch (e: Exception) {
            println(e.message)
        }
    }

    private fun processEntriesPayment() {
        // get all entries, which has a false payment flag
        val bonusToPay = bonusRepository.selectArticleRevenue()

        for (bonus in bonusToPay) {
            val clickToCent: Double = (bonus.revenue?.div(100.0)) ?: 0.0
            println("Payment Info: ${bonus.authorName} will get a $clickToCent\$ paycheck!")
        }
    }

    private fun flagAllEntries() {
        // flag payed revenue
        val allEntries = bonusRepository.findAll()
        for (entry in allEntries) {
            entry.payedFlag = true
            bonusRepository.save(entry)
        }
    }
}