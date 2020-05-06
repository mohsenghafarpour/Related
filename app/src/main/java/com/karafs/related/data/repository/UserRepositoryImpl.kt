package com.karafs.related.data.repository

import com.karafs.related.data.User
import com.karafs.related.network.Result
import com.karafs.related.network.api.UserApi
import com.karafs.related.utils.safeApiCall

class UserRepositoryImpl(private val userApi: UserApi) : UserRepository {

    override suspend fun getUserFromNetwork(): Result<List<User>> = safeApiCall {
        val response = userApi.getUser()
        return@safeApiCall Result.Success(response)
    }
}