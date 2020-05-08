package com.karafs.related.data.repository

import androidx.lifecycle.LiveData
import com.karafs.related.data.User
import com.karafs.related.data.db.UserDao
import com.karafs.related.network.Result
import com.karafs.related.network.api.UserApi
import com.karafs.related.utils.safeApiCall

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getUserFromNetwork(): Result<List<User>> = safeApiCall {
        val response = userApi.getUser()
        userDao.clearUser()
        userDao.upsertUser(response)
        return@safeApiCall Result.Success(response)
    }

    override fun getUsers(): LiveData<List<User>> = userDao.getUser()

    override suspend fun getRelatedUsers(): String {
        val sb = StringBuilder()
        userDao.getUsers().forEach { user ->

            val relatedUsers = userDao.getAllRelatedUsersByLastName(user.id, user.lastName)
            if (relatedUsers.isEmpty())
                sb.append("${user.firstName} is Related to no one ")
            else {
                sb.append("${user.firstName} is Related to ")
                relatedUsers.forEach { relatedUser ->
                    sb.append("${relatedUser.firstName}-")
                }
                sb.setLength(sb.length - 1)
            }

            sb.append("\n")
        }
        return sb.toString()
    }
}