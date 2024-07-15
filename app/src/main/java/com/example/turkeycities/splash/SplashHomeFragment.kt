package com.example.turkeycities.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.turkeycities.base.BaseFragment
import com.example.turkeycities.databinding.FragmentSplashHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashHomeFragment : BaseFragment<FragmentSplashHomeBinding>(FragmentSplashHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forwardFragment()
    }

    private fun forwardFragment(){
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(SplashHomeFragmentDirections.actionSplashHomeFragmentToHomeFragment())
        }
    }
}