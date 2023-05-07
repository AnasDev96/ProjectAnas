package com.example.mobg5_53203.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavorisDatabaseDao {

    @Insert
    fun insert(nouveauFavoris: Favoris)

    @Update
    fun update(upFavoris: Favoris)

    @Query("DELETE FROM Favoris")
    fun clear()

    @Query("SELECT * from Favoris WHERE nom = :nom")
    fun get(nom: String?): Favoris

    @Query("SELECT nom from Favoris")
    fun getAllFavoris(): LiveData<List<String>>

    @Query("SELECT * from Favoris")
    fun getAll(): List<Favoris>

    @Query("DELETE FROM Favoris WHERE nom = :nom ")
    fun deleteByName(nom : String?)
}