package com.udacity.shoestore.our_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding


class WelcomeScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentWelcomeScreenBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome__screen,container, false)

        binding.skipButton.setOnClickListener {
            findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructionsScreen())
        }
        return binding.root
    }

}

