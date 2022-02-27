package com.danielwaiguru.domain.models

import java.net.URI

data class Product(
    val name: String,
    val code: String,
    val category: String,
    val type: String,
    val unit: String,
    val manufacturer: String,
    val distributor: String,
    val vat: Boolean,
    val unitCost: String,
    val retailPrice: String,
    val agentPrice: String,
    val wholesalePrice: String,
    val image: String
)