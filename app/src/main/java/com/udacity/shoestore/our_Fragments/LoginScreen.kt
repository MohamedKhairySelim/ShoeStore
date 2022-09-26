package com.udacity.shoestore.our_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_login__screen,container,false)


        binding.createNewLoginAccount.setOnClickListener {
                findNavController()
                    .navigate(LoginScreenDirections.actionLoginScreenToWelcomeScreen())
        }

        binding.login.setOnClickListener {
            findNavController()
                .navigate(LoginScreenDirections.actionLoginScreenToWelcomeScreen())
        }

        return binding.root
    }



}

