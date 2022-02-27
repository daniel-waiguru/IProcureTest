package com.danielwaiguru.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danielwaiguru.data.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = true)
abstract class IProcureDatabase: RoomDatabase() {
    abstract fun getProductDao(): ProductDao
}
