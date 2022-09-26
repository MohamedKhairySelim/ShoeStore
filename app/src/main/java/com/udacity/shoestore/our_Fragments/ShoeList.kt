package com.udacity.shoestore.our_Fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewModel.ViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeList : Fragment(), MenuProvider {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding =DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)


//        viewModel=ViewModelProvider(this).get(ViewModel::class.java)

        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListToDetailScreen())
        }
        observeView()
        setUpMenu()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpMenu() {
        requireActivity().addMenuProvider(
            this,
            viewLifecycleOwner,
            Lifecycle.State.RESUMED
        )
    }

    private fun observeView() {
        viewModel.shoeList.observe(viewLifecycleOwner){it?.let { updateShoesList(it) }}
    }

    private fun updateShoesList(shoesList: List<Shoe>) {
        binding.shoeListLinear.removeAllViews()
        shoesList.forEach{ shoe ->
            val v =LayoutInflater.from(context).inflate(R.layout.shoe_list_design,binding.shoeListLinear,false)
            v.findViewById<TextView>(R.id.name_TV).text= shoe.name
            v.findViewById<TextView>(R.id.company_TV).text= shoe.company
            v.findViewById<TextView>(R.id.size_TV).text= shoe.size
            v.findViewById<TextView>(R.id.description_TV).text= shoe.description

            binding.shoeListLinear.addView(v)
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.logout,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.log_Out -> {
                findNavController().navigate(ShoeListDirections.actionShoeListPopIncludingLoginScreen())
                true
            }
            else -> {false}
        }
    }


}