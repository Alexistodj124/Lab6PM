package com.uvg.lab6alexismesias

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class User(val usuarios: String, val password: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn(context: Context){
    val users = listOf(
        User("alexis", "alexis1"),
        User("isa", "isa2"),
        User("kelson", "kelson3"),
        // Add more user accounts as needed
    )
    fun findUserByEmail(emailToFind: String): User? {
        return users.find { it.usuarios == emailToFind }
    }
    var usuario by remember {
        mutableStateOf("")
    }
    var contrasena by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "USUARIO", modifier = Modifier.padding(start = 25.dp))
        TextField(
            value = usuario,
            onValueChange = { usuario = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            singleLine = true
        )
        Text(text = "Contraseña", modifier = Modifier.padding(start = 25.dp))
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {

            val foundUser = findUserByEmail(usuario)

            if (foundUser?.usuarios != null && foundUser?.password != null && contrasena == foundUser.password) {
                print("Usuario registrado:")
                navigateToSecondActivity(context)
            }
            else{
                print("Usuario no encontrado")
            }
        }) {
            Text(text = "Ingresar")
        }
    }

}
fun navigateToSecondActivity(context: Context) {
    val intent = Intent(context, MainActivity2::class.java)
    context.startActivity(intent)
}
@Composable
fun LogOut(context : Context) {
    Button(onClick = {
        navigateToFirstActivity(context)
    }) {
        Text(text = "LogOut")
    }
}
fun navigateToFirstActivity(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}



