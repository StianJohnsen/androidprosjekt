package com.example.aktivitetapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.aktivitetapp.MyApplication
import com.example.aktivitetapp.R
import com.example.aktivitetapp.databinding.FragmentRegisterUserBinding
import com.example.aktivitetapp.databinding.FragmentRegisterUserNumBinding
import com.example.aktivitetapp.viewmodel.MyViewModel
import com.example.aktivitetapp.viewmodel.TrainingViewModelFactory


class RegisterUser : Fragment() {
    private val args: RegisterUserArgs by navArgs()
    private lateinit var binding: FragmentRegisterUserBinding
    private val viewModel: MyViewModel by activityViewModels {
        TrainingViewModelFactory(
            (activity?.application as MyApplication).wholeRepo
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRegisterUserBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        Log.d("Heisann",args.phoneNum)
        binding.fragmentTextView.text = args.phoneNum
        return binding.root
    }

}