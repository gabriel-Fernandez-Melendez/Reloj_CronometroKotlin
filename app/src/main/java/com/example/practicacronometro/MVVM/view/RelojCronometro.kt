package com.example.practicacronometro.MVVM.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicacronometro.MVVM.viewmodel.ViewModelRelojCronometro
import com.example.practicacronometro.R
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

val viewModel : ViewModelRelojCronometro = ViewModelRelojCronometro()
@RequiresApi(Build.VERSION_CODES.O) //hace falta esta notacion para cargar el reloj
@Composable
fun RelojCronometroPractica(modifier: Modifier =Modifier,viewModel: ViewModelRelojCronometro){
    var tiempo by remember { mutableStateOf(LocalTime.now()) }
    var dia by remember { mutableStateOf(LocalDate.now()) }

    Column(modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {//podemos aqui arriba la declaracion que filtra que boton se pulso para cargar el reloh o el cronometro
        if(viewModel.reloj.value==true){
            Text(text = "Reloj")
            Text(text = tiempo.format(DateTimeFormatter.ofPattern("HH:mm:ss")))
            Text(text = dia.toString())
        }
        if(viewModel.cronometro.value==true){

        }
        Spacer(Modifier.size(50.dp))
    Row()
        {
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD7A652)
            ) )
            {
                Image(painter = painterResource(id = R.drawable.reloj),
                contentDescription = "reloj_imagen",
                    modifier = Modifier.size(30.dp))
                Spacer(Modifier.size(10.dp))
                Text(text = "Reloj")
            }
            Spacer(Modifier.size(20.dp))
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD7A652)))
            {
                Image(painter = painterResource(id = R.drawable.cronometro),
                    contentDescription = "reloj_imagen",
                    modifier = Modifier.size(30.dp))
                Spacer(Modifier.size(10.dp))
                Text(text = "Cronometro")
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewLogin_Instagram() { RelojCronometroPractica(Modifier, viewModel)
}