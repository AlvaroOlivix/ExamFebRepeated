package com.example.examfebrepeated.feature.product.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.examfebrepeated.feature.product.domain.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM table_products")
    fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM table_products WHERE id LIKE :productId")
    fun getById(productId: String): ProductEntity?

    @Insert
    fun saveProduct(product: ProductEntity)

    @Insert
    fun saveProductList(vararg product: ProductEntity)

    @Delete
    fun delete(product: ProductEntity)
}