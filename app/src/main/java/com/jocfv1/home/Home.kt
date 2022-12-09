package com.jocfv1.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocfv1.*
import com.jocfv1.R
import com.jocfv1.ui.theme.biru


@Composable
fun Dashbor(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu Dashbord")},
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
            Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(top = 150.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                val mContext = LocalContext.current

                Button(
                    onClick = { mContext.startActivities(arrayOf(Intent(mContext, MenuHome::class.java))) }
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(130.dp),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }

                Button(
                    onClick = { mContext.startActivities(arrayOf(Intent(mContext, MenuProduk::class.java))) }
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.ShoppingCart,
                        contentDescription = "Produk",
                        modifier = Modifier.size(130.dp)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                val mContext = LocalContext.current

                Button(
                    onClick = { mContext.startActivities(arrayOf(Intent(mContext, MenuHome::class.java))) }
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(130.dp),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }

                Button(
                    onClick = { mContext.startActivities(arrayOf(Intent(mContext, DashborRoutes::class.java))) }
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.List,
                        contentDescription = "Dashbord",
                        modifier = Modifier.size(130.dp)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }
            }
        }
    }

}






@Preview (showSystemUi = true)
@Composable
fun PrevDashbor(){
    Dashbor()
}

