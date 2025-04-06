package com.example.examfebrepeated.features.album.domain

import com.example.examfebrepeated.features.album.domain.model.Album
import org.koin.core.annotation.Single

@Single
class GetAlbumListUseCase(private val albumRepository: AlbumRepository) {
    suspend operator fun invoke(): List<Album> {
        return albumRepository.getAlbumList()
    }
}