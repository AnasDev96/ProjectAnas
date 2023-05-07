package com.example.mobg5_53203.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favoris")
data class Favoris(

    @PrimaryKey
    @ColumnInfo(name = "nom")
    val nom: String,

    @ColumnInfo(name = "created_at")
    var createdAt: String?
)