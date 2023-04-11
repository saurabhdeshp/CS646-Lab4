package com.example.pizzapartyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pizzapartyapp.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnQuitApp: Button = findViewById(R.id.btn_quit_app)
        btnQuitApp.setOnClickListener {
            finishAffinity()
        }
    }
}
