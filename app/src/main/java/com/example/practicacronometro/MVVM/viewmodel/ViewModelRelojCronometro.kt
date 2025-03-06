package com.example.practicacronometro.MVVM.viewmodel

import android.util.Log
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow



class ViewModelRelojCronometro : ViewModel(){
    //decraro estas dos variables pero como la funcionalidad de mostrar debe ser composable tengo que declarar esas funciones en el view
    private  val _Reloj = MutableLiveData(true)
    val reloj : LiveData<Boolean> = _Reloj

    private  val _Cronometro = MutableLiveData(true)
    val cronometro : LiveData<Boolean> = _Cronometro
}

