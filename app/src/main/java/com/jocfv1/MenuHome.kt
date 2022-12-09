package com.jocfv1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocfv1.ui.theme.Jocfv1Theme
import com.jocfv1.ui.theme.biru

class MenuHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jocfv1Theme {
            }
        }
    }
}


@Composable
fun Home(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home")},
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

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.img1), contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 20.dp)
                )

                Image(painter = painterResource(id = R.drawable.img1), contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 20.dp)
                )
            }
        }

        Row(
            Modifier
                .fillMaxSize()
                .padding(30.dp)
                .padding(bottom = 250.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            val mContext = LocalContext.current

            Button(onClick = { mContext.startActivities(arrayOf(Intent(mContext, MenuHome::class.java))) },
                colors = ButtonDefaults.buttonColors(backgroundColor = biru),
                shape = CircleShape,
                modifier = Modifier
                    .width(100.dp)
                    .height(60.dp)
                    .padding(top = 20.dp)
            ) {
                Text(
                    color = Color.White,
                    text = "Home"
                )
            }

            Button(onClick = { mContext.startActivities(arrayOf(Intent(mContext, MenuProduk::class.java))) },
                colors = ButtonDefaults.buttonColors(backgroundColor = biru),
                shape = CircleShape,
                modifier = Modifier
                    .width(100.dp)
                    .height(60.dp)
                    .padding(top = 20.dp)
            ) {
                Text(
                    color = Color.White,
                    text = "Produk"
                )
            }

            Button(onClick = { mContext.startActivities(arrayOf(Intent(mContext, DashborRoutes::class.java))) },
                colors = ButtonDefaults.buttonColors(backgroundColor = biru),
                shape = CircleShape,
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp)
                    .padding(top = 20.dp)
            ) {
                Text(
                    color = Color.White,
                    text = "Dashbor"
                )
            }

        }
    }

}

@Preview (showSystemUi = true)
@Composable
fun PrevHome(){
    Home()
}