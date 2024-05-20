package com.salam94.trinityiv.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.salam94.trinityiv.MainActivity
import com.salam94.trinityiv.databinding.ActivityLoginBinding
import com.salam94.trinityiv.util.SharedPreference


class LoginActivity : AppCompatActivity(), LoginNavigator {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        viewModel.setNavigator(this)

        //Init UI functions
        if(SharedPreference().retrieveValue(this@LoginActivity, SharedPreference().ID) !== "" ) {
            navigateWhenSuccess()
        } else {
            loginButtonClicked()
        }
    }


    private fun loginButtonClicked(){
        binding.btnLogin.setOnClickListener {
            viewModel.handleLogin(this@LoginActivity, applicationContext, binding.edtUserName.text.toString())
        }
    }

    override fun navigateWhenSuccess() {
        val intentHandler = Intent(this@LoginActivity, MainActivity::class.java)
        this@LoginActivity.startActivity(intentHandler)

        //We don't need login page i assume, else, would be weird to back
        finish()
    }

    override fun navigateWhenFail() {
        Toast.makeText(applicationContext, "Invalid full name", Toast.LENGTH_LONG).show()
    }

}