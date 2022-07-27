package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvc.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvc.model.Memo

class MVCActivity : AppCompatActivity() {

    lateinit var titleEditText: EditText
    lateinit var contentsEditText: EditText
    lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        titleEditText = findViewById(R.id.titleEditText)
        contentsEditText = findViewById(R.id.contentsEditText)
        submitBtn = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {
            val model = Memo(titleEditText.text.toString(),contentsEditText.text.toString())

            val resultIntent = Intent(this, MVCResultActivity::class.java)
            resultIntent.putExtra("title",model.title)
            resultIntent.putExtra("contents",model.contents)
            startActivity(resultIntent)
        }
    }
}