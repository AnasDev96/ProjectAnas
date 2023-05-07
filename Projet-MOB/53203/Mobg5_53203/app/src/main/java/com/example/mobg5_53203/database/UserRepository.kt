package com.example.mobg5_53203.database

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDatabaseDao) {

    /**
     * Adds a user to the table in the database
     *
     * @param user The user to be added
     */
    fun addUser(user: User){
        userDao.insert(user)
    }

    /**
     * Updates a user in the  database table
     *
     * @param user The updated user
     */
    fun updateUser(user: User){
        userDao.update(user)
    }

    /**
     * Retrieves a user from the repository by their email
     *
     * @param email The email of the user to retrieve
     * @return The user with the specified email
     */
    fun get(email: String): User {
        return userDao.get(email)
    }
    /**
     * Retrieves a list of all emails in the table in the database
     *
     * @return A LiveData list of all emails in the repository
     */
    fun getAllEmail() : LiveData<List<String>>{
        return userDao.getAllEmail()
    }

}