package com.danielwaiguru.data.mappers

import com.danielwaiguru.data.models.ProductEntity
import com.danielwaiguru.domain.models.Product
import com.danielwaiguru.domain.models.ProductUiModel

fun Product.toEntity(): ProductEntity = ProductEntity(
    name = name,
    code = code,
    category = category,
    type = type,
    unit = unit,
    manufacturer = manufacturer,
    distributor = distributor,
    vat = vat,
    unitCost = unitCost,
    retailPrice = retailPrice,
    agentPrice = agentPrice,
    wholesalePrice = wholesalePrice,
    image = image
)

fun ProductEntity.toUiModel(): ProductUiModel = ProductUiModel(
    name, code, category, type, unit, manufacturer, distributor, image
)