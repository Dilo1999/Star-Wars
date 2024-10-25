package com.example.xiteb_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class welcome_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        // Delay for 3 seconds (3000 milliseconds) before navigating to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@welcome_page, MainActivity::class.java)
            startActivity(intent)
            finish() // Close welcome page so user can't go back to it
        }, 3000) // 3000 milliseconds = 3 seconds
    }
}
