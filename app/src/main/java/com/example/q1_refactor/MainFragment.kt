package com.example.q1_refactor

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {
    val dataBase = DataBase()
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cheatBtn = view.findViewById<Button>(R.id.btn_cheat)
        val trueBtn = view.findViewById<Button>(R.id.btn_true)
        val falseBtn = view.findViewById<Button>(R.id.btn_false)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)
        val prevBtn = view.findViewById<Button>(R.id.btn_prev)
        val questionTextView = view.findViewById<TextView>(R.id.tv_quesion_main)
        val navConroller = findNavController()

        questionTextView.setText(getString(dataBase.questions[dataBase.numberOfQuestion]))
        if (dataBase.numberOfQuestion == 0)
            setDisableButton(prevBtn)

        nextBtn.setOnClickListener {
            dataBase.numberOfQuestion++
            if (dataBase.numberOfQuestion == 9)
                setDisableButton(nextBtn)
            setEnableButton(prevBtn)
            questionTextView.setText(getString(dataBase.questions[dataBase.numberOfQuestion]))

            if (dataBase.numberOfQuestion !in dataBase.state) {
                setEnableButton(trueBtn)
                setEnableButton(falseBtn)
            }
        }

        prevBtn.setOnClickListener {
            dataBase.numberOfQuestion--
            if (dataBase.numberOfQuestion == 0)
                setDisableButton(prevBtn)
            setEnableButton(nextBtn)
            questionTextView.setText(getString(dataBase.questions[dataBase.numberOfQuestion]))

            if (dataBase.numberOfQuestion !in dataBase.state) {
                setEnableButton(trueBtn)
                setEnableButton(falseBtn)
            }

        }

        trueBtn.setOnClickListener {
            if (dataBase.answers[dataBase.questions[dataBase.numberOfQuestion]] ?: false)
                Snackbar.make(view,"Correct",Snackbar.LENGTH_LONG)
                    .setAction("Hide",) {
                    }.show()
            else
                Snackbar.make(view,"Incorrect",Snackbar.LENGTH_LONG)
                    .setAction("Hide",) {
                    }.show()

            setDisableButton(trueBtn)
            setDisableButton(falseBtn)
            dataBase.state.add(dataBase.numberOfQuestion)

        }

        falseBtn.setOnClickListener {

            if (dataBase.answers[dataBase.questions[dataBase.numberOfQuestion]] ?: false)
                Snackbar.make(view,"Incorrect",Snackbar.LENGTH_LONG)
                    .setAction("Hide",) {
                    }.show()
            else
                Snackbar.make(view,"Correct",Snackbar.LENGTH_LONG)
                    .setAction("Hide",) {
                    }.show()

            setDisableButton(trueBtn)
            setDisableButton(falseBtn)
            dataBase.state.add(dataBase.numberOfQuestion)

        }

        cheatBtn.setOnClickListener {
            navConroller.navigate(R.id.action_mainFragment_to_childFragment)
        }
    }

    fun setDisableButton(b : Button) {
        b.isEnabled = false
        b.isClickable = false
        b.isFocusable = false
    }

    fun setEnableButton(b : Button) {
        b.isEnabled = true
        b.isClickable = true
        b.isFocusable = true
    }
}