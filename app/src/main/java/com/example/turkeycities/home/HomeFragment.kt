package com.example.turkeycities.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkeycities.R
import com.example.turkeycities.adapter.CityAdapter
import com.example.turkeycities.databinding.FragmentHomeBinding
import com.example.turkeycities.util.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

 private var _binding : FragmentHomeBinding?=null
 private val binding get() = _binding!!
 private val cityAdapter=CityAdapter()
 private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun observeData(){
      viewModel.cities.observe(viewLifecycleOwner){
          when(it){
              is NetworkResponse.Loading -> {

              }
              is NetworkResponse.Success -> {
                  cityAdapter.updateList(it.data!!)
              }
              is NetworkResponse.Error -> {
                  Toast.makeText(context, "Data Failed", Toast.LENGTH_LONG).show()
              }
          }
      }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observeData()
    }

    private fun setAdapter(){
        binding.rvHome.adapter=cityAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}