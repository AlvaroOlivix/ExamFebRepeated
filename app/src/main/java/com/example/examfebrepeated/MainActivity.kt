package com.example.examfebrepeated

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.examfebrepeated.core.dataBase.AlbumsDataBase
import com.example.examfebrepeated.core.dataBase.DataBaseProvider
import com.example.examfebrepeated.features.album.data.AlbumDataRepository
import com.example.examfebrepeated.features.album.data.room.LocalDbAlbumDataSource
import com.example.examfebrepeated.features.album.domain.model.Album
import com.example.examfebrepeated.features.album.domain.model.Card
import com.example.examfebrepeated.features.album.domain.model.Mushroom
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        executeRoom()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeRoom() {
        val mockMushooms = listOf(
            Mushroom("01", "Seta1", "UrlImage"),
            Mushroom("02", "Seta2", "UrlImage"),
            Mushroom("03", "Seta3", "UrlImage")
        )
        val mockMushroom2 = listOf(
            Mushroom("04", "Seta1", "UrlImage"),
            Mushroom("05", "Seta2", "UrlImage")
        )
        val mockCards = listOf(
            Card("001", mockMushooms[0], "urlPhoto", "Lat1", "Long1", "23/09/2002"),
            Card("002", mockMushooms[1], "urlPhoto2", "Lat2", "Long2", "02/01/2020"),
            Card("003", mockMushooms[2], "urlPhoto3", "Lat3", "Long3", "29/07/2022")
        )
        val mockAlbums = listOf(
            Album(
                "1",
                "AlbumAutonómicas",
                cards = listOf(mockCards[0], mockCards[1]),
                mockMushroom2
            ),
            Album("2", "AlbumNacionales", mockCards, mockMushooms)
        )


        /*
            Método 1 para crear la base de datos, sin provider que sería digamos el singleton,
            cada vez que queramos usarla se crea una nueva instancia.


        val db1 = Room.databaseBuilder(
            applicationContext,
            AlbumsDataBase::class.java, "database-name"
        ).build()

        */

        /*
            Método 2, de esta forma usamos una instancia ya creada en otra clase llamada DataBaseProvider.
         */

        val db2 = DataBaseProvider.provideDataBase(this)
        val repos = AlbumDataRepository(LocalDbAlbumDataSource(db2.albumDao()))

        val albumCreated = Album(
            "3",
            "AlbumNotEnded",
            cards = listOf(mockCards[0]),
            mockMushroom2
        )

        GlobalScope.launch(Dispatchers.IO) {

            repos.saveAllAlbums(mockAlbums)
            Log.d("@dev", repos.getAlbumList().toString())
            repos.saveAlbum(albumCreated)
            Log.d("@dev", repos.getAlbumList().toString())
            repos.deleteAlbum(albumCreated)
            Log.d("@dev", repos.getAlbumList().toString())

        }
    }
}