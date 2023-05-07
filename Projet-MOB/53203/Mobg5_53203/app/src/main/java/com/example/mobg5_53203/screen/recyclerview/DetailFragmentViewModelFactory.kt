package com.example.mobg5_53203.screen.recyclerview


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DetailFragmentViewModelFactory (private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DetailFragmentViewModel::class.java)) {
            return DetailFragmentViewModel(application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}