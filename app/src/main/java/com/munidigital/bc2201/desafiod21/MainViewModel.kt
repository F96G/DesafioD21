package com.munidigital.bc2201.desafiod21

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    private var _cargado = MutableLiveData<Boolean>()
    val cargado:LiveData<Boolean> get() = _cargado

    init {
        _cargado.value = false
    }

    fun yaCargado(){
        _cargado.value = true
    }
}