package com.salam94.trinityiv.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.salam94.trinityiv.R
import com.salam94.trinityiv.databinding.FragmentContactDetailBinding
import com.salam94.trinityiv.databinding.FragmentProfileBinding
import com.salam94.trinityiv.util.SharedPreference

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        setupUI()
    }

    private fun setupUI(){
        val firstName = activity?.let { SharedPreference().retrieveValue(it, SharedPreference().FIRST_NAME) }
        val lastName = activity?.let { SharedPreference().retrieveValue(it, SharedPreference().LAST_NAME) }

//        val fullName = "$firstName $lastName"
//        val abbrName = "${firstName?.first()} ${lastName?.first()}"

        binding.textProfileName.text = firstName
        binding.txtAbbrName.text = lastName
        binding.textProfileDob.text =
            activity?.let { SharedPreference().retrieveValue(it, SharedPreference().DOB) }
        binding.textProfileEmail.text =
            activity?.let { SharedPreference().retrieveValue(it, SharedPreference().EMAIL) }
    }

}