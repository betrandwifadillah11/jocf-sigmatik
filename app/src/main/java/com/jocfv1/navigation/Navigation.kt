package com.jocfv1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jocfv1.home.Dashbor
import com.jocfv1.login.LoginScreen
import com.jocfv1.login.LoginViewModel
import com.jocfv1.login.SignUpScreen

enum class LoginRoutes{
    Signup,
    Signin
}

enum class HomeRoutes{
    Home,
}

enum class DashborRoutes{
    Dashbor
}

enum class ProdukRoutes{
    Produk
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
                navController.navigate(DashborRoutes.Dashbor.name){
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
                navController.navigate(DashborRoutes.Dashbor.name){
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

        composable(route = DashborRoutes.Dashbor.name){
            Dashbor()
        }

        composable(route = HomeRoutes.Home.name){
            Home()
        }

        composable(route = ProdukRoutes.Produk.name){
            Produk()
        }
    }
}