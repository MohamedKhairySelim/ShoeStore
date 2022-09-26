package com.udacity.shoestore.our_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewModel.ViewModel
import com.udacity.shoestore.databinding.FragmentDetailScreenBinding
import kotlinx.coroutines.launch

class DetailScreen : Fragment() {

    private lateinit var binding : FragmentDetailScreenBinding
    private val view_Model: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_detail_screen, container, false)

        binding.viewModelDataBinding = view_Model
        binding.shoe=view_Model.currentShoe


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailScreenDirections.actionDetailScreenToShoeList())
        }

        super.onViewCreated(view, savedInstanceState)
    }

}