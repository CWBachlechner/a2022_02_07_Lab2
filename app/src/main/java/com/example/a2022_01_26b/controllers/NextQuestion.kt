package com.example.a2022_01_26b.controllers

import com.example.a2022_01_26b.model.AllQuestions


class NextQuestion {

    private val allQestions: AllQuestions = AllQuestions()

    private var question: Int = 0
    private val total_qs: Int = allQestions.allQuestions.size


    public fun linearNextQuestion(): Int {
        question = (question+1) % total_qs
        return allQestions.allQuestions[question].index
    }

    public fun trueFalseOr(): Boolean {
        return allQestions.allQuestions[question].isTrue
    }

    public fun pseudoRandomNextQuestion(): Int {
        question = (question+1) % total_qs
        return allQestions.allQuestions[question].index
    }

}