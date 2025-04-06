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
    }


}