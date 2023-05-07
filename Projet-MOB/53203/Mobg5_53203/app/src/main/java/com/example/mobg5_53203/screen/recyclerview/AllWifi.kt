package com.example.mobg5_53203.screen.recyclerview


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobg5_53203.R
import com.example.mobg5_53203.databinding.FragmentAllWifiBinding
import com.example.mobg5_53203.screen.apiWifi.Field
import com.example.mobg5_53203.screen.googlemap.MapViewModel
import com.example.mobg5_53203.screen.googlemap.MapViewModelFactory
import kotlin.collections.ArrayList


class AllWifi :  Fragment(), RecyclerViewInterface {

    private val wifiList = ArrayList<WifiModel>()
    private lateinit var viewModel: MapViewModel
    private lateinit var mapViewModelFactory : MapViewModelFactory
    private lateinit var listener: RecyclerViewInterface
    private lateinit var detailViewModel : DetailFragmentViewModel
    private lateinit var detailViewModelFactory : DetailFragmentViewModelFactory
    private lateinit var binding: FragmentAllWifiBinding
    private lateinit var adapter : WifiRecyclerViewAdapter
    private  var change : Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listener = this
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_wifi,container,false)


        mapViewModelFactory = MapViewModelFactory()
        viewModel = ViewModelProvider(this, mapViewModelFactory)[MapViewModel::class.java]


        detailViewModelFactory = DetailFragmentViewModelFactory(requireActivity().application)
        detailViewModel = ViewModelProvider(this, detailViewModelFactory)[DetailFragmentViewModel::class.java]

     // adapter a eviter dans un callback
        viewModel.listField.observe(viewLifecycleOwner) { it ->
            it.forEach {
                populate(it)
            }
            binding.recyclerView.layoutManager = LinearLayoutManager(binding.recyclerView.context)
            adapter = WifiRecyclerViewAdapter(wifiList, listener)
            binding.recyclerView.adapter = adapter
        }

        detailViewModel.wifi.observe(viewLifecycleOwner) { wifi ->
            wifi?.let {
                this.findNavController().navigate(
                    AllWifiDirections.actionAllWifiToDetailFragment(wifi)
                )
                detailViewModel.doneNavigate()
            }
        }
        binding.myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                if(::adapter.isInitialized){
                    adapter.filter.filter(s.toString())
                    change = true
                }
            }
        })
        return binding.root
    }

    /**
     * Adds a new WifiModel object to the wifiList.
     *
     * @param field: a Field object that contains the data to be used to create the new WifiModel object.
     */
    @SuppressLint("SuspiciousIndentation")
    private fun populate(field : Field){
        if(!field.nomSiteFr.equals(null))
        wifiList.add(WifiModel(
            R.drawable.ic_baseline_wifi_24,field.nomSiteFr,
            field.emplacement,
            field.statut,
            field.adresse))
    }

    override fun onItemClick(position: Int) {
        val item = wifiList[position]
        if(change){
            val filter = adapter.getMlist()[position]
            detailViewModel.onSetWifiModel(filter)
            change = false
        }else{
            detailViewModel.onSetWifiModel(item)
        }

    }
}