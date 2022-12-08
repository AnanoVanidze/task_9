package com.example.retrofit.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Resource
import com.example.retrofit.model.Item
import com.example.retrofit.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {


    private val _itemsLivedata = MutableLiveData<Resource<List<Item>>>()
    val itemsLivedata: LiveData<Resource<List<Item>>> get() = _itemsLivedata


    fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
//            Log.d("log", Thread.currentThread().name)

            itemRepository.getItems().collect{
                _itemsLivedata.postValue(it)

            }


//            try {
//                _itemsLivedata.postValue(Resource.Loading())
//                val result = itemRepository.getItems()
//                _itemsLivedata.postValue(Resource.Success(result))
//
//            }catch (e: Exception){
//                _itemsLivedata.postValue(Resource.Error(e.message))
//
//            }


        }


    }
}