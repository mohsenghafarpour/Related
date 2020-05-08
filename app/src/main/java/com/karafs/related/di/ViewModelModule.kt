package com.karafs.related.di

import com.karafs.related.ui.category.CategoryViewModel
import com.karafs.related.ui.detail.DetailViewModel
import com.karafs.related.ui.main.MainViewModel
import com.karafs.related.ui.ruler.RulerViewModel
import com.karafs.related.ui.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { UserViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { CategoryViewModel() }
    viewModel { RulerViewModel() }
}