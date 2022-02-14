package com.tantei.androidguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    var score: Int = 0

    private val questionBank = listOf<Question>(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: called")
        
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.ture_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener{ view: View ->
            checkAnswer(true)
        }
        falseButton.setOnClickListener{ view: View ->
            checkAnswer(false)
        }
        nextButton.setOnClickListener{ view: View ->
            currentIndex = (currentIndex + 1) % questionBank.size;
            updateQuestion()
        }

        updateQuestion()

    }

    private fun updateQuestion() {
        updateButton()
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun updateButton() {
        if (questionBank[currentIndex].status !== QuestionStatus.UNREAD) {
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        } else {
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        }
    }

    private fun checkResult() {
        var flag: Boolean = false
        for (item in questionBank) {
            if (item.status == QuestionStatus.UNREAD) {
                score = 0
                flag = true
            } else if (item.status == QuestionStatus.CORRECT) {
                score++
            }
        }
        if (flag == false) {
            val result = score / questionBank.size * 100
            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {

        var correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast

        } else {
            R.string.incorrect_toast

        }
        questionBank[currentIndex].status = if ( userAnswer == correctAnswer)  QuestionStatus.CORRECT else  QuestionStatus.INCORRECT
        updateButton()
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()

        checkResult()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: called")
    }
}