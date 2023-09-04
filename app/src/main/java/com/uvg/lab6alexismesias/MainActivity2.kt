package com.uvg.lab6alexismesias

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

data class Nutri(
    @DrawableRes val imageResourceId: Int,
    val description: String
)
class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LogOut(context = context)
                Galeria()
            }
        }
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}
@Composable
fun LogOut(context: Context) {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ){
        Button(onClick = {
            navigateToFirstActivity(context)
        },modifier = Modifier.weight(2f)
        )
        {
            Text(text = "LogOut")
        }
    }

}
fun navigateToFirstActivity(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}


@Composable
fun Galeria(){
    var img by remember { mutableStateOf(1) }
    val imagen = listOf(
        Nutri(R.drawable.nutrisource_pure_vita_beef,"Pure Vita BEEF"),
        Nutri(R.drawable.nutrisource_pure_vita_chiken,"Pure Vita CHIKEN"),
        Nutri(R.drawable.nutrisource_pure_vita_salmon,"Pure Vita SALMON"),
        Nutri(R.drawable.nutrisource_pure_vita_pavo_camote_1,"Pure Vita PAVO"),
        Nutri(R.drawable.nutrisource_small_bites_adulto_chicken_rice,"Small Bites CHIKEN"),
        Nutri(R.drawable.nutrisource_senior,"SENIOR"),
        Nutri(R.drawable.nutrisource_small_medium_breed_puppy_chicken_rice,"Puppy CHIKEN"),
        Nutri(R.drawable.nutrisource_small_medium_puppy_grain_free,"Puppy Grain Free"),
        Nutri(R.drawable.nutrisource_super_performance,"Super Performance"),
        Nutri(R.drawable.nutrisource_trout_rice,"Trout Rice")

    )
    Column {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)

        ){

            val imgID = imagen[img-1].imageResourceId

            Image(
                painter = painterResource(id = imgID),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = imagen[img - 1].description,
                style = TextStyle(
                    fontSize = 35.sp
                )
                
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (img != 1) {
                Button(
                    onClick = {
                        img -= 1
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Anterior")
                }
            }

            if (img != 10) {
                Button(
                    onClick = {
                        img += 1
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Siguiente")
                }
            }
        }

    }
}


