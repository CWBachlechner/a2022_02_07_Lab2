package com.example.a2022_01_26b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a2022_01_26b.controllers.NextQuestion
import com.example.a2022_01_26b.model.AllQuestions

class MainActivity : AppCompatActivity() {

    var trueButton: Button? = null
    var falseButton: Button? = null
    var nextButton: Button? = null
    var doneButton: Button? = null
    var questionText: TextView? = null

    val nextQuestion: NextQuestion = NextQuestion()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        doneButton = findViewById(R.id.done_button)

        questionText = findViewById(R.id.questionTextView)


        trueButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(baseContext,"Clicked TRUE", Toast.LENGTH_SHORT).show()
            }
        })

        falseButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(baseContext,"Clicked FALSE", Toast.LENGTH_SHORT).show()
            }
        })

        nextButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val nextQuestionIndex = nextQuestion.linearNextQuestion()
                questionText?.setText(nextQuestionIndex )
                Toast.makeText(baseContext,"Clicked NEXT", Toast.LENGTH_SHORT).show()

            }
        })

        doneButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.i("PGB","Done selected")
            }
        })


    }
}