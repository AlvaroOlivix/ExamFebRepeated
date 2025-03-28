package com.example.examfebrepeated.core.dataBase

import androidx.room.TypeConverter
import com.example.examfebrepeated.feature.product.domain.model.Category
import com.google.gson.Gson

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun categoryToData(category: Category): String {
        return gson.toJson(category)
    }

    @TypeConverter
    fun dataToCategory(data: String): Category {
        return gson.fromJson(data, Category::class.java)
    }
}