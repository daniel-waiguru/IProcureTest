package com.danielwaiguru.presentation.add_products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielwaiguru.domain.models.Product
import com.danielwaiguru.domain.repositories.ProductRepository
import com.danielwaiguru.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class AddProductViewModel(private val productRepository: ProductRepository): ViewModel() {
    private val _onCloseEvent: MutableLiveData<Unit> = SingleLiveEvent()
    val onCloseEvent: LiveData<Unit> get() = _onCloseEvent

    private val _onSaveEvent: MutableLiveData<Unit> = SingleLiveEvent()
    val onSaveEvent: LiveData<Unit> get() = _onSaveEvent

    private val _onPickImageEvent: MutableLiveData<Unit> = SingleLiveEvent()
    val onPickImageEvent: LiveData<Unit> get() = _onPickImageEvent

    fun onPickImageClicked() {
        _onPickImageEvent.postValue(Unit)
    }
    fun onCancelClicked() {
        _onCloseEvent.postValue(Unit)
    }
    fun onSaveClicked() {
        _onSaveEvent.postValue(Unit)
    }
    fun addProduct(product: Product) {
        viewModelScope.launch {
            productRepository.addProduct(product)
        }
    }
}