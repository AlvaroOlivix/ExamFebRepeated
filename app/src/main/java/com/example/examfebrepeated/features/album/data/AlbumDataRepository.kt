package com.example.examfebrepeated.features.album.data

import com.example.examfebrepeated.features.album.data.room.LocalDbAlbumDataSource
import com.example.examfebrepeated.features.album.domain.AlbumRepository
import com.example.examfebrepeated.features.album.domain.model.Album

class AlbumDataRepository(private val localDbAlbumDataSource: LocalDbAlbumDataSource):AlbumRepository {
    override suspend fun getAlbumList(): List<Album> {
        return localDbAlbumDataSource.getAlbumList()
    }

    override suspend fun getAlbumById(albumId: String): Album? {
        return localDbAlbumDataSource.getAlbumById(albumId)
    }

    override suspend fun saveAlbum(album: Album) {
        localDbAlbumDataSource.insertAlbum(album)
    }

    override suspend fun saveAllAlbums(albums: List<Album>) {
        localDbAlbumDataSource.insertAlbumList(albums)
    }

    override suspend fun deleteAlbum(album: Album) {
        localDbAlbumDataSource.deleteAlbum(album)
    }
}