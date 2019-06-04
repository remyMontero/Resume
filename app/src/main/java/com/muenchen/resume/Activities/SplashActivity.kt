package com.muenchen.resume.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.muenchen.resume.MainActivity
import com.muenchen.resume.R

class SplashActivity : AppCompatActivity() {
    val SPLASH_TIME_OUT = 3000L;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler().postDelayed(displaySplash, SPLASH_TIME_OUT);
    }

    val displaySplash = Runnable{
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
        finish();
    }
}
