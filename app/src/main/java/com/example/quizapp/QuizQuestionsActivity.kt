package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    //setting Global variables:

    private var myCurrentPosition: Int = 1
    private var myQuestionList: ArrayList<Question>? = null
    private var mySelectedQuestionPosition: Int = 0
    private var myUserName : String? = null
    private var myCorrectAnswer :Int=0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        myQuestionList = Constants.getQuestion()

        myUserName = intent.getStringExtra(Constants.User_Name)

        setQuestion()

        opt1?.setOnClickListener(this)//this means the class QuizQuestionsActivity is an onclick listener,
        // which it is as we have set View.OnClickListener above
        opt2?.setOnClickListener(this)
        opt3?.setOnClickListener(this)
        opt4?.setOnClickListener(this)
        quizAnswerBtn?.setOnClickListener(this)


    }

    private fun setQuestion() {
        defaultOption() //resets to default color value and screen when "next question" button is clicked

        val question: Question = myQuestionList!![myCurrentPosition - 1]
        progressBar?.progress =
            myCurrentPosition// when myCurrentPosition++ -> progress bar moves ahead
        progressBarCounter?.text = "$myCurrentPosition/${progressBar?.max}"
        quiz_question?.text = question.question
        quizQuestion_Img?.setImageResource(question.image)
        opt1?.text = question.option1
        opt2?.text = question.option2
        opt3?.text = question.option3
        opt4?.text = question.option4

        if (myCurrentPosition == myQuestionList!!.size) {
            quizAnswerBtn?.text = "Finish"
        } else {
            quizAnswerBtn?.text = "Submit"
        }
    }

    private fun defaultOption() {
        val options = ArrayList<TextView>()
        opt1?.let {
            options.add(0, it)
        }
        opt2?.let {
            options.add(0, it)
        }
        opt3?.let {
            options.add(0, it)
        }
        opt4?.let {
            options.add(0, it)
        }

        quizAnswerBtn?.text= "Submit"

        for (opt in options) {
            opt.typeface = Typeface.DEFAULT
            opt.setTextColor(Color.parseColor("#D3D3D3"))
            opt.background = ContextCompat.getDrawable(this, R.drawable.tv_when_not_selected)
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOption()
        mySelectedQuestionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FFBB86FC"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.tv_when_selected)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.opt1 -> {
                opt1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.opt2 -> {
                opt2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.opt3 -> {
                opt3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.opt4 -> {
                opt4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.quizAnswerBtn -> {
                if (mySelectedQuestionPosition == 0) {
                    myCurrentPosition++ // THIS IS RESPONSIBLE FOR THE SUBMIT BUTTON TO CHANGE TO NEXT QUESTION
                    when {
                        myCurrentPosition <= myQuestionList!!.size -> {
                            setQuestion()
                        }else ->{
                        val intent = Intent(this, Result_Page_Activity::class.java)
                        intent.putExtra(Constants.User_Name, myUserName)
                        intent.putExtra(Constants.Correct_Answer, myCorrectAnswer)
                        intent.putExtra(Constants.Total_Questions, myQuestionList?.size)

                        startActivity(intent)
                        finish()
                        }
                    }
                } else {
                    val question = myQuestionList?.get(myCurrentPosition - 1)
                    if (question!!.correctAnswer != mySelectedQuestionPosition) {
                        answerView(mySelectedQuestionPosition, R.drawable.wrong_answer_selected)
                    }else{
                            myCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.right_answer_selected)
                    if (myCurrentPosition == myQuestionList!!.size) {
                        quizAnswerBtn?.text = "Finish"
                    } else {
                        quizAnswerBtn?.text = "Next Question"


                    }
                }
                    mySelectedQuestionPosition=0
            }

        }
    }
        private fun answerView(answer: Int, stateChange: Int) {
            when (answer) {
                1 -> {
                    opt1?.background = ContextCompat.getDrawable(
                        this, stateChange
                    )
                }
                2 -> {
                    opt2?.background = ContextCompat.getDrawable(
                        this, stateChange
                    )
                }
                3 -> {
                    opt3?.background = ContextCompat.getDrawable(
                        this, stateChange
                    )
                }
                4 -> {
                    opt4?.background = ContextCompat.getDrawable(
                        this, stateChange
                    )
                }
            }
        }
    }



