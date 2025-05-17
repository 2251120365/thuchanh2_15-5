package com.example.thuchanh2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var checkEmailButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailEditText)
        checkEmailButton = findViewById(R.id.checkEmailButton)
        resultTextView = findViewById(R.id.resultTextView)

        checkEmailButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            if (email.isEmpty()) {
                resultTextView.text = "Email không hợp lệ"
            } else if (!isValidEmailFormat(email)) {
                resultTextView.text = "Email không đúng định dạng"
            } else {
                resultTextView.text = "Email hợp lệ"
            }
        }
    }

    private fun isValidEmailFormat(email: String): Boolean {
        val pattern = Pattern.compile(
            "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        )
        return pattern.matcher(email).matches()
    }
}