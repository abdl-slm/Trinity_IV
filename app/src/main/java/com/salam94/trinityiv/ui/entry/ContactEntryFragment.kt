package com.salam94.trinityiv.ui.entry

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salam94.trinityiv.R
import com.salam94.trinityiv.databinding.FragmentContactEntryBinding
import com.salam94.trinityiv.databinding.FragmentMainBinding

class ContactEntryFragment : Fragment() {

    companion object {
        fun newInstance() = ContactEntryFragment()
    }

    private lateinit var viewModel: ContactEntryViewModel
    private lateinit var binding: FragmentContactEntryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactEntryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ContactEntryViewModel::class.java]

    }

}