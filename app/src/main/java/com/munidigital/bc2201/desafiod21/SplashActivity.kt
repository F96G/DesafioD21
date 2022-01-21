package com.munidigital.bc2201.desafiod21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import java.util.zip.Inflater

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DURATION: Long = 2000 // Setea el tiempo del splash en ms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_DURATION)

    }
}