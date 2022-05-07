package com.example.xoii.viewModels

import androidx.lifecycle.ViewModel
import com.example.xoii.models.DummyModels

class MainViewModel () : ViewModel(){

    private val dummyRepository = DummyModels()

    fun getTabs(): List<Any> {
        return dummyRepository.getTabs()
    }

}