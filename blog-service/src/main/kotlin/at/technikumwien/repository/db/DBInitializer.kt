package at.technikumwien.repository.db


import at.technikumwien.entity.Article
import at.technikumwien.entity.Author
import at.technikumwien.entity.Sight
import at.technikumwien.entity.Location
import at.technikumwien.repository.ArticleRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class DBInitializer(private val articleRepository: ArticleRepository) {
    @EventListener(ApplicationReadyEvent::class)
    fun handleApplicationReady() {
        if (articleRepository.count() == 0L) {
            articleRepository.saveAll(
                listOf(
                    Article(
                        "Schönbrunn Palace attraction",
                        "lorem ipsum",
                        "https://images.unsplash.com/photo-1590689124643-7718f03b730d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1267&q=80",
                        "Located on Vienna's outskirts, the Baroque Schönbrunn Palace was completed in the early 1700s and was later converted into a summer residence by Empress Maria Theresa.  Highlights of a tour through the 40 rooms of the palace that are open to the public are the Royal apartments; the Great Gallery, with its ornate ceiling paintings; the Million Room; Maria Theresa's salon, with its carved and gilded rosewood panels; and the Hall of Mirrors, with its gold Rococo-framed mirrors. Behind the 1,441-room palace stretch 500 acres of parks and gardens, also in the 18th-century Baroque style. Your visit to Schönbrunn should include the many attractions spread throughout these grounds: formal gardens; a labyrinth; the Palm House, filled with tropical and exotic plants and butterflies; an Alpine garden with a farmhouse; Europe's oldest zoo; and the Classical Gloriette, a grand marble structure crowning a hill above the gardens. ",
                        Sight(
                            "Schönbrunn Palace",
                            "Schönbrunner Schloßstraße 47, 1130 Vienna",
                            Location(48.18611282922429, 16.312721084655557)
                        ),
                        Author(
                            "Sasan",
                            "Jaghori",
                        )
                    ),
                    Article(
                        "The Vienna Hofburg: Austria's Imperial Palace",
                        "lorem ipsum",
                        "https://images.unsplash.com/photo-1603804995518-fff3be6f4c58?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1955&q=80",
                        "The spectacular Hofburg Palace in Vienna was for centuries the seat of Austria's monarchy, the powerful Habsburgs. Now the President conducts state business in the same rooms that once belonged to Emperor Joseph II. Nearly every Austrian ruler since 1275 ordered additions or alterations, resulting in many different architectural influences, including Gothic, Renaissance, Baroque, Rococo, and Classicism. Together with its many attractive squares and gardens, the entire Hofburg complex occupies 59 acres encompassing 19 courtyards and 2,600 rooms. Highlights of a visit include the Imperial Silver Collection and an array of dining services giving a taste of the lavish imperial banquets that once took place here; the Sisi Museum, focusing on the life and times of Empress Elisabeth; and the Imperial Apartments, a series of 19 rooms once occupied by Emperor Franz Joseph and his wife.",
                        Sight(
                            "Vienna Hofburg",
                            "Michaelerkuppel, 1010 Vienna",
                            Location(48.207761554826064, 16.36609671343606)
                        ),
                        Author(
                            "John",
                            "Wick",
                        )
                    ),
                    Article(
                        "Melk Benedictine Abbey",
                        "lorem ipsum",
                        "https://www.globeguide.ca/wp-content/uploads/2016/03/Austria-Melk-Abbey-exterior.jpg",
                        "Melk Abbey is one of the world's most famous monastic sites, and its spectacular buildings are laid out around seven courtyards. The most prominent part of this massive 325-meter-long complex is the west end and its twin-towered church rising above a semicircular terrace range. Perched on a rocky outcrop high above the town of Melk and overlooking the Danube, the abbey contains numerous other great reasons to spend a few hours touring it: the tomb of Saint Coloman of Stockerau; the remains of Austria's first ruling family, the House of Babenberg; the superb 196-meter-long Imperial Corridor with its portraits of Austria's rulers, including one of the Empress Maria Theresa; and the Imperial Rooms with their displays relating to the abbey's history, along with statues and paintings.",
                        Sight(
                            "Melk Benedictine Abbey",
                            "Abt-Berthold-Dietmayr-Straße 1, 3390 Melk",
                            Location(48.22961928657541, 15.333504798094802)
                        ),
                        Author(
                            "Elon",
                            "Musk",
                        )
                    ),
                    Article(
                        "Skiing at Kitzbühel and Kitzbüheler Horn",
                        "lorem ipsum",
                        "https://images.unsplash.com/photo-1511766528000-31f5348b1dcf?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1823&q=80",
                        "some content here",
                        Sight(
                            "Kitzbühel",
                            "Kitzbühel",
                            Location(47.4364677, 12.3901256)
                        ),
                        Author(
                            "Hannibal",
                            "Lecter",
                        )
                    ),

                    Article(
                        "Belvedere Palace Summer",
                        "lorem ipsum",
                        "https://images.unsplash.com/photo-1526581671404-349f224db79b?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80",
                        "Another of Austria's most-visited palaces-and one that should definitely be included on your Vienna travel itinerary-is the spectacular Belvedere Palace (Schloss Belvedere). Referred to most often simply as The Belvedere, this important historic site is split into two major sections: the Upper (Oberes) and Lower (Unteres) Palaces. If you've only got time to explore one, make it the Upper Palace. Here, you'll find the largest portion of the attraction's impressive collection of artworks, as well as have the chance to view one of the country's best preserved architectural gems. Highlights include Sala Terrena, the main hall, notable for its statues and stucco vaulted ceiling; the Carlone Hall, with its ceiling fresco; the two-story Marble Hall, with its many sculptures and paintings; and the impressive Ceremonial Staircase.",
                        Sight(
                            "Belvedere Palace",
                            "Prinz Eugen-Straße 27, 1030 Vienna",
                            Location(48.19161454903226, 16.380975113435454)
                        ),
                        Author(
                            "John",
                            "Snow",
                        )
                    ),
                )
            )
        }
    }
}