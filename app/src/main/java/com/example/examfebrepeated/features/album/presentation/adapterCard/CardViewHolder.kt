package com.example.examfebrepeated.features.album.presentation.adapterCard

import androidx.recyclerview.widget.RecyclerView
import com.example.examfebrepeated.core.extensions.loadUrl
import com.example.examfebrepeated.databinding.ItemCardBinding
import com.example.examfebrepeated.features.album.domain.model.Card

class CardViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(card: Card){
        binding.apply {
            name.text = card.cardSroom.name
            image.loadUrl(card.photo)
        }

    }
}