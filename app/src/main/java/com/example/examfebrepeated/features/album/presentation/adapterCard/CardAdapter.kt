package com.example.examfebrepeated.features.album.presentation.adapterCard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.examfebrepeated.databinding.ItemCardBinding
import com.example.examfebrepeated.features.album.domain.model.Card

class CardAdapter : ListAdapter<Card, CardViewHolder>(CardDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = getItem(position)
        holder.bind(card)
    }
}