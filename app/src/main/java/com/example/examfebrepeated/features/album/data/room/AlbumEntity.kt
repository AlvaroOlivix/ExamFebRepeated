package com.example.examfebrepeated.features.album.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.examfebrepeated.features.album.domain.model.Card
import com.example.examfebrepeated.features.album.domain.model.Mushroom

const val TABLE = "albumTable"


@Entity(tableName = TABLE)
data class AlbumEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name="cards")val cards:List<Card>,
    @ColumnInfo(name ="mushroomsAvailables")val mushroomsAvailables:List<Mushroom>
)
