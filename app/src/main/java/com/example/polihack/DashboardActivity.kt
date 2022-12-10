package com.example.polihack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.polihack.view.DashboardFragment

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportFragmentManager.beginTransaction()
            .replace(R.id.dashboard_activity_container, DashboardFragment.getInstance())
    }
}