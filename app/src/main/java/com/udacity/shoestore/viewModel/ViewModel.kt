package com.udacity.shoestore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.shoestore.models.Shoe
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _navigateUp = MutableSharedFlow<Unit>()

    val shoeList = MutableLiveData<List<Shoe>>()
    var currentShoe = Shoe("","","","")




    private fun saveShoe(){
        val list = shoeList.value?.toMutableList()?:mutableListOf()
        list.add(currentShoe.copy())
        shoeList.value=list
        currentShoe.clear()
    }

    fun onButtonSaveClicked(){
        saveShoe()
        viewModelScope.launch { _navigateUp.emit(Unit) }
    }
}