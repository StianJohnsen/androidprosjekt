package com.example.aktivitetapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.aktivitetapp.network.User
import com.example.aktivitetapp.repository.WholeRepo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.jvm.Throws

class MyViewModel (private val repository: WholeRepo): ViewModel(){


    private var _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user



    fun getUser(id: Int){
        viewModelScope.launch {
            repository.getUser(id)
                .collect() {
                    _user.postValue(it)
                }
        }
    }

    fun postUser(user:User){
        viewModelScope.launch {
            try {
                repository.postUser(user)
                    .collect(){
                        _user.postValue(it)
                    }
            }catch (exception: HttpException){
                Log.d("training_app","http error")
                }
            }
        }
@Throws(Throwable::class)
    fun getUserByNum(num:String){
        viewModelScope.launch {
                repository.getUserByNum(num) // Vi har en bruker med et nummer
                    .collect(){
                        _user.postValue(it[0])
                    }
            }

            }
        }





class TrainingViewModelFactory(private val wholeRepo: WholeRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MyViewModel(wholeRepo) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }
}