package com.example.mobg5_53203.screen.googlemap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobg5_53203.screen.apiWifi.Field
import com.example.mobg5_53203.screen.apiWifi.WifiApi
import kotlinx.coroutines.launch

class MapViewModel : ViewModel() {

    private val _listField = MutableLiveData<List<Field>>()

    /**
     * LiveData containing the list of WiFi connections.
     */
    val listField: LiveData<List<Field>>
        get() = _listField

    init {
        fetchWiFiConnections()
    }

    /**
     * Fills the _listField LiveData with all of the Field objects containing coordinates.
     */
    private fun fetchWiFiConnections() {

        viewModelScope.launch {
            try {
                val result = WifiApi.retrofitService.getProperties()
                val fieldList = ArrayList<Field>()
                result.records.forEach {
                    fieldList.add(it.fields)
                }
                _listField.value = fieldList
            } catch (e: Exception) {
                println(e.toString())
            }
        }
    }
}