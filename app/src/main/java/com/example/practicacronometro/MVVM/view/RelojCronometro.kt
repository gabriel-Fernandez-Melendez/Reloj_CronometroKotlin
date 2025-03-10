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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.practicacronometro.MVVM.viewmodel.ViewModelRelojCronometro
import com.example.practicacronometro.R
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

val viewModel : ViewModelRelojCronometro = ViewModelRelojCronometro()



@RequiresApi(Build.VERSION_CODES.O) //hace falta esta notacion para cargar el reloj
@Composable
fun RelojCronometroPractica(modifier: Modifier =Modifier,viewModel: ViewModelRelojCronometro){
    //Estas dos variables y el launched effect es lo que lanza la corrutina que carga correctamente la actualizacion por segundo
    var hora by remember { mutableStateOf(LocalTime.now()) }
    var fecha by remember { mutableStateOf(LocalDate.now()) }
    var cuentaCronometro by remember { mutableStateOf(0) }
    var reloj by remember { mutableStateOf(false) }
    var cronometro by remember { mutableStateOf(false) }
    val minutos = TimeUnit.MILLISECONDS.toMinutes(cuentaCronometro.toLong())
    val segundos = TimeUnit.MILLISECONDS.toSeconds(cuentaCronometro.toLong()) % 60
    val milisegundos = cuentaCronometro % 1000 / 10
    var lanzar by remember { mutableStateOf(false) }
    LaunchedEffect(Unit)
    {
        while (true) {
            hora = LocalTime.now()
            fecha = LocalDate.now()
            delay(1000) // Cada segundo
        }
    }
    //este lanza el cronometro
    LaunchedEffect(lanzar)
    {

        while (lanzar) {
            delay(10)
            cuentaCronometro+=10
        }
    }


    Column(modifier = Modifier.fillMaxSize().background(Color.White).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {//podemos aqui arriba la declaracion que filtra que boton se pulso para cargar el reloh o el cronometro
        if(reloj){
            Text(text = "Reloj")
            Text(text = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss")))
            Text(text = fecha.toString())
        }
        if(cronometro){

            Text(text = String.format("%02d:%02d:%02d", minutos, segundos,milisegundos))
        }
        Spacer(Modifier.size(40.dp))
    Row()
        {
            Button(onClick = { //para que ejecute ambas tienen que ser declaradas ambas en lineas distintas
                reloj = relojValido(true)
                cronometro = false},
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
            Button(onClick = {
                cronometro= cronometroValido(true)
                reloj=false},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD7A652)))
            {
                Image(painter = painterResource(id = R.drawable.cronometro),
                    contentDescription = "reloj_imagen",
                    modifier = Modifier.size(30.dp))
                Spacer(Modifier.size(10.dp))
                Text(text = "Cronometro")
            }
        }
        Spacer(Modifier.size(20.dp))
        if(cronometro){
            Row()
            {
                Button(onClick = {lanzar=false},colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF105275)
                )) { Text(text = "Pausa") }
                Spacer(Modifier.size(10.dp))
                Button(onClick = {lanzar=true},colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF105275)
                )) { Text(text = "continuar")}
                Spacer(Modifier.size(10.dp))
                Button(onClick = {cuentaCronometro=0},colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF105275)
                )) {Text(text = "reiniciar") }
            }

        }
    }
}

fun relojValido(valor : Boolean):Boolean{
    if (valor){
        return true

    }

    return false
}
fun cronometroValido(valor : Boolean):Boolean{
    if (valor){
        return true
    }

    return false
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewLogin_Instagram() { RelojCronometroPractica(Modifier, viewModel)
}