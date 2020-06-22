package com.agisti.submissionfundamental2.activity_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.agisti.submissionfundamental2.R

class SplashScreenActivity : AppCompatActivity() {
    val loading = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.title = ""

        Handler().postDelayed({
            val home = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(home)
            finish()
        }, loading.toLong())
    }
}