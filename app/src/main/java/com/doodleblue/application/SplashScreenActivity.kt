package com.doodleblue.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(Runnable {
            var intent= Intent(this@SplashScreenActivity,DashboradActivity::class.java)
            startActivity(intent)
            finish()
        },4000)
    }
}