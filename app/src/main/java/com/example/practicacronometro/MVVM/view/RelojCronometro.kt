package com.example.practicacronometro.MVVM.view

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicacronometro.R

@Composable
fun RelojCronometroPractica(modifier: Modifier =Modifier){
    Column(modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewLogin_Instagram() {
    RelojCronometroPractica(Modifier)
}