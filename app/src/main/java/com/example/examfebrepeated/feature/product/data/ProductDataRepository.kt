package com.example.examfebrepeated.feature.product.data

import com.example.examfebrepeated.feature.product.data.local.ProductLocalDbdataSource
import com.example.examfebrepeated.feature.product.domain.model.Product
import com.example.examfebrepeated.feature.product.domain.model.ProductRepository

class ProductDataRepository(private val localDbdataSource: ProductLocalDbdataSource) :
    ProductRepository {
    override fun getProductList(): List<Product>? {
        return localDbdataSource.getAll()
    }

    override fun getProductById(productId: String): Product? {
        return localDbdataSource.getById(productId)
    }

    override fun saveProduct(product: Product) {
        localDbdataSource.save(product)
    }

    override fun saveProductList(products: List<Product>) {
        localDbdataSource.saveList(products)
    }

    override fun deleteProduct(product: Product) {
        localDbdataSource.delete(product)
    }
}