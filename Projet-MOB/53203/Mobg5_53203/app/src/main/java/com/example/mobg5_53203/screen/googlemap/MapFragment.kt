package com.example.mobg5_53203.screen.googlemap

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager


import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mobg5_53203.R
import com.example.mobg5_53203.databinding.FragmentMapBinding
import com.example.mobg5_53203.screen.apiWifi.Field
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(){

    private lateinit var mapView : MapView
    private lateinit var map : GoogleMap
    private lateinit var binding: FragmentMapBinding
    private var school = LatLng(50.849602, 4.363952)
    private lateinit var locationManager: LocationManager
    private lateinit var viewModel: MapViewModel
    private lateinit var mapViewModelFactory : MapViewModelFactory
    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var position: Location


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_map,
            container,
            false
        )

        mapViewModelFactory = MapViewModelFactory()
        viewModel = ViewModelProvider(this, mapViewModelFactory)[MapViewModel::class.java]
        locationManager = this.requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        mapView =  binding.mapView
        mapView.getMapAsync {
            map=it
        }
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = binding.mapView
        mapFragment.getMapAsync(callback)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }

    /**
     * Checks if the user has granted location permission.
     */
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this.requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Enables the My Location layer if the user has granted location permission.
     */
    @SuppressLint("MissingPermission")
    private fun enableMyLocation() : Boolean  {
        if (isPermissionGranted()) {
            map.isMyLocationEnabled = true
            initCurrentLocation()
        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION)
        }
        return isPermissionGranted()
    }

    /**
     * Initializes the current location of the user.
     */
    @SuppressLint("MissingPermission")
    fun initCurrentLocation(){

        position = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!
        school = LatLng(position.latitude, position.longitude)
        map.moveCamera(CameraUpdateFactory.newLatLng(school))
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f,
            object : LocationListener {
                override fun onLocationChanged(location: Location) {}
                @Deprecated("Deprecated in Java")
                override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {}
                override fun onProviderEnabled(s: String) {}
                override fun onProviderDisabled(s: String) {}
            })
    }

    /**
     * Callback when the map is ready to be used.
     * Adds markers for each WiFi connection and sets the minimum zoom preference.
     * Observes the list of WiFi connections and adds markers for each one.
     */
    @SuppressLint("MissingPermission")
    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        if(!enableMyLocation()){
           map.addMarker(MarkerOptions().position(school).title("Bruxelles"))
           map.moveCamera(CameraUpdateFactory.newLatLng(school))
       }
        map.setMinZoomPreference(15.0f)
        viewModel.listField.observe(viewLifecycleOwner) { it ->
            it.forEach {
                marker(it)
            }
        }
    }

    /**
     * Adds a marker to the map for the given field.
     * The marker will use a custom layout for its info window, which will be converted to a bitmap for display.
     *
     * @param field The field for which to add a marker.
     */
    @SuppressLint("InflateParams")
    private fun marker(field: Field){
        val markerView = (this.requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.fragment_marker ,null)
        val cardView= markerView.findViewById<CardView>(R. id.markerCardviev)
        val bitmap1= Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height,  false)
        val smallMarkerIcon1= BitmapDescriptorFactory.fromBitmap(bitmap1)
        map.addMarker(MarkerOptions().position(LatLng(field.wifigps[0], field.wifigps[1])).title(field.nomSiteFr).icon(smallMarkerIcon1))
    }

    /**
     * Converts the given view to a bitmap image.
     *
     * @param view The view to convert to a bitmap.
     * @return The bitmap image of the view.
     */
    private fun viewToBitmap(view: View): Bitmap? {
        view.measure (View.MeasureSpec .UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout( 0 , 0 , view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }

}
