package com.example.examfebrepeated.features.album.data.room

import androidx.room.TypeConverter
import com.example.examfebrepeated.features.album.domain.model.Card
import com.example.examfebrepeated.features.album.domain.model.Mushroom
import com.google.gson.Gson

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromCardToList(cards: List<Card>): String {
        return gson.toJson(cards)
    }

    @TypeConverter
    fun toCardList(data: String): List<Card> {
        return gson.fromJson(data, Array<Card>::class.java).toList()
    }

    @TypeConverter
    fun fromMushroomToList(mushrooms: List<Mushroom>): String {
        return gson.toJson(mushrooms)
    }

    @TypeConverter
    fun toMushroomList(data: String): List<Mushroom> {
        return gson.fromJson(data, Array<Mushroom>::class.java).toList()
    }
}