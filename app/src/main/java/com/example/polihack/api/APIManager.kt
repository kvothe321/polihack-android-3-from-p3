package com.example.polihack.api

import com.example.polihack.model.UserLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIManager {
    @POST("users")
    fun login(@Body userData: UserLogin): Call<UserLogin?>
}