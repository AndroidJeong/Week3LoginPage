package com.example.week3login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {


    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val btn = findViewById<Button>(R.id.bt_signUp)

        btn.setOnClickListener {
            var intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            var id = findViewById<EditText>(R.id.et_id)
            var password = findViewById<EditText>(R.id.et_Password)
            val newId = it.data?.getStringExtra("newID") ?: "아이디 없음"
            val newPassword = it.data?.getStringExtra("newPassword") ?: "비밀번호 없음"

           if(it.resultCode == RESULT_OK) {
                id.setText(newId)
                password.setText(newPassword)
            }
        }

    }


    fun loginClicked(v:View) {
        var intent = Intent(this@SignInActivity, HomeActivity::class.java)
        var id = findViewById<EditText>(R.id.et_id)
        var password = findViewById<EditText>(R.id.et_Password)

        if (!id.text.isBlank() && !password.text.isBlank()) {
            Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show()
            intent.putExtra("id","${id.text}")
            startActivity(intent)
        } else {
            Toast.makeText(getApplicationContext(), "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()

        }


    }


}
