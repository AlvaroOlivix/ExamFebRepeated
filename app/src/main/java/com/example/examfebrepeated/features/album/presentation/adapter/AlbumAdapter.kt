package com.example.examfebrepeated.features.album.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.examfebrepeated.databinding.ItemAlbumBinding
import com.example.examfebrepeated.features.album.domain.model.Album

class AlbumAdapter(
    private val onClick: (Album) -> Unit,
    private val bookMark: (Album) -> Unit,

    ) : ListAdapter<Album, AlbumViewHolder>(AlbumDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album, onClick, bookMark)
    }

}