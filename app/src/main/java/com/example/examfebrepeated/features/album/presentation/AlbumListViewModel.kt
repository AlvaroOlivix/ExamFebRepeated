package com.example.examfebrepeated.features.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examfebrepeated.features.album.domain.EditAlbumUseCase
import com.example.examfebrepeated.features.album.domain.GetAlbumListUseCase
import com.example.examfebrepeated.features.album.domain.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AlbumListViewModel(
    private val getAlbumListUseCase: GetAlbumListUseCase,
    private val editAlbumUseCase: EditAlbumUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    private var albumsVM: List<Album> = emptyList()
    private var showingFavoritesOnly = false


    fun getAlbums() {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                albumsVM = getAlbumListUseCase() // Obtiene los álbumes
                _uiState.postValue(UiState(albums = albumsVM)) // Actualiza la UI
            } catch (e: Exception) {
                _uiState.postValue(UiState(error = true)) // Manejo de error
            }
        }
    }

    fun toggleFavorite(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            editAlbumUseCase(album)
            albumsVM = albumsVM.map {
                if (it.id == album.id) album.copy(isFavorite = !album.isFavorite) else it
            }
            _uiState.postValue(UiState(albums = albumsVM))
        }
    }

    fun showFavorites():Boolean {
        showingFavoritesOnly = !showingFavoritesOnly
        val filteredList = if (showingFavoritesOnly) {
            albumsVM.filter { it.isFavorite }
        } else {
            albumsVM
        }
        _uiState.value = UiState(albums = filteredList)
        return showingFavoritesOnly
    }


    class UiState(
        val albums: List<Album> = emptyList(),
        val error: Boolean = false,
        val loading: Boolean = false
    )

}