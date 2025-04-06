package com.example.examfebrepeated.core.dataBase

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.Single

object DataBaseProvider {
    fun provideDataBase(context: Context): AlbumsDataBase {
        return Room.databaseBuilder(
            context,
            AlbumsDataBase::class.java, "database-name"
        ).build()
    }
}