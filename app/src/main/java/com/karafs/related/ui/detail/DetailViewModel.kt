package com.karafs.related.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.karafs.related.base.BaseViewModel
import com.karafs.related.data.repository.UserRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val userRepository: UserRepository) : BaseViewModel() {

    private val _sentence = MutableLiveData<String>()
    val sentence: LiveData<String>
        get() = _sentence

    private fun getUsers()= viewModelScope.launch {
        _sentence.postValue(userRepository.getRelatedUsers())
    }

    init {
        getUsers()
    }
}