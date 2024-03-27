package com.example.week3login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn = findViewById<Button>(R.id.button_signup)
        val name = findViewById<EditText>(R.id.et_signup_name)
        val id = findViewById<EditText>(R.id.et_sigup_id)
        val password = findViewById<EditText>(R.id.et_sigup_password)

        btn.setOnClickListener {
            if (!name.text.isBlank() && !id.text.isBlank() && !password.text.isBlank()) {
                intent.putExtra("newID", "${id.text}")
                intent.putExtra("newPassword", "${password.text}")
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(getApplicationContext(), "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }
}


