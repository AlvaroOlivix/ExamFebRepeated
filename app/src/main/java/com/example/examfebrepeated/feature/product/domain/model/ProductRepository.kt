package com.example.examfebrepeated.feature.product.domain.model

interface ProductRepository {
    fun getProductList(): List<Product>?
    fun getProductById(productId: String): Product?
    fun saveProduct(product: Product)
    fun saveProductList(products: List<Product>)
    fun deleteProduct(product: Product)

    // fun updateProduct()
}