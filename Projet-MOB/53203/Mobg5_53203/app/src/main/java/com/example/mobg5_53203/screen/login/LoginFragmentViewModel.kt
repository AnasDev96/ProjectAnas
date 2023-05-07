package com.example.mobg5_53203.screen.login

import android.app.Application
import androidx.lifecycle.*
import com.example.mobg5_53203.database.User
import com.example.mobg5_53203.database.UserDatabase
import com.example.mobg5_53203.database.UserRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class LoginFragmentViewModel(application: Application) : AndroidViewModel(application){

    private val userDao = UserDatabase.getInstance(application).userDatabaseDao
    private var repo : UserRepository =  UserRepository(userDao)

    /**
     * LiveData indicating whether the email is valid.
     */
    private val _isConnected = MutableLiveData<Boolean>()
    val isConnected: LiveData<Boolean>
        get() = _isConnected


    var allData: LiveData<List<String>>

    init {
        val userDao = UserDatabase.getInstance(application).userDatabaseDao
        repo = UserRepository(userDao)
        allData = repo.getAllEmail()
    }

    /**
     * Adds or updates the user with the given email in the database.
     */
    private fun addOrUpdateUser(email : String,date:String) {
            try {
                repo.get(email).email
            }catch (e: Exception){
                repo.addUser(User(email= email, createdAt= date))
            }
                repo.updateUser(User(email= email, createdAt= date))
    }

    /**
     * Verifies if the given email is valid and updates the _isConnected LiveData accordingly.
     */
    fun verifyEmail(email : String) {
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if(email.isEmpty()){
            _isConnected.value = false
        }else {
            if (email.trim().matches(pattern.toRegex())) {
                val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                val datetime: LocalDateTime = LocalDateTime.now()
                val output: String = formatter.format(datetime)
                addOrUpdateUser(email,output)
                _isConnected.value = true
            } else {
                _isConnected.value = false
            }
        }
    }
}