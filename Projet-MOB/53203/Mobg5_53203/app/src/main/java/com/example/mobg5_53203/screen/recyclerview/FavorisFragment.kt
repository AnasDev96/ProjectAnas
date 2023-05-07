package com.example.mobg5_53203.screen.recyclerview



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobg5_53203.R
import com.example.mobg5_53203.databinding.FragmentAllFavBinding



@Suppress("DEPRECATION")
class FavorisFragment : Fragment(), RecyclerViewInterface{

    private lateinit var detailViewModel : DetailFragmentViewModel
    private lateinit var detailViewModelFactory : DetailFragmentViewModelFactory
    private lateinit var binding: FragmentAllFavBinding
    private lateinit var listener: RecyclerViewInterface



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listener = this
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_fav,container,false)

        detailViewModelFactory = DetailFragmentViewModelFactory(requireActivity().application)
        detailViewModel = ViewModelProvider(this, detailViewModelFactory)[DetailFragmentViewModel::class.java]
        binding.favorisRecyclerView.layoutManager = LinearLayoutManager(binding.favorisRecyclerView.context)
        if(detailViewModel.allFav().isNotEmpty()){
            val adapter = FavorisRecyclerViewAdapter(detailViewModel.allFav(),listener)
            binding.favorisRecyclerView.adapter = adapter
        }else{
            binding.txtInvisible.visibility = View.VISIBLE
        }
        return binding.root
    }

    override fun onItemClick(position: Int) {
            detailViewModel.deleteByName(detailViewModel.allFav()[position].nom)
            fragmentManager?.beginTransaction()?.detach(this)?.commitNow()
            fragmentManager?.beginTransaction()?.attach(this)?.commitNow()
    }

}