package com.example.aktivitetapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.aktivitetapp.MyApplication
import com.example.aktivitetapp.R
import com.example.aktivitetapp.databinding.FragmentRegisterUserNumBinding
import com.example.aktivitetapp.viewmodel.MyViewModel
import com.example.aktivitetapp.viewmodel.TrainingViewModelFactory

class RegisterUserNum : Fragment() {

    private lateinit var binding: FragmentRegisterUserNumBinding
    private val viewModel: MyViewModel by activityViewModels {
        TrainingViewModelFactory(
            (activity?.application as MyApplication).wholeRepo
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRegisterUserNumBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val fragmentArgument = binding.numField.text
        Log.d("Stian",fragmentArgument.toString())

        binding.registerUserNum.setOnClickListener { moveToNextFragment(fragmentArgument.toString()) }

        return binding.root
    }


    fun moveToNextFragment(phoneNum: String){
        Log.d("Stian",phoneNum)
        val action = RegisterUserNumDirections.actionRegisterUserNumToRegisterUser(phoneNum)
        findNavController().navigate(action)
    }

}