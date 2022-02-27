package com.danielwaiguru.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielwaiguru.presentation.utils.SingleLiveEvent

class DashBoardViewModel: ViewModel() {
    private val _onAddInventoryClicked: MutableLiveData<Unit> = SingleLiveEvent()
    val onAddInventoryClicked: LiveData<Unit> get() = _onAddInventoryClicked

    fun onAddClicked() {
        _onAddInventoryClicked.postValue(Unit)
    }
}