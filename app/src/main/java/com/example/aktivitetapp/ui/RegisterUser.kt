package com.example.aktivitetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aktivitetapp.databinding.FragmentRegisterUserBinding


class RegisterUser : Fragment() {


    private lateinit var binding: FragmentRegisterUserBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRegisterUserBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return binding.root
    }


}