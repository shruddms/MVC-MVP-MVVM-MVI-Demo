package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.MainActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.R
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMvvmResultBinding
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel.MVVMViewModel
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel.eventObserve

class MVVMResultActivity : AppCompatActivity() {

//    private lateinit var binding : ActivityMvvmResultBinding
    private val viewModel: MVVMViewModel by lazy {
        ViewModelProvider(this).get(MVVMViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_result)
//        binding.activity = this@MVVMResultActivity



    }


}