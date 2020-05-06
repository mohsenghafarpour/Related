package com.karafs.related.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karafs.related.data.User

@Database(
    entities = [User::class],
    version = 1, exportSchema = false
)

abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}