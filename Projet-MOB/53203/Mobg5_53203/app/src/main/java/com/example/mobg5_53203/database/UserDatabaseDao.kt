package com.example.mobg5_53203.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDatabaseDao {

    @Insert
    fun insert(nouveau: User)

    @Update
    fun update(upUser: User)

    @Query("DELETE FROM User")
    fun clear()

    @Query("SELECT * from User WHERE email = :email")
    fun get(email: String): User

    @Query("SELECT email from User")
    fun getAllEmail(): LiveData<List<String>>

}