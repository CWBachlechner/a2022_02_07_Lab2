package com.example.a2022_01_26b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a2022_01_26b.model.AllQuestions

class MainActivity : AppCompatActivity() {

    var trueButton: Button? = null
    var falseButton: Button? = null
    var nextButton: Button? = null
    var questionText: TextView? = null

    var question: Int = 0
    val allQestions: AllQuestions = AllQuestions()
    val total_qs: Int = allQestions.allQuestions.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)

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
                question = (question+1) % total_qs

                questionText?.setText(allQestions.allQuestions[question].index)
                Toast.makeText(baseContext,"Clicked NEXT", Toast.LENGTH_SHORT).show()

            }
        })


    }
}