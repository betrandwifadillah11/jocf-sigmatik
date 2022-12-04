package com.jocfv1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jocfv1.home.Home
import com.jocfv1.login.LoginScreen
import com.jocfv1.login.LoginViewModel
import com.jocfv1.login.SignUpScreen

enum class LoginRoutes{
    Signup,
    Signin
}

enum class HomeRoutes{
    Home,
    Dashboard,
    ProfileTeam
}


@Composable
fun Navigation(
    navController : NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
){
    NavHost(
        navController = navController,
        startDestination = LoginRoutes.Signin.name
    ){
        composable(route = LoginRoutes.Signin.name){
            LoginScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name){
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.Signin.name){
                        inclusive = true
                    }
                }
            },

                loginViewModel = loginViewModel

            ) {
                navController.navigate(LoginRoutes.Signup.name){
                    launchSingleTop = true
                    popUpTo(LoginRoutes.Signin.name)
                }
            }
        }

        composable(route = LoginRoutes.Signup.name){
            SignUpScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name){
                    popUpTo(LoginRoutes.Signup.name){
                        inclusive = true
                    }
                }
            },

                loginViewModel = loginViewModel

            ) {
                navController.navigate(LoginRoutes.Signin.name)
            }
        }

        composable(route = HomeRoutes.Home.name){
            Home()
        }
    }
}