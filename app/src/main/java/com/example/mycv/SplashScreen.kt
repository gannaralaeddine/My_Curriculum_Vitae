package com.example.mycv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashScreen : AppCompatActivity()
{
    lateinit var topAnim: Animation
    lateinit var bottomAnim: Animation
    lateinit var cv: TextView
    lateinit var c_vitae: TextView

    companion object
    {
        var SPLASH_SCREEN:Long= 3000
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)
        cv = findViewById(R.id.cv)
        c_vitae = findViewById(R.id.cur_vitae)

        cv.setAnimation(topAnim)
        c_vitae.setAnimation(bottomAnim)

        Handler().postDelayed(Runnable {
            run {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        }, SPLASH_SCREEN)

    }
}