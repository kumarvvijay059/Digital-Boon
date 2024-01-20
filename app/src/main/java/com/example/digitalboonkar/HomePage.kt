package com.example.digitalboonkar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalboonkar.databinding.ActivityHomePageBinding
import com.example.digitalboonkar.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class HomePage : AppCompatActivity() {

    private val binding: ActivityHomePageBinding by lazy {
        ActivityHomePageBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        val user = auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email
            val photoUrl = it.photoUrl

            // Check if user's email is verified
            val emailVerified = it.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = it.uid

            binding.displayUsernameTextview.text = email
        }


        val profileName = intent.getStringExtra("Username")
//        binding.displayUsernameTextview.text = profileName

        binding.signoutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this , LogIn::class.java))
            finish()

        }

        binding.addCredButton.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
            finish()
        }
    }
}