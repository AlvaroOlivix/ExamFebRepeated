package com.example.examfebrepeated.core.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.examfebrepeated.features.album.data.room.AlbumDao
import com.example.examfebrepeated.features.album.data.room.AlbumEntity
import com.example.examfebrepeated.features.album.data.room.Converters

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AlbumsDataBase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}