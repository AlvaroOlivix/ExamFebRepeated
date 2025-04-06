package com.example.examfebrepeated.features.album.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.examfebrepeated.features.album.domain.model.Album
import org.koin.core.annotation.Single

@Single
class AlbumDiffUtil : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}
