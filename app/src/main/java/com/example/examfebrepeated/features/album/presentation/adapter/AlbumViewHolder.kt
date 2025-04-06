package com.example.examfebrepeated.features.album.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.examfebrepeated.R
import com.example.examfebrepeated.core.extensions.loadUrl
import com.example.examfebrepeated.databinding.ItemAlbumBinding
import com.example.examfebrepeated.features.album.domain.model.Album

class AlbumViewHolder(private val binding: ItemAlbumBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(album: Album, onClick: (Album) -> Unit, bookMark:(Album) -> Unit) {
        binding.apply {
            nombre.text = album.name
            //Imagen con Url
            image.loadUrl(album.name)
            updateFavoriteIcon(album.isFavorite)
            root.setOnClickListener { onClick(album)}
            bookmark.setOnClickListener{bookMark(album)}
        }
    }
    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconRes = if (isFavorite) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24
        binding.bookmark.setImageResource(iconRes)
    }

}
