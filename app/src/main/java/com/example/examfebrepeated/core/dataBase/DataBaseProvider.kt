package com.example.examfebrepeated.core.dataBase

import android.content.Context
import androidx.room.Room

object DataBaseProvider {
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}