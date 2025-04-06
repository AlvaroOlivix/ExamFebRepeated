package com.example.examfebrepeated.features.album.domain

import com.example.examfebrepeated.features.album.domain.model.Album
import org.koin.core.annotation.Single

@Single
class EditAlbumUseCase(private val repository: AlbumRepository) {
    suspend operator fun invoke(album: Album){
        val updated = album.copy(isFavorite = !album.isFavorite)
        repository.updateAlbum(updated)
    }
}