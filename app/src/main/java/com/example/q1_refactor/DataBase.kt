package com.example.q1_refactor

import androidx.lifecycle.ViewModel

class DataBase : ViewModel() {
    var numberOfQuestion = 0
    val answers = mapOf<Int,Boolean>(
        R.string.q1 to true,
        R.string.q2 to false,
        R.string.q3 to true,
        R.string.q4 to true,
        R.string.q5 to false,
        R.string.q6 to true,
        R.string.q7 to false,
        R.string.q8 to false,
        R.string.q9 to true,
        R.string.q10 to true
    )
    val questions = listOf<Int>(
        R.string.q1,
        R.string.q2,
        R.string.q3,
        R.string.q4,
        R.string.q5,
        R.string.q6,
        R.string.q7,
        R.string.q8,
        R.string.q9,
        R.string.q10
    )
    val state = mutableListOf<Int>()

}