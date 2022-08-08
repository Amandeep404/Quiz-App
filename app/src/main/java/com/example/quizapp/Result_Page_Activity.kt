package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result_page.*

class Result_Page_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)


        var total_questions =intent.getIntExtra(Constants.Total_Questions, 0 )

        var correctAnswer = intent.getIntExtra(Constants.Correct_Answer, 0)

        userCongoName.text= intent.getStringExtra(Constants.User_Name)

        congo_score.text= "Your score is $correctAnswer out of $total_questions"

        congo_btn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}