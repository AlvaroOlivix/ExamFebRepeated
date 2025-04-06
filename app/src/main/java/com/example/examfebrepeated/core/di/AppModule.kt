package com.example.examfebrepeated.core.di

import android.content.Context
import com.example.examfebrepeated.core.dataBase.AlbumsDataBase
import com.example.examfebrepeated.core.dataBase.DataBaseProvider
import com.example.examfebrepeated.features.album.data.room.AlbumDao
import com.example.examfebrepeated.features.album.domain.AlbumRepository
import com.example.examfebrepeated.features.album.presentation.AlbumListViewModel
import com.google.gson.Gson
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.example.examfebrepeated")
class AppModule {
    @Single
    fun provideGson(): Gson = Gson()

    @Single
    fun provideDataBase(context: Context): AlbumsDataBase {
        return DataBaseProvider.provideDataBase(context)
    }
    @Single
    fun provideAlbumDao(database: AlbumsDataBase): AlbumDao {
        return database.albumDao()
    }



}