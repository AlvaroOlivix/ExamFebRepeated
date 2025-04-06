package com.example.examfebrepeated.features.album.domain

import com.example.examfebrepeated.features.album.domain.model.Album
import org.koin.core.annotation.Single

@Single
class GetAlbumByIdUseCase(private val albumRepository: AlbumRepository) {
    suspend operator fun invoke(albumId: String): Album? {
        return albumRepository.getAlbumById(albumId)
    }
}