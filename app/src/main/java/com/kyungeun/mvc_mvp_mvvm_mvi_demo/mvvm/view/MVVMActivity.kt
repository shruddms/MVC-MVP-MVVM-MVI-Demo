package com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.view

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.databinding.ActivityMvvmBinding
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvp.view.MVPResultActivity
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel.MVVMViewModel
import com.kyungeun.mvc_mvp_mvvm_mvi_demo.mvvm.viewmodel.eventObserve


class MVVMActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMvvmBinding

    private val viewModel: MVVMViewModel by lazy {
        ViewModelProvider(this).get(MVVMViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initObserve()
    }

    //변경된 데이터를 활용하여 View 업데이트 처리 동작
    @SuppressLint("SetTextI18n")
    private fun initObserve() {
        viewModel.liveData.observe(this, Observer { memo ->
            Log.d("liveData observe",memo.toString())
        })

        viewModel.openEvent.eventObserve(this) { memo ->
            Log.d("openEvent eventObserve",memo.toString())
            val resultIntent = Intent(this, MVVMResultActivity::class.java)
            resultIntent.putExtra("title",memo.title)
            resultIntent.putExtra("contents",memo.contents)
            startActivity(resultIntent)
        }
    }

}