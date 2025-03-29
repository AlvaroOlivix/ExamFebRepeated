package com.example.examfebrepeated.features.album.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.examfebrepeated.features.album.domain.model.Album

@Dao
interface AlbumDao {
    @Query("SELECT * FROM albumTable")
    suspend fun getAlbums(): List<AlbumEntity>

    @Query("SELECT * FROM albumTable WHERE id = :albumId LIMIT 1")
    suspend fun getAlbumById(albumId: String): AlbumEntity?

    @Insert
    suspend fun insertAll(vararg albums: AlbumEntity)

    @Insert
    suspend fun insertAlbum(album: AlbumEntity)

    @Delete
    suspend fun deleteAlbum(album: AlbumEntity)
}