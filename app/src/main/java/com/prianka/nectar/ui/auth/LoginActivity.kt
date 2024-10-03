package com.prianka.nectar.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.prianka.nectar.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBtn: MaterialButton
    private lateinit var signUpTraverse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        loginBtn = findViewById(R.id.login_btn)
        signUpTraverse = findViewById(R.id.sign_up_traverse)

        signUpTraverse.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


    }
}