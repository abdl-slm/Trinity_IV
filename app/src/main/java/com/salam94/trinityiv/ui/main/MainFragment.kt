package com.salam94.trinityiv.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.salam94.trinityiv.databinding.FragmentMainBinding
import com.salam94.trinityiv.model.Contact
import com.salam94.trinityiv.ui.main.contact.ContactAdapter
import com.salam94.trinityiv.ui.main.contact.ContactNavigator

class MainFragment : Fragment(), ContactNavigator {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private var contactList = mutableListOf<Contact>()
    private var currentContactList = mutableListOf<Contact>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupUI()

        binding.btnSearch.setOnClickListener {
            searchContact(binding.edtSearch.text.toString())
        }
    }


    private fun searchContact(searchTerm: String){

        if(searchTerm.isEmpty()){
            binding.recyclerContact.adapter = context?.let { viewModel.getContactList(it) }
                ?.let { ContactAdapter(it, this) }
            return
        }

        currentContactList.clear()

        for(contact in contactList){
            if((contact.lastName !== null && contact.lastName.contains(searchTerm)) || (contact.email !== null && contact.email.contains(searchTerm)) || (contact.firstName !== null && contact.firstName.contains(searchTerm)) ){
                currentContactList.add(contact)
            }
        }

        binding.recyclerContact.adapter = context?.let { ContactAdapter(currentContactList, this) }
    }

    private fun setupUI(){

        if(context?.let { viewModel.getContactList(it).toMutableList() } !== null){
            contactList = context?.let {viewModel.getContactList(it).toMutableList()}!!
        }

        binding.recyclerContact.adapter = context?.let { viewModel.getContactList(it) }
            ?.let { ContactAdapter(it, this) }
    }

    override fun onContactClicked(contact: Contact) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToContactDetailFragment(contact))
    }

}