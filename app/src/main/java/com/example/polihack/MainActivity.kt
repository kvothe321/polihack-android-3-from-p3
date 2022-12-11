package com.example.polihack

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.polihack.api.APIManager
import com.example.polihack.api.ServiceBuilder
import com.example.polihack.model.UserLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions()

        lifecycleScope.launch(Dispatchers.IO) {
            postJson()
        }

    }


    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestPermissions() {
        requestPermissions(
            arrayOf(
                Manifest.permission.BODY_SENSORS,
                Manifest.permission.FOREGROUND_SERVICE,
                Manifest.permission.ACTIVITY_RECOGNITION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), 0
        )
    }

    private fun postJson() {
        val userToLogin = UserLogin("rares", "Rares2022#@")

        val response = ServiceBuilder.buildService(APIManager::class.java)
        val call = response.login(userToLogin)

        call.enqueue(
            object : Callback<UserLogin?> {
                override fun onResponse(
                    call: Call<UserLogin?>,
                    response: Response<UserLogin?>
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        response.message().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<UserLogin?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                }

            }
        )
    }
}