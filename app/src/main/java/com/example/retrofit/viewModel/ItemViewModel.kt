package com.example.retrofit.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.ApiState
import com.example.retrofit.Resource
import com.example.retrofit.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(private val itemRepository: ItemRepository): ViewModel() {


    private val _itemsLivedata = MutableLiveData<ApiState>()
    val  itemsLivedata: LiveData<ApiState> get() = _itemsLivedata


    fun getData(){

        viewModelScope.launch(Dispatchers.IO) {
         Log.d("log", Thread.currentThread().name)

            _itemsLivedata.postValue(ApiState.Loading)
            when(val response = itemRepository.getItems()){
                is Resource.Success->{
                   _itemsLivedata.postValue(ApiState.Success(response.data))
                }
                is Resource.Error->{
                    _itemsLivedata.postValue(ApiState.Failure(response.message!!))
                }
            }
        }


    }
}