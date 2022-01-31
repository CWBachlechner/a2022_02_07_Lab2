package com.example.a2022_01_26b.model

class Score {

    private var score: Int = 0

    fun inc(): Int {
        score += 1
        return score
    }

    fun dec(): Int {
        score -= 1
        return score
    }

}