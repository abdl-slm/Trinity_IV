package com.salam94.trinityiv.ui.detail

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.salam94.trinityiv.R
import com.salam94.trinityiv.databinding.FragmentContactDetailBinding
import com.salam94.trinityiv.databinding.FragmentMainBinding
import com.salam94.trinityiv.model.Contact

class ContactDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ContactDetailFragment()
    }

    private lateinit var viewModel: ContactDetailViewModel
    private lateinit var binding: FragmentContactDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ContactDetailViewModel::class.java]

        val args: ContactDetailFragmentArgs by navArgs()


        setupUI(args.contact)
    }

    @SuppressLint("SetTextI18n")
    private fun setupUI(contact: Contact){
        binding.edtFirstName.setText(contact.firstName)
        binding.edtLastName.setText(contact.lastName)
        binding.edtEmail.setText(contact.email)
        binding.edtPhoneNumber.setText(contact.dob)

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}