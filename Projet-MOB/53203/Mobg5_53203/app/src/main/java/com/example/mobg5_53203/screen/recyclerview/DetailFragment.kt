package com.example.mobg5_53203.screen.recyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobg5_53203.R
import com.example.mobg5_53203.databinding.FragmentDetailleBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailleBinding
    private lateinit var detailViewModel : DetailFragmentViewModel
    private lateinit var detailViewModelFactory : DetailFragmentViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detaille, container, false)
        detailViewModelFactory = DetailFragmentViewModelFactory(requireActivity().application)
        detailViewModel = ViewModelProvider(this, detailViewModelFactory)[DetailFragmentViewModel::class.java]


        val bundle = arguments
        if (bundle == null) {
            Log.e("Detail", "No information")
        }
        if(bundle != null){
            val arguments = DetailFragmentArgs.fromBundle(bundle)
            binding.detailFragment = arguments.wifi
            binding.lifecycleOwner = this
            binding.button.setOnClickListener{
                arguments.wifi!!.nomWifi?.let { it1 -> detailViewModel.addFavoris(it1)
                    Toast.makeText(requireActivity().applicationContext,
                        "Wi-Fi is added to your favorites!",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }




}