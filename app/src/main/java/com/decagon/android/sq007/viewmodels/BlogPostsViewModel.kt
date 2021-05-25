package com.decagon.android.sq007.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.android.sq007.model.MainRepository
import com.decagon.android.sq007.model.Post
import com.decagon.android.sq007.util.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BlogPostsViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Post>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Post>>>
        get() = _dataState

    init {
        fetchPosts()
    }


    fun fetchPosts() {
        viewModelScope.launch {
            mainRepository.getPosts().collect {
                _dataState.value = it
            }
        }
    }
}