package com.example.examfebrepeated.features.album.domain

import com.example.examfebrepeated.features.album.domain.model.Album

interface AlbumRepository {
    suspend fun getAlbumList(): List<Album>
    suspend fun getAlbumById(albumId: String): Album?
    suspend fun saveAlbum(album: Album)
    suspend fun saveAllAlbums(albums:List<Album>)
    suspend fun deleteAlbum(album: Album)
}