package com.example.turkeycities.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkeycities.model.City
import com.example.turkeycities.repository.Repository
import com.example.turkeycities.util.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor
    (private val repository: Repository) : ViewModel() {

    private var _cities = MutableLiveData<NetworkResponse<List<City>>>()
    val cities: LiveData<NetworkResponse<List<City>>> get() = _cities


    init {
        getAllCities()
    }

     fun getAllCities() {
        viewModelScope.launch {
            try {
                _cities.value= NetworkResponse.Loading()
                val response = repository.getAllCities()
                if (response.isSuccessful) {
                    Log.e("data",response.message())
                    withContext(Dispatchers.Main) {}
                    response.body()?.let {
                        _cities.value = NetworkResponse.Success(it.data)
                    }

                }else{
                    _cities.value=NetworkResponse.Error(response.message())
                }

            } catch (e: Exception) {
                if (e.localizedMessage !=null){
                    _cities.value = NetworkResponse.Error(e.localizedMessage)
                }
            }
        }
    }
}