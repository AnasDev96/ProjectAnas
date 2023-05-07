package com.example.mobg5_53203.screen.login


import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobg5_53203.R
import com.example.mobg5_53203.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginFragmentViewModelFactory : LoginFragmentViewModelFactory
    private lateinit var viewModel: LoginFragmentViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        loginFragmentViewModelFactory = LoginFragmentViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, loginFragmentViewModelFactory)[LoginFragmentViewModel::class.java]

        viewModel.allData.observe(viewLifecycleOwner) { returnedrepo ->
            val adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                returnedrepo
            )
            binding.emailTxt.setAdapter(adapter)
        }

        binding.loginBtn.setOnClickListener{
            binding.emailTxt.onEditorAction(EditorInfo.IME_ACTION_DONE)
            viewModel.verifyEmail(binding.emailTxt.text.toString())
        }

        viewModel.isConnected.observe(viewLifecycleOwner) { connexionGood ->
            if (connexionGood) {
                Toast.makeText(
                    requireActivity().applicationContext,
                    "Your email is valid",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireActivity().applicationContext,
                    "Your email is invalid!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return binding.root
    }

}