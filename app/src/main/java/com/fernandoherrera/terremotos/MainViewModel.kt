package com.fernandoherrera.terremotos

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*

class MainViewModel(application: Application) :AndroidViewModel(application) {
    //se crea la coroutine  vieja opcion
//    private val  job = Job()
//    private val coroutinaScope = CoroutineScope(Dispatchers.Main + job)
    private val database = getDatabase(application)
    private var _eqList = MutableLiveData<MutableList<Terremoto>>()
    val eqList: LiveData<MutableList<Terremoto>>
        get()= _eqList
    private val repository = MainRepository(database)

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