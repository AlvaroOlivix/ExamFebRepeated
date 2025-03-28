package com.example.examfebrepeated.feature.product.data.local

import com.example.examfebrepeated.feature.product.domain.model.Product

class ProductLocalDbdataSource(private val productDao: ProductDao) {

    fun getAll(): List<Product> {
        return productDao.getAll().map { it.toModel() }
    }

    fun getById(productId: String): Product? {
        return productDao.getById(productId)?.toModel()
    }

    fun save(product: Product) {
        productDao.saveProduct(product.toEntity())
    }

    fun saveList(products: List<Product>) {
        productDao.saveProductList(*products.map { it.toEntity() }.toTypedArray())
    }

    fun delete(product: Product) {
        productDao.delete(product.toEntity())
    }
}