package com.example.polihack.api

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("/user/login")
    suspend fun verifyAccount(@Body requestBody: RequestBody): Response<ResponseBody>

}