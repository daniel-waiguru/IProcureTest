package com.danielwaiguru.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danielwaiguru.domain.models.ProductUiModel
import com.danielwaiguru.presentation.databinding.ProductItemBinding
import com.danielwaiguru.presentation.utils.ImageUtils

class ProductsAdapter: ListAdapter<ProductUiModel, ProductsAdapter.ProductsViewHolder>(COMPARATOR) {
    private object COMPARATOR: DiffUtil.ItemCallback<ProductUiModel>() {
        override fun areItemsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ProductUiModel,
            newItem: ProductUiModel
        ): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bindProduct(getItem(position))
    }

    class ProductsViewHolder(
        private val binding: ProductItemBinding
        ): RecyclerView.ViewHolder(binding.root) {
            fun bindProduct(product: ProductUiModel) {
                with(binding) {
                    name.text = product.name
                    manufacturer.text = product.manufacturer
                    unitCost.text = product.code
                    distributor.text = product.distributor
                    val bitmap = ImageUtils.stringToBitmap(product.image)
                    if (bitmap != null) {
                        productImage.setImageBitmap(bitmap)
                    }
                }
            }
    }
}