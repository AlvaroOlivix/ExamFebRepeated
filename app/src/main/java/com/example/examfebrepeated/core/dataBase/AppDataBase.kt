package com.example.examfebrepeated.core.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.examfebrepeated.feature.product.data.local.ProductDao
import com.example.examfebrepeated.feature.product.data.local.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}