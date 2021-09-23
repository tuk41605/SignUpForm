package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userinfo = findViewById<Button>(R.id.saveinfo)
        val nameinfo = findViewById<EditText>(R.id.nameBox)
        val emailinfo = findViewById<EditText>(R.id.emailBox)
        val passinfo = findViewById<EditText>(R.id.passwordBox)
        val rpassinfo = findViewById<EditText>(R.id.rpasswordbox)
        var formsfilled = false
        var passmatch = false

        userinfo.setOnClickListener {
            if (TextUtils.isEmpty(nameinfo.text.toString())) {
                nameinfo.setError("Name form is empty")
            }
            if (TextUtils.isEmpty(emailinfo.text.toString())) {
                emailinfo.setError("Email form is empty")
            }
            if (TextUtils.isEmpty(passinfo.text.toString())) {
                passinfo.setError("Password form is empty")
            }
            if (TextUtils.isEmpty(rpassinfo.text.toString())) {
                rpassinfo.setError("Password confirmation form is empty")
            }

            if (!TextUtils.isEmpty(nameinfo.text.toString()) && !TextUtils.isEmpty(emailinfo.text.toString()) && !TextUtils.isEmpty(passinfo.text.toString()) && !TextUtils.isEmpty(rpassinfo.text.toString())) {
                formsfilled = true
            }

            if (!TextUtils.isEmpty(passinfo.text.toString()) && !TextUtils.isEmpty(rpassinfo.text.toString()) && passinfo.text.toString() != rpassinfo.text.toString()) {
                passinfo.setError("Passwords do not match")
                rpassinfo.setError("Passwords do not match")
                passmatch = false
            }
            else {
                passmatch = true
            }

            if (formsfilled == true && passmatch == true)
            {
                Toast.makeText(this@FormActivity, "Welcome " + nameinfo.text + "!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}