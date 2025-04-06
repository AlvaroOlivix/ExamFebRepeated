package com.example.examfebrepeated.features.album.presentation.adapterCard

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.examfebrepeated.features.album.domain.model.Card
import org.koin.core.annotation.Single

@Single
class CardDiffUtil : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id // Comparar por ID único
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem // Comparar todo el contenido
    }
}
