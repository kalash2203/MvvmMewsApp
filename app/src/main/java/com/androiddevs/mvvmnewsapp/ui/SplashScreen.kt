package com.androiddevs.mvvmnewsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.fireabse.FirestoreClass
import com.androiddevs.mvvmnewsapp.auth.SignInActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({

            // If the user is logged in once and did not logged out manually from the app.
            // So, next time when the user is coming into the app user will be redirected to MainScreen.
            // If user is not logged in or logout manually then user will  be redirected to the Login screen as usual.

            // Get the current logged in user id
            val currentUserID = FirestoreClass().getCurrentUserID()

            if (currentUserID.isNotEmpty()) {
                // Launch dashboard screen.
                startActivity(Intent(this, NewsActivity::class.java))
            } else {
                // Launch the Login Activity
                startActivity(Intent(this, SignInActivity::class.java))
            }
            finish()
        },2500)
    }
}