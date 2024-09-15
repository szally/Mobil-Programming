package com.example.assignmentapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition : Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0

    private var mUserNAme: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserNAme = intent.getStringExtra(Constants.USER_NAME)

        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)
        val btn_submit = findViewById<Button>(R.id.submit_button)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion(){

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)
        val btn_submit = findViewById<Button>(R.id.submit_button)

        val question = mQuestionsList!!.get(mCurrentPosition-1)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.max =  mQuestionsList!!.size
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + mQuestionsList!!.size

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)

        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour
    }

    private fun defaultOptionsView(){

        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0, option_one)
        options.add(1, option_two)
        options.add(2, option_three)
        options.add(3, option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = android.graphics.Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    override fun onClick(v: View?) {
        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)
        val btn_submit = findViewById<Button>(R.id.submit_button)

        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(option_one, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(option_two, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(option_three, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(option_four, 4)
            }
            R.id.submit_button -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserNAme)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        val option_one = findViewById<TextView>(R.id.tv_option_one)
        val option_two = findViewById<TextView>(R.id.tv_option_two)
        val option_three = findViewById<TextView>(R.id.tv_option_three)
        val option_four = findViewById<TextView>(R.id.tv_option_four)

        when(answer){
            1 ->{
                option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 ->{
                option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 ->{
                option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 ->{
                option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, android.graphics.Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border_bg)

    }
}