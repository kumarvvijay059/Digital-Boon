package com.example.digitalboonkar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.digitalboonkar.databinding.ActivityLogInBinding
import com.example.digitalboonkar.databinding.ActivitySignUpBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class LogIn : AppCompatActivity() {

    private val binding: ActivityLogInBinding by lazy {
        ActivityLogInBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth
    //private lateinit var googleSignInClient: GoogleSignInClient

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if(currentUser != null)
        {
            Toast.makeText(this , "already logged In" , Toast.LENGTH_SHORT).show()
            startActivity(Intent(this , HomePage::class.java))
            finish()
        }
        else
        {
            Toast.makeText(this , "You need to login first" , Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
//        googleSignInClient = GoogleSignIn.getClient(this , gso)

        binding.createAccountTextview.setOnClickListener {
            startActivity(Intent(this , SignUp::class.java))
            finish()
        }

        binding.loginButton.setOnClickListener {
            val userName = binding.usernameEdittext.text.toString()
            val email = binding.emailEdittext.text.toString()
            val password = binding.passwordEdittext.text.toString()

            if (userName.isEmpty() || email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this , "Please fill all the required boxes" , Toast.LENGTH_SHORT).show()
            }
            else
            {
                auth.signInWithEmailAndPassword(email , password).addOnCompleteListener { task->
                    if(task.isSuccessful)
                    {
                        Toast.makeText(this , "Logged In Successfully" , Toast.LENGTH_SHORT).show()
                        val intent = Intent(this , HomePage::class.java)
                        intent.putExtra("Username", userName)
                        startActivity(intent)
//                        startActivity(Intent(this , MainPage::class.java))
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this , "Failed to logged In : ${task.exception?.message}" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

//        binding.googleLogoImageview.setOnClickListener {
//            val signInClient = googleSignInClient.signInIntent
//            launcher.launch(signInClient)
//        }

    }

//    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            result ->
//
//        if(result.resultCode == Activity.RESULT_OK)
//        {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//            if(task.isSuccessful)
//            {
//                val account : GoogleSignInAccount?=task.result
//                val credential = GoogleAuthProvider.getCredential(account?.idToken , null)
//                auth.signInWithCredential(credential).addOnCompleteListener {
//                    if(it.isSuccessful)
//                    {
//                        Toast.makeText(this , "logged in through google" , Toast.LENGTH_LONG).show()
//                    }
//                    else
//                    {
//                        Toast.makeText(this , "Failed...." , Toast.LENGTH_LONG).show()
//                    }
//                }
//            }
//        }
//        else
//        {
//            Toast.makeText(this , "Failed.." , Toast.LENGTH_LONG).show()
//        }
//    }

}