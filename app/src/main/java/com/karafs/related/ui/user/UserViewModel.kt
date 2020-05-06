package com.karafs.related.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.karafs.related.base.BaseViewModel
import com.karafs.related.data.User
import com.karafs.related.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : BaseViewModel() {

    val user: LiveData<List<User>> = userRepository.getUsers()

    private fun getUserFromNetwork() = viewModelScope.launch {
        userRepository.getUserFromNetwork()
    }

    init {
        getUserFromNetwork()
    }

    fun goToDetails() {
        navigateTo(UserFragmentDirections.actionUserToDetail())
    }
}