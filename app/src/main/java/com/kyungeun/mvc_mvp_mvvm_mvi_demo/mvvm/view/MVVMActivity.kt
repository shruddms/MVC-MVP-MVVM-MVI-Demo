package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.MainActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMvvmBinding
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.view.MVPResultActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel.MVVMViewModel
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel.eventObserve

class MVVMActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMvvmBinding
    private lateinit var viewModel: MVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MVVMViewModel::class.java)

        initObserve()

    }

    private fun initObserve() {
        viewModel.openEvent.eventObserve(this) {
            val intent = Intent(this, MVVMResultActivity::class.java)
            startActivity(intent)
        }

    }

}