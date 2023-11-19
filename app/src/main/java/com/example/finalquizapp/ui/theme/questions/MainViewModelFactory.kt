package com.example.finalquizapp.ui.theme.questions

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder


inline fun MainViewModelFactory(
    builder: InitializerViewModelFactoryBuilder.() -> Unit
): ViewModelProvider.Factory = InitializerViewModelFactoryBuilder().apply(builder).build()
