package com.example.assignmentapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btn_start = findViewById<Button>(R.id.button_start)
        val et_text = findViewById<EditText>(R.id.edit_text)
        btn_start.setOnClickListener{
            if(et_text.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name!", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_text.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
