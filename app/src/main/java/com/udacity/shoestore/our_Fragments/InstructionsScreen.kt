package com.udacity.shoestore.our_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsScreenBinding

class InstructionsScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentInstructionsScreenBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_instructions_screen, container, false)
        // Inflate the layout for this fragment

        binding.skipButton.setOnClickListener { view:View->
            Navigation.findNavController(view).navigate(R.id.action_instructionsScreen_to_shoeList)
        }

        return binding.root
    }


}