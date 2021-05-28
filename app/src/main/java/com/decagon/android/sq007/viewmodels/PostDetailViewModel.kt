package com.decagon.android.sq007.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.android.sq007.model.MainRepository
import com.decagon.android.sq007.model.domain.Comment
import com.decagon.android.sq007.util.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostDetailViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    private var _commentData: MutableLiveData<DataState<List<Comment>>> = MutableLiveData()
    val commentData: LiveData<DataState<List<Comment>>>
        get() = _commentData

    private val _commentPostData: MutableLiveData<DataState<List<Comment>>> = MutableLiveData()
    val commentPostData: LiveData<DataState<List<Comment>>>
        get() = _commentPostData

    fun getComments() {
        viewModelScope.launch {
            mainRepository.getComments().collect {
                _commentData.value = it
            }
        }
    }

    fun getPostComments(postId: Int) {
        viewModelScope.launch {
            mainRepository.getPostComments(postId).collect {
                _commentData.value = it
            }
        }
    }

    fun insertComment(comment: Comment) {
        viewModelScope.launch {
            mainRepository.insertComments(comment)
        }
    }
}