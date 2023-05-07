package com.example.mobg5_53203.screen.recyclerview

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mobg5_53203.database.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DetailFragmentViewModel(application: Application) : ViewModel() {

    private val favorisDao = UserDatabase.getInstance(application).favorisDatabaseDao
    private var repo : FavorisRepository =  FavorisRepository(favorisDao)

    private val _wifi = MutableLiveData<WifiModel?>()
    val wifi: LiveData<WifiModel?>
        get() = _wifi

    init {
        val favDao = UserDatabase.getInstance(application).favorisDatabaseDao
        repo = FavorisRepository(favDao)
    }
    /**
     * Sets the value of the wifi property to the given WifiModel.
     *
     * @param wifiModel The WifiModel to set as the value of the wifi property.
     */
    fun onSetWifiModel(wifiModel : WifiModel) {
        _wifi.value = wifiModel
    }

    /**
     * Sets the value of the wifi property to null.
     */
    fun doneNavigate() {
        _wifi.value = null
    }

    /**
     * Adds or updates a favorite in the database using the current date and time.
     * If no favorite with the given name is found in the database, a new favorite is added.
     *
     * @param nom The name of the favorite to add or update.
     */
    fun addFavoris(nom : String) {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val datetime: LocalDateTime = LocalDateTime.now()
        val output: String = formatter.format(datetime)
        try {
            repo.get(nom).nom
        }catch (e: Exception){
            repo.addFavoris(Favoris(nom,output))
        }
        repo.updateFavoris(Favoris(nom, output))
    }

    /**
     * Retrieves a list of all favorites from the database.
     *
     * @return A list of all favorites in the database.
     */
    fun allFav() : List<Favoris>{
        return repo.getAll()
    }

    /**
     * Deletes the favorite with the given name from the database.
     *
     * @param nom The name of the favorite to delete.
     */
    fun deleteByName(nom : String?){
        repo.deleteByName(nom)
    }
}