package com.danielwaiguru.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danielwaiguru.data.models.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    /**
     * Insert product in db
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity): Long

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE category = :category")
    fun getProductsByCategory(category: String): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE name LIKE '%' || :searchQuery || '%' " +
            "OR manufacturer LIKE '%' || :searchQuery || '%'")
    fun searchProduct(searchQuery: String): Flow<List<ProductEntity>>
}