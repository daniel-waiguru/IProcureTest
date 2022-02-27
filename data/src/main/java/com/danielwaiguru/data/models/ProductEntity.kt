package com.danielwaiguru.data.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "entities")
data class ProductEntity(
    val name: String,
    val code: String,
    val category: String,
    val type: String,
    val unit: String,
    val manufacturer: String,
    val distributor: String,
    val vat: Boolean,
    @ColumnInfo(name = "unit_cost")
    val unitCost: String,
    @ColumnInfo(name = "retail_price")
    val retailPrice: String,
    @ColumnInfo(name = "agent_price")
    val agentPrice: String,
    @ColumnInfo(name = "wholesale_price")
    val wholesalePrice: String,
    val image: Bitmap
)
