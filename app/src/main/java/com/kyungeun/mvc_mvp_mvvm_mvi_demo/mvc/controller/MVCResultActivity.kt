package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvc.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.MainActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMvcResultBinding

class MVCResultActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var contentsTextView: TextView
    lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc_result)

        titleTextView = findViewById(R.id.titleTextView)
        contentsTextView = findViewById(R.id.contentsTextView)
        nextBtn = findViewById(R.id.nextBtn)

        val title =  intent.extras?.get("title") as String
        val contents =  intent.extras?.get("contents") as String
        titleTextView.text = title
        contentsTextView.text = contents

        nextBtn.setOnClickListener {
            val mainIntent = Intent(this, MainActivity::class.java)
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(mainIntent)
        }
    }
}