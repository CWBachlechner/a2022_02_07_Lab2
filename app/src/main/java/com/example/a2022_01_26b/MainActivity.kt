package com.example.a2022_01_26b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a2022_01_26b.controllers.NextQuestion
import com.example.a2022_01_26b.model.Score

class MainActivity : AppCompatActivity() {

    var trueButton: Button? = null
    var falseButton: Button? = null
    var nextButton: Button? = null
    var questionText: TextView? = null
    var to_score_activity: TextView? = null

    private val doneButton: Button
        get() = findViewById(R.id.done_button)

    val nextQuestion: NextQuestion = NextQuestion()
    val scoreKeep: Score = Score()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)

        questionText = findViewById(R.id.questionTextView)
        to_score_activity = findViewById(R.id.to_score_activity)


        trueButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(baseContext,"Clicked TRUE", Toast.LENGTH_SHORT).show()
                val nextQuestionAsw = nextQuestion.trueFalseOr()
                if(nextQuestionAsw == true)
                    scoreKeep.inc()
                else
                    scoreKeep.dec()

                var num = scoreKeep.getScore().toString()
                num = "Score:$num"
                to_score_activity?.setText(num )
            }
        })

        falseButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(baseContext,"Clicked FALSE", Toast.LENGTH_SHORT).show()
                val nextQuestionAsw = nextQuestion.trueFalseOr()
                if(nextQuestionAsw == false)
                    scoreKeep.inc()
                else
                    scoreKeep.dec()

                var num = scoreKeep.getScore().toString()
                num = "Score:$num"
                to_score_activity?.setText(num )


            }
        })

        nextButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val nextQuestionIndex = nextQuestion.linearNextQuestion()
                questionText?.setText(nextQuestionIndex )
                Toast.makeText(baseContext,"Clicked NEXT", Toast.LENGTH_SHORT).show()

            }
        })


        doneButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {

                var num = scoreKeep.getScore().toString()
                num = "Final Score: $num"

                Intent(baseContext, ScoreActivity::class.java).also {
                        scoreActivity ->
                    scoreActivity.putExtra("FROM_MAIN", num)
                    startActivity(scoreActivity)
                }
            }
        })

    }
}