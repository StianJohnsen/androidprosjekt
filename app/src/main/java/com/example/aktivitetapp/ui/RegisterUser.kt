package com.example.aktivitetapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.aktivitetapp.MyApplication
import com.example.aktivitetapp.databinding.FragmentRegisterUserBinding
import com.example.aktivitetapp.viewmodel.MyViewModel
import com.example.aktivitetapp.viewmodel.TrainingViewModelFactory


class RegisterUser : Fragment() {


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
        viewModel.user.observe(this.viewLifecycleOwner){
            binding.userTextField.text = it.name
        }

        return binding.root
    }


}