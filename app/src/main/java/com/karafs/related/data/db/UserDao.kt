package com.karafs.related.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karafs.related.data.User

@Dao
abstract class UserDao {

    @Query("SELECT * FROM user")
    abstract fun getUser(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun upsertUser(users: List<User>)

    @Query("DELETE FROM user")
    abstract suspend fun clearUser()

    @Query("SELECT * FROM user")
    abstract suspend fun getUsers(): List<User>

    @Query("SELECT * FROM user WHERE lastName LIKE '%' || :lName || '%' AND id != :userId")
    abstract suspend fun getRelatedUsersByLastName(userId: Int, lName: String): List<User>

    suspend fun getAllRelatedUsersByLastName(userId: Int, lName: String): List<User> {
        val users = mutableListOf<User>()
        lName.split("-").forEach {
            users.addAll(getRelatedUsersByLastName(userId, it))
        }
        return users
    }

}