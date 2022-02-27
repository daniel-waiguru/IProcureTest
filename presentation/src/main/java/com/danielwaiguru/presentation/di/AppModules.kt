package com.danielwaiguru.presentation.di

import com.danielwaiguru.data.di.dataModules
import com.danielwaiguru.presentation.add_items.AddProductViewModel
import com.danielwaiguru.presentation.dashboard.DashBoardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModels = module {
    viewModel { DashBoardViewModel() }
    viewModel { AddProductViewModel(get()) }
}
val appModules = listOf(viewModelModels) + dataModules