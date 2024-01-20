package com.example.digitalboonkar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.digitalboonkar.databinding.ActivitySignUpBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignUp : AppCompatActivity() {

    private val binding:ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
//    private lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        googleSignInClient = GoogleSignIn.getClient(this , gso)
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
//        googleSignInClient = GoogleSignIn.getClient(this , gso)

        binding.alreadyLoginTextview.setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
            finish()
        }

        binding.createAccountButton.setOnClickListener {
            val email = binding.emailEdittext.text.toString()
            val userName = binding.usernameEdittext.text.toString()
            val password = binding.passwordEdittext.text.toString()
            val re_password = binding.confirmPasswordEdittext.text.toString()

            if(email.isEmpty() || userName.isEmpty() || password.isEmpty() || re_password.isEmpty())
            {
                Toast.makeText(this , "Please fill the required Details" , Toast.LENGTH_SHORT).show()
            }
            else if (password != re_password)
            {
                Toast.makeText(this , "Kindly confirm your password correctly" , Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(this) {task ->
                    if(task.isSuccessful)
                    {
                        Toast.makeText(this , "Successfully created new account" , Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this , LogIn::class.java))
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this , "Registration failed : ${task.exception?.message}" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.googleLogoImageview.setOnClickListener {
            val signInClient = googleSignInClient.signInIntent
            launcher.launch(signInClient)
        }

//        binding.googleLogoImageview.setOnClickListener{
//            val signInClient = googleSignInClient.signInIntent
//            launcher.launch(signInClient)
//        }

    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
        result ->
        if(result.resultCode == Activity.RESULT_OK)
        {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            if (task.isSuccessful)
            {
                val account:GoogleSignInAccount?=task.result
                val credential = GoogleAuthProvider.getCredential(account?.idToken , null)
                auth.signInWithCredential(credential).addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        Toast.makeText(this , "logged In through google" , Toast.LENGTH_LONG).show()
                        startActivity(Intent(this , HomePage::class.java))
                    }
                    else
                    {
                        Toast.makeText(this , "Failed due to credential" , Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        else
        {
            Toast.makeText(this , "Failed due gso" , Toast.LENGTH_LONG).show()
        }
    }

//    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//        result ->
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
//                        Toast.makeText(this , "created new account successfully" , Toast.LENGTH_SHORT).show()
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



//    hello there
//  let's see 
}