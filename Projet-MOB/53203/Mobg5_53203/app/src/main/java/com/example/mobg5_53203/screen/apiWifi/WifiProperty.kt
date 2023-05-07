@file:Suppress("ArrayInDataClass", "ArrayInDataClass", "ArrayInDataClass", "ArrayInDataClass", "unused")
package com.example.mobg5_53203.screen.apiWifi

import com.squareup.moshi.Json

/**
 * Data class representing the main property of a WiFi connection.
 */
data class WifiProperty(
    val nhits : Int,
    val parameters: Param,
    val records : Array<Records>
)

/**
 * Data class representing the parameters of a WiFi connection.
 */
data class Param(
    val dataset : String,
    val timezone : String,
    val rows : Int,
    val start : Int,
    val format : String
)

/**
 * Data class representing the records of a WiFi connection.
 */
data class Records(
    val datasetid : String,
    val recordid : String,
    val fields : Field,
    @Json(name = "record_timestamp") val recordTimestamp: String
)

/**
 * Data class representing the fields of a WiFi connection.
 */
data class Field(
    val statut : String,
    val emplacement : String,
    val wifigps : DoubleArray,
    @Json(name = "nom_site_fr") val nomSiteFr : String?,
    val latitude : String ,
    val longitude : String,
    @Json(name = "lieu_installation") val adresse : String?
)


/**
 * Data class representing the geometry of a WiFi connection.
 */
data class Geometry(
    val type : String,
    val coordinates : DoubleArray
)
