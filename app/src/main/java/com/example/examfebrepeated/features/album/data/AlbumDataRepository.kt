package com.example.examfebrepeated.features.album.data

import com.example.examfebrepeated.features.album.data.remote.MockDataSource
import com.example.examfebrepeated.features.album.data.room.LocalDbAlbumDataSource
import com.example.examfebrepeated.features.album.domain.AlbumRepository
import com.example.examfebrepeated.features.album.domain.model.Album
import org.koin.core.annotation.Single

@Single
class AlbumDataRepository(
    private val localDbAlbumDataSource: LocalDbAlbumDataSource, private val mock: MockDataSource
) :
    AlbumRepository {
    override suspend fun getAlbumList(): List<Album> {
        val localList = localDbAlbumDataSource.getAlbumList()
        if (localList.isEmpty()) {
            val remoteList = mock.getAlbums()
            localDbAlbumDataSource.insertAlbumList(remoteList)
        }
        return localList
    }

    override suspend fun getAlbumById(albumId: String): Album? {
        val localAlbum = localDbAlbumDataSource.getAlbumById(albumId)
        if (localAlbum == null) {
            val remoteAlbum = mock.getById(albumId)
            if (remoteAlbum != null) {
                localDbAlbumDataSource.insertAlbum(remoteAlbum)
            }
        }
        return localAlbum
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

    override suspend fun updateAlbum(album: Album){
        localDbAlbumDataSource.updateAlbum(album)
    }
}