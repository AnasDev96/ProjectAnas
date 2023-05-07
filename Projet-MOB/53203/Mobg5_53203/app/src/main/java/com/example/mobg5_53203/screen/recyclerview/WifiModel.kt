package com.example.mobg5_53203.screen.recyclerview


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WifiModel(val image : Int , var nomWifi: String?, var description : String?, var nomLieu : String?,var adresse : String?) : Parcelable


