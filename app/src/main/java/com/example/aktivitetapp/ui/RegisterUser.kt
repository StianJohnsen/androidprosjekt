package com.example.aktivitetapp.ui


import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.activityViewModels
import com.example.aktivitetapp.MyApplication
import com.example.aktivitetapp.databinding.FragmentRegisterPhoneNumBinding
import com.example.aktivitetapp.network.User
import com.example.aktivitetapp.viewmodel.MyViewModel
import com.example.aktivitetapp.viewmodel.TrainingViewModelFactory
import java.util.Calendar



class RegisterUser : Fragment() {

    var birthDate = ""

    private lateinit var binding: FragmentRegisterPhoneNumBinding
    private val viewModel: MyViewModel by activityViewModels {
        TrainingViewModelFactory(
            (activity?.application as MyApplication).wholeRepo
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRegisterPhoneNumBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //**viewModel.user.observe(this.viewLifecycleOwner){
        //    binding.userTextField.text = it.name
        //}



        binding.birthInput.setOnClickListener { showCalDialog() }
        binding.registerButton.setOnClickListener { addNewUser() }




        return binding.root
    }


    fun showCalDialog(){
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        var returnList = mutableListOf<String>()

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { view: DatePicker?, year: Int, month: Int, day: Int ->
                binding.birthInput.setText("$day -${month+1} - $year")
                birthDate = "$day"+"${month+1}"+"$year"
            },
            year,month,day
        )
        datePickerDialog.show()
    }

    fun addNewUser(){
        val newUser = User(phone = binding.phoneNumInput.text.toString(), email = binding.emailInput.text.toString(), name = binding.nameInput.text.toString(), birth_year = birthDate)
        viewModel.postUser(newUser)

    }

    fun checkIfUserExist(num: String){
        try {
            viewModel.getUserByNum(num)
        }catch (e: Throwable){

        }
    }


}