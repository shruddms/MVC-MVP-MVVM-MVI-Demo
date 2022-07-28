package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter.Contract
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.presenter.MVPPresenter


class MVPActivity : AppCompatActivity(), Contract.View {

    lateinit var titleEditText: EditText
    lateinit var contentsEditText: EditText
    lateinit var submitBtn: Button

    lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        presenter = MVPPresenter(this)

        titleEditText = findViewById(R.id.titleEditText)
        contentsEditText = findViewById(R.id.contentsEditText)
        submitBtn = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {

        }
    }



}