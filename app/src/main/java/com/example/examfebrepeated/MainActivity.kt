package com.example.examfebrepeated

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examfebrepeated.core.dataBase.AppDatabase
import com.example.examfebrepeated.core.dataBase.DataBaseProvider
import com.example.examfebrepeated.feature.product.data.ProductDataRepository
import com.example.examfebrepeated.feature.product.data.local.ProductLocalDbdataSource
import com.example.examfebrepeated.feature.product.domain.model.Category
import com.example.examfebrepeated.feature.product.domain.model.Product
import com.example.examfebrepeated.feature.product.domain.model.ProductRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        executeRoom()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeRoom() {

        val mockCategories = listOf(
            Category("01", "Cat1"),
            Category("02", "Cat2"),
            Category("03", "Cat3")
        )
        val mockProducts = listOf(
            Product("1", "name", "date", "image", mockCategories[0]),
            Product("2", "name2", "date2", "image2", mockCategories[1]),
            Product("3", "name3", "date3", "image3", mockCategories[1]),
            Product("4", "name4", "date4", "image4", mockCategories[2]),
            Product("5", "name5", "date5", "image5", mockCategories[1])
        )
        val db = DataBaseProvider.provideDataBase(this)
        val repository = ProductDataRepository(ProductLocalDbdataSource(db.productDao()))

        GlobalScope.launch(Dispatchers.IO) {
            repository.saveProductList(mockProducts)
            Log.d("@dev", repository.getProductList().toString())

            repository.deleteProduct(mockProducts[0])
            Log.d("@dev", repository.getProductList().toString())

            Log.d("@dev", repository.getProductById("1").toString())

        }
    }
}