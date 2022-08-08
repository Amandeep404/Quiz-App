package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etname :EditText = findViewById(R.id.user_name)

        start_btn.setOnClickListener{
            if (etname.text.isEmpty()){
                Toast.makeText(this, "Enter your name to start quiz ", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.User_Name, etname.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}