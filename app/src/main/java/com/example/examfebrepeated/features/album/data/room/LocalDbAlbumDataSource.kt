package com.example.examfebrepeated.features.album.data.room

import com.example.examfebrepeated.features.album.domain.model.Album

class LocalDbAlbumDataSource(private val albumDao: AlbumDao) {

    suspend fun getAlbumList(): List<Album> {
        return albumDao.getAlbums().map { it.toModel() }
    }

    suspend fun getAlbumById(alumId: String): Album? {
        return albumDao.getAlbumById(alumId)?.toModel()
    }

    suspend fun insertAlbum(album: Album) {
        albumDao.insertAlbum(album.toEntity())
    }

    suspend fun insertAlbumList(albums: List<Album>) {
        albumDao.insertAll(*albums.map { it.toEntity() }.toTypedArray())
    }

    suspend fun deleteAlbum(album: Album) {
        albumDao.deleteAlbum(album.toEntity())
    }
}