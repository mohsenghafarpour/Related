package com.karafs.related.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karafs.related.data.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsertUser(users: List<User>)

    @Query("DELETE FROM user")
    suspend fun clearUser()

}