package com.example.examfebrepeated.feature.product.data.local
import com.example.examfebrepeated.feature.product.domain.model.Product

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        name = this.name,
        date = this.date,
        image = this.image,
        category = this.category
    )
}

fun ProductEntity.toModel(): Product {
    return Product(
        id = this.id,
        name = this.name,
        date = this.date,
        image = this.image,
        category = this.category
    )
}