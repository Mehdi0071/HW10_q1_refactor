package com.example.q1_refactor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChildFragment : Fragment(R.layout.fragment_child) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val answer = view.findViewById<TextView>(R.id.cheat_textview)
        val btn = view.findViewById<Button>(R.id.btn_showanswer)

        btn.setOnClickListener {
        }

    }
}