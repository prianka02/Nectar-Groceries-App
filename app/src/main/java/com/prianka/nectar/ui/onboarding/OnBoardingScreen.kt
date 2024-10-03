package com.prianka.nectar.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.button.MaterialButton
import com.prianka.nectar.R
import com.prianka.nectar.ui.auth.VerificationActivity

class OnBoardingScreen : AppCompatActivity() {
    private lateinit var getStarted: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen)

        getStarted = findViewById(R.id.get_started)
        getStarted.setOnClickListener {
            navigateToSignIn()
        }


        // A function to hide NavigationBar
        hideSystemUI()

    }

    private fun navigateToSignIn() {
        val intent = Intent(this, VerificationActivity::class.java)
        startActivity(intent)
    }

    // Function to hide NavigationBar
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}