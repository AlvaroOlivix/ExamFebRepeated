package com.example.examfebrepeated.feature.product.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.examfebrepeated.feature.product.domain.model.Category

private const val TABLE_NAME = "table_products"

@Entity(TABLE_NAME)
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "category") val category: Category
)