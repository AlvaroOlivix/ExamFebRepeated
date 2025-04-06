package com.example.examfebrepeated.features.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examfebrepeated.features.album.domain.GetAlbumByIdUseCase
import com.example.examfebrepeated.features.album.domain.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CardsListViewModel(val getAlbumByIdUseCase: GetAlbumByIdUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun loadCards(albumId: String) {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val albumLoaded = getAlbumByIdUseCase(albumId)
            _uiState.postValue(UiState(album = albumLoaded))
        }
    }

    data class UiState(
        val album: Album? = null,
        val error: Boolean = false,
        val loading: Boolean = false
    )
}