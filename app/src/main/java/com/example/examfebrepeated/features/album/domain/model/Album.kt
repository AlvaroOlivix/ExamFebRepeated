package com.example.examfebrepeated.features.album.domain.model

data class Album(
    val id: String,
    val name: String,
    val cards: List<Card>,
    val mushroomsAvailables: List<Mushroom>
)
