package com.fernandoherrera.terremotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel:ViewModel() {
    //se crea la coroutine  vieja opcion
//    private val  job = Job()
//    private val coroutinaScope = CoroutineScope(Dispatchers.Main + job)

    private var _eqList = MutableLiveData<MutableList<Terremoto>>()
    val eqList: LiveData<MutableList<Terremoto>>
        get()= _eqList
    private val repository = MainRepository()

    init {
        viewModelScope.launch {

            _eqList.value = repository.fetchTerremotos()
        }

    }



//        override fun onCleared () {
//            super.onCleared()
//            job.cancel()
//        }

}