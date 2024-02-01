package com.betrybe.sociallogin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), TextWatcher {


    private val emailTextField: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val passwordTextField: TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }
    private val loginButton: Button by lazy { findViewById(R.id.login_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailTextField.editText?.addTextChangedListener(this)
        passwordTextField.editText?.addTextChangedListener(this)

    }

    private fun validateEmail(): Boolean {
        val email = emailTextField.editText?.text.toString().trim()
        return email.isNotEmpty()
    }

    private fun validatePassword(): Boolean {
        val password = passwordTextField.editText?.text.toString().trim()
        return password.isNotEmpty()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

    override fun afterTextChanged(p0: Editable?) {
        loginButton.isEnabled = validateEmail() && validatePassword()
    }
}
