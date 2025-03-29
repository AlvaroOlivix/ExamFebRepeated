package com.example.examfebrepeated.features.album.data.room

import com.example.examfebrepeated.features.album.domain.model.Album

fun Album.toEntity(): AlbumEntity {
    return AlbumEntity(
        id = this.id,
        name = this.name,
        cards = this.cards,
        mushroomsAvailables = this.mushroomsAvailables
    )
}

fun AlbumEntity.toModel(): Album {
    return Album(
        id = this.id,
        name = this.name,
        cards = this.cards,
        mushroomsAvailables = this.mushroomsAvailables
    )
}
