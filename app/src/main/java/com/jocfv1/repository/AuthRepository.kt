package com.jocfv1.repository

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository {

    val currentUser:FirebaseUser? = Firebase.auth.currentUser

    fun hasUSer():Boolean = Firebase.auth.currentUser != null

    fun getUser():String = Firebase.auth.currentUser?.uid.orEmpty()

    suspend fun createUser(
        email:String,
        password:String,
        onComplate:(Boolean) ->Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    onComplate.invoke(true)
                }else{
                    onComplate.invoke(false)
                }
            }.await()
    }

    suspend fun login(
        email:String,
        password:String,
        onComplate:(Boolean) ->Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    onComplate.invoke(true)
                }else{
                    onComplate.invoke(false)
                }
            }.await()
    }
}