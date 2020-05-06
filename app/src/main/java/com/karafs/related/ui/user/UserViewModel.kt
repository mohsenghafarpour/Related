package com.karafs.related.ui.user

import androidx.lifecycle.viewModelScope
import com.karafs.related.base.BaseViewModel
import com.karafs.related.data.repository.UserRepository
import com.karafs.related.network.Result
import com.karafs.related.utils.ktx.logD
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : BaseViewModel() {

    private fun getUserFromNetwork() = viewModelScope.launch {
        when (val result = userRepository.getUserFromNetwork()) {
            is Result.Success -> logD("xxx ${result.data}")
            is Result.Error -> logD("xxx this part have a problem")
        }
    }

    init {
        getUserFromNetwork()
    }
}