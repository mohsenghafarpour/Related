package com.karafs.related.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

private const val TABLE_NAME = "user"

@Entity(tableName = TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "firstName")
    @SerializedName("firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    val lastName: String
)