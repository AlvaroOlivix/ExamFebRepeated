package com.example.examfebrepeated.features.album.data.remote

import com.example.examfebrepeated.features.album.domain.model.Album
import com.example.examfebrepeated.features.album.domain.model.Card
import com.example.examfebrepeated.features.album.domain.model.Mushroom
import org.koin.core.annotation.Single

@Single
class MockDataSource {

    private val mockMushrooms = listOf(
        Mushroom("1", "mush1", "image"),
        Mushroom("2", "mush2", "image"),
        Mushroom("3", "mush3", "image"),
        Mushroom("4", "mush4", "image")
    )
    private val mockMushrooms2 = listOf(
        Mushroom("1", "mush1", "image"), Mushroom("2", "mush2", "image")
    )

    private val mockCards = listOf(
        Card("001", mockMushrooms[0], "https://th.bing.com/th?id=OIF.CnQ1Mgka%2fnZyz7vd%2bQpvhg&w=127&h=180&c=7&r=0&o=5&pid=1.7", "latitude", "logitude", "date"),
        Card("002", mockMushrooms[1], "https://th.bing.com/th/id/OIP.DhYGA5Ha-cKlImbaamsArwHaKi?w=120&h=180&c=7&r=0&o=5&pid=1.7", "latitude", "logitude", "date"),
        Card("003", mockMushrooms[2], "https://th.bing.com/th/id/OIP.F1JOXlVf8vyXRsnsmyUrcAHaKc?w=128&h=181&c=7&r=0&o=5&pid=1.7", "latitude", "logitude", "date"),
        Card("004", mockMushrooms[2], "photo", "latitude", "logitude", "date")
    )
    private val mockCards2 = listOf(
        Card("001", mockMushrooms[0], "photo", "latitude", "logitude", "date"),
        Card("002", mockMushrooms[1], "photo", "latitude", "logitude", "date")
    )
    private val albums = listOf(
        Album("01", "album1", cards = mockCards, mockMushrooms),
        Album("02", "album2", cards = mockCards2, mockMushrooms2),
        Album("03", "album3", cards = mockCards, mockMushrooms),
        Album("04", "album4", cards = mockCards2, mockMushrooms2),
        Album("05", "album5", cards = mockCards, mockMushrooms),
        Album("06", "album6", cards = mockCards2, mockMushrooms2),
        Album("07", "album7", cards = mockCards, mockMushrooms),
        Album("08", "album8", cards = mockCards2, mockMushrooms2),
        Album("09", "album9", cards = mockCards, mockMushrooms),
        Album("10", "album10", cards = mockCards2, mockMushrooms2),
        Album("11", "album11", cards = mockCards, mockMushrooms),
        Album("12", "album12", cards = mockCards2, mockMushrooms2)
    )

    fun getAlbums(): List<Album> = albums

    fun getById(id: String): Album? = albums.find { it.id == id }
}