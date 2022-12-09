package com.jocfv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jocfv1.login.LoginViewModel
import com.jocfv1.ui.theme.Jocfv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            Jocfv1Theme {
                Navigation(loginViewModel = loginViewModel)
            }
        }
    }
}

