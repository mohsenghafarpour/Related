package com.karafs.related.network.api

import com.karafs.related.data.User
import retrofit2.http.GET

interface UserApi {

    @GET("android-test")
    suspend fun getUser(): List<User>

}