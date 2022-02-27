package com.danielwaiguru.domain.models

data class ProductUiModel(
    val id: Int,
    val name: String,
    val code: String,
    val category: String,
    val type: String,
    val unit: String,
    val manufacturer: String,
    val distributor: String,
    val image: String
)
