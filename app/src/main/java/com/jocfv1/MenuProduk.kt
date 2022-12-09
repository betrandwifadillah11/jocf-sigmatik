package com.jocfv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jocfv1.ui.theme.Jocfv1Theme
import com.jocfv1.ui.theme.biru

class MenuProduk : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jocfv1Theme {

            }
        }
    }
}

@Composable
fun Produk(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu Produk")},
                backgroundColor = biru,
                contentColor = Color.White,
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Pencarian")
                    }
                }
            )
        }
    ) {
    }

}

@Preview (showSystemUi = true)
@Composable
fun PrevProduk(){
    Produk()
}
