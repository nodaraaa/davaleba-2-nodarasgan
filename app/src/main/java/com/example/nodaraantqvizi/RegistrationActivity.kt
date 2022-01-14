package com.example.davaleba2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nodaraantqvizi.R
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {


    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPassword2: EditText
    private lateinit var buttonRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        init()
        clickListener()
        check()

    }

    private fun init() {

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPassword2 = findViewById(R.id.editTextPassword2)
        buttonRegister = findViewById(R.id.buttonRegister)
    }


    private fun clickListener(){
        buttonRegister.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val repeatPassword = editTextPassword2.text.toString()

            if(email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()){
                Toast.makeText(this,   "ცარიელია!",Toast.LENGTH_LONG).show()

            }
        }

    }
    private fun check(){
        buttonRegister.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val repeatPassword = editTextPassword2.text.toString()

            if(repeatPassword != password){
                Toast.makeText(this,"რაღაც შეცდომაა!,შეიყვანეთ პაროლები ახლიდან",Toast.LENGTH_LONG).show()
            }else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"რეგისტრაცია წარმატებით განხორციელდა",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"რაღაც შეცდომაა!",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}