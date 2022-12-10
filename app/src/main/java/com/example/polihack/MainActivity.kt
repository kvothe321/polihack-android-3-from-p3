package com.example.polihack

import android.os.Bundle
import android.widget.Toast
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

        lifecycleScope.launch(Dispatchers.IO) {
            postJson()
        }
    }

    private suspend fun postJson() {
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