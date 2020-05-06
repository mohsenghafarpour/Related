package com.karafs.related.data.repository

import androidx.lifecycle.LiveData
import com.karafs.related.data.User
import com.karafs.related.network.Result

interface UserRepository {

    suspend fun getUserFromNetwork(): Result<List<User>>

    fun getUsers(): LiveData<List<User>>
}